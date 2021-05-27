package com.thorin.ngemovieeuy.splashactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatDelegate
import com.thorin.ngemovieeuy.MenuActivity
import com.thorin.ngemovieeuy.R
import com.thorin.ngemovieeuy.setting.SettingSharedPref

class SplashActivity : AppCompatActivity() {

    private lateinit var sharedpref: SettingSharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        isNightMode()

        Handler(Looper.getMainLooper()).postDelayed({
            val myIntent = Intent(this, MenuActivity::class.java)
            startActivity(myIntent)
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
            finish()
        }, 3000)

    }

    private fun isNightMode() {
        sharedpref = SettingSharedPref(this)
        if (sharedpref.loadNightModeState()) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

}