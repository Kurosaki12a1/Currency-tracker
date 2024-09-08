package com.android.kuro.currencytracker.domain.use_case.currency

import com.android.kuro.currencytracker.domain.repository.CurrencyRepository
import javax.inject.Inject


/**
 * Use case for fetching currency data from the API and saving it to the database.
 *
 * @property repository The repository to access the data.
 */
class FetchAndSaveCurrencyUseCase @Inject constructor(
    private val repository: CurrencyRepository
) {
    /**
     * Executes the use case.
     *
     * @param baseCurrency The base currency code to fetch data for.
     */
    suspend operator fun invoke(baseCurrency: String) {
        repository.fetchAndSaveCurrency(baseCurrency)
    }
}