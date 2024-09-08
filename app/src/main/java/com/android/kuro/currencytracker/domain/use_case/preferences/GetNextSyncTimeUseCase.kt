package com.android.kuro.currencytracker.domain.use_case.preferences

import com.android.kuro.currencytracker.domain.repository.PreferencesRepository
import javax.inject.Inject

/**
 * Use case to get the next sync time.
 *
 * @property repository The repository to access shared preferences.
 */
class GetNextSyncTimeUseCase @Inject constructor(
    private val repository: PreferencesRepository
) {
    /**
     * Retrieves the next sync time.
     *
     * @return The next sync time in milliseconds.
     */
    operator fun invoke(): Long {
        return repository.nextSyncTime
    }
}