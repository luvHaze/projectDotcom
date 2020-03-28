package luv.zoey.dotcom

import android.animation.AnimatorInflater
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_intro.*
import kotlin.concurrent.thread

class IntroActivity : AppCompatActivity() {

    private var handler: Handler? = null
    private var runnable: Runnable? = null
    private var anim_fadein : Animation? = null


    override fun onStart() {
        super.onStart()
        anim_fadein= AnimationUtils.loadAnimation(this, R.anim.fadein)
        intro_logo.startAnimation(anim_fadein)
        startApp()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
    }

    fun startApp() {

        runnable = Runnable {
            var intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
        handler = Handler()
        handler?.run {
            postDelayed(runnable, 2000)
        }

    }

    override fun onPause() {
        super.onPause()

        handler?.removeCallbacks(runnable)
    }
}
