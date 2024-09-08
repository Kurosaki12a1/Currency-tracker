package com.android.kuro.currencytracker.domain.use_case.preferences

import com.android.kuro.currencytracker.domain.repository.PreferencesRepository
import javax.inject.Inject

/**
 * Use case to clear all preferences.
 *
 * @property repository The repository to access shared preferences.
 */
class ClearPreferencesUseCase @Inject constructor(
    private val repository: PreferencesRepository
) {
    /**
     * Clears all stored preferences.
     */
    operator fun invoke() {
        repository.clearPreferences()
    }
}