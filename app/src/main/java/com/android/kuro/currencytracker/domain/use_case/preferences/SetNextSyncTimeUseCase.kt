package com.android.kuro.currencytracker.domain.use_case.preferences

import com.android.kuro.currencytracker.domain.repository.PreferencesRepository
import javax.inject.Inject

/**
 * Use case to set the next sync time.
 *
 * @property repository The repository to access shared preferences.
 */
class SetNextSyncTimeUseCase @Inject constructor(
    private val repository: PreferencesRepository
) {
    /**
     * Sets the next sync time.
     *
     * @param nextSyncTime The next sync time in milliseconds.
     */
    operator fun invoke(nextSyncTime: Long) {
        repository.nextSyncTime = nextSyncTime
    }
}