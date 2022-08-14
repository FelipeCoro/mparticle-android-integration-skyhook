package com.mparticle.kits

import android.content.Context
import android.content.SharedPreferences
import com.mparticle.MParticle

// Needed to store the API key for the boot receiver
internal class SkyhookPreferences(context: Context) {
    private val _prefs: SharedPreferences
    var apiKey: String?
        get() = _prefs.getString(PREFERENCE_API_KEY, null)
        set(apiKey) {
            _prefs.edit().putString(PREFERENCE_API_KEY, apiKey).apply()
        }

    fun clearApiKey() {
        _prefs.edit().remove(PREFERENCE_API_KEY).apply()
    }

    companion object {
        private const val PREFERENCES_FILE = "mp::kit::" + MParticle.ServiceProviders.SKYHOOK
        private const val PREFERENCE_API_KEY = "apiKey"
    }

    init {
        _prefs = context.getSharedPreferences(PREFERENCES_FILE, Context.MODE_PRIVATE)
    }
}
