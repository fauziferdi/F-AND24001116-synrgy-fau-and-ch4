package com.example.fauzi_chalange_chapter4.data.datasource.local

import android.content.SharedPreferences
import com.example.fauzi_chalange_chapter4.data.datasource.AuthLocalDataSource

class AuthLocalDataSourceImpl (
    private val sharedPreferences: SharedPreferences,
) : AuthLocalDataSource {

    companion object{
        const val KEY_LOG = "logtoken"
    }

    override fun saveToken(logtoken: String) {
        sharedPreferences.edit().putString(KEY_LOG, logtoken).apply()
    }

    override fun loadToken(): String? {
        return  sharedPreferences.getString(KEY_LOG, null)
    }

    override fun clearToken() {
        sharedPreferences.edit().remove(KEY_LOG).apply()
    }



}