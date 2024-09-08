package com.android.kuro.currencytracker.domain.repository

interface PreferencesRepository {
    var isOnBoardingDone: Boolean
    var nextSyncTime: Long
    var defaultCurrency: String

    fun clearPreferences()
}