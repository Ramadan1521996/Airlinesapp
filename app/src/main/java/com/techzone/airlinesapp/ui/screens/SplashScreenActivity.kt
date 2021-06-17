package com.techzone.airlinesapp.ui.screens

import android.content.Intent
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.techzone.airlinesapp.R

class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_TIME = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val logoImage = findViewById<ImageView>(R.id.logo_image)
        val timer: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(SPLASH_TIME.toLong())
                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    val intent = Intent(this@SplashScreenActivity, AirlineActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        timer.start()
        val myanim2 = AnimationUtils.loadAnimation(this, R.anim.crossfade)
        logoImage.startAnimation(myanim2)
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
}