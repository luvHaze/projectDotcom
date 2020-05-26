package luv.zoey.dotcom

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.Extractor
import com.google.android.exoplayer2.extractor.ExtractorsFactory
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.ads.AdsMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.*
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.login_set.*


class LoginActivity : AppCompatActivity() {

    private var player: SimpleExoPlayer? = null
    lateinit var dataSourceFactory: DefaultDataSourceFactory
    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_Button.setOnClickListener {
            startActivity(Intent(this,MenuActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT > 23) {
            initializePlayer()
            Log.d("onStart", "onStart in")
        }
    }

    override fun onResume() {
        super.onResume()
        hideSystemUi()
        if (Util.SDK_INT <= 23 || player == null) {
            initializePlayer()
            Log.d("onResume", "onResume in")
        }
    }

    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT <= 23) {
            releasePlayer()
            Log.d("onPause", "onPause in")
        }
    }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT > 23) {
            releasePlayer()
            Log.d("onStop", "onStop in")
        }
    }

    fun initializePlayer() {

        player = ExoPlayerFactory.newSimpleInstance(this)
        playerView.player = player

        dataSourceFactory = DefaultDataSourceFactory(
            this,
            Util.getUserAgent(this, "luv.zoey.exoplayertest")
        )

        val source = buildMediaSource()

        player!!.playWhenReady = playWhenReady
        player!!.seekTo(currentWindow, playbackPosition)
        player!!.prepare(source, false, false)
        // 무한루핑
        player!!.repeatMode = ExoPlayer.REPEAT_MODE_ALL
    }


    private fun buildMediaSource(): MediaSource {

        val rawDataSource = RawResourceDataSource(this)

        rawDataSource.open(DataSpec(RawResourceDataSource.buildRawResourceUri(R.raw.vi2)))

        return ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(rawDataSource.uri)
    }

    private fun releasePlayer() {
        if (player != null) {
            playbackPosition = player!!.currentPosition
            currentWindow = player!!.currentWindowIndex
            playWhenReady = player!!.playWhenReady
            player!!.release()
            player = null
        }
    }

    @SuppressLint("InlinedApi")
    private fun hideSystemUi() {
        playerView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LOW_PROFILE
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                )
    }

}
