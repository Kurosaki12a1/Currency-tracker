package com.android.kuro.currencytracker.data.repository

import com.android.kuro.currencytracker.data.data_source.database.preferences.AppPreferences
import com.android.kuro.currencytracker.domain.repository.PreferencesRepository
import javax.inject.Inject

class PreferencesRepositoryImpl @Inject constructor(
    private val appPreferences: AppPreferences
) : PreferencesRepository {
    override var isOnBoardingDone: Boolean
        get() = appPreferences.isOnBoardingDone
        set(value) {
            appPreferences.isOnBoardingDone = value
        }

    override var nextSyncTime: Long
        get() = appPreferences.nextSyncTime
        set(value) {
            appPreferences.nextSyncTime = value
        }

    override var defaultCurrency: String
        get() = appPreferences.defaultCurrency
        set(value) {
            appPreferences.defaultCurrency = value
        }

    override fun clearPreferences() {
        appPreferences.clearPreferences()
    }
}