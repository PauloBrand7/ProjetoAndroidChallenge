package com.desafio.githubchallenge.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.desafio.githubchallenge.R

@Suppress("DEPRECATION")
class SplashActivity : AppCompatActivity() {
    companion object{
        private const val splashTimeOut : Long = 3000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.hide()

        Handler().postDelayed({
            val intentMain = Intent(this,MainActivity::class.java)
            startActivity(intentMain)
        }, splashTimeOut)
    }

}
