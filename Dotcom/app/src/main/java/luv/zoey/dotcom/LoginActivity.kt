package luv.zoey.dotcom

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.DisplayMetrics
import android.view.WindowManager
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.Extractor
import com.google.android.exoplayer2.extractor.ExtractorsFactory
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ads.AdsMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.util.Util
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.login_set.*


class LoginActivity : AppCompatActivity() {

    private var TAG = "LoginActivity"
    private lateinit var mVideoView : VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

         mVideoView = findViewById(R.id.videoView)

        val uri = Uri.parse("android.resource://${packageName}/${R.raw.vi0}")

        mVideoView.setVideoURI(uri)

        mVideoView.start()

        //loop
        mVideoView.setOnPreparedListener {
            it.isLooping =true
        }

        login_Button.setOnClickListener {
            startActivity(Intent(this,MenuActivity::class.java))
        }
    }

}
