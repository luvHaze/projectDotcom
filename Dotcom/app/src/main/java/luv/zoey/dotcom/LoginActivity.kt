package luv.zoey.dotcom

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.DisplayMetrics
import android.view.WindowManager
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity


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

    }
}
