package com.thorin.ngemovieeuy.setting

import android.content.Context
import android.content.SharedPreferences

class SettingSharedPref(context: Context) {

    private var mySharedPref: SharedPreferences =
        context.getSharedPreferences("filename", Context.MODE_PRIVATE)

    fun setNightModeState(state: Boolean) {
        val editor = mySharedPref.edit()
        editor.putBoolean("NightMode", state)
        editor.apply()
    }

    fun loadNightModeState(): Boolean {
        return mySharedPref.getBoolean("NightMode", false)
    }

}