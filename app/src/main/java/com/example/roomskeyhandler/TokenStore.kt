package com.example.roomskeyhandler

import android.content.Context

class TokenStore(private val context: Context) {
    private val PREFS_NAME = "MyApp"
    private val KEY_TOKEN = "token"

    private val preferences by lazy {
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun saveToken(token: String) {
        preferences.edit().putString(KEY_TOKEN, token).apply()
    }

    fun getToken(): String? {
        return preferences.getString(KEY_TOKEN, null)
    }

    fun clearToken() {
        preferences.edit().remove(KEY_TOKEN).apply()
    }
}