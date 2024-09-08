package com.android.kuro.currencytracker.domain.use_case.preferences

import com.android.kuro.currencytracker.domain.repository.PreferencesRepository
import javax.inject.Inject

/**
 * Use case to get the default currency.
 *
 * @property repository The repository to access shared preferences.
 */
class GetDefaultCurrencyUseCase @Inject constructor(
    private val repository: PreferencesRepository
) {
    /**
     * Retrieves the default currency.
     *
     * @return The default currency code.
     */
    operator fun invoke(): String {
        return repository.defaultCurrency
    }
}