package com.android.kuro.currencytracker.domain.use_case.preferences

import com.android.kuro.currencytracker.domain.repository.PreferencesRepository
import javax.inject.Inject

/**
 * Use case to set the default currency.
 *
 * @property repository The repository to access shared preferences.
 */
class SetDefaultCurrencyUseCase @Inject constructor(
    private val repository: PreferencesRepository
) {
    /**
     * Sets the default currency.
     *
     * @param currency The default currency code.
     */
    operator fun invoke(currency: String) {
        repository.defaultCurrency = currency
    }
}