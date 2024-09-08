package com.android.kuro.currencytracker.data.data_source.database.preferences

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AppPreferences @Inject constructor(@ApplicationContext val context: Context) {
    companion object {
        private const val APP_PREFERENCES_NAME = "Currency-Tracker-cache"
        private const val MODE = Context.MODE_PRIVATE

        private const val ONBOARDING = "onboarding"
        private const val DEFAULT_CURRENCY = "default_currency"
        private const val NEXT_SYNC_TIME = "next_sync_time"

    }

    private val appPreferences: SharedPreferences =
        context.getSharedPreferences(APP_PREFERENCES_NAME, MODE)

    /**
     * SharedPreferences extension function, so we won't need to call edit() and apply()
     * ourselves on every SharedPreferences operation.
     */
    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var isOnBoardingDone: Boolean
        get() = appPreferences.getBoolean(ONBOARDING, false)
        set(value) = appPreferences.edit {
            it.putBoolean(ONBOARDING, value)
        }

    var nextSyncTime: Long
        get() = appPreferences.getLong(NEXT_SYNC_TIME, System.currentTimeMillis())
        set(value) = appPreferences.edit {
            it.putLong(NEXT_SYNC_TIME, value)
        }

    var defaultCurrency: String
        get() = appPreferences.getString(DEFAULT_CURRENCY, "VND").toString()
        set(value) = appPreferences.edit {
            it.putString(DEFAULT_CURRENCY, value)
        }


    fun clearPreferences() {
        appPreferences.edit {
            it.clear().apply()
        }
    }
}