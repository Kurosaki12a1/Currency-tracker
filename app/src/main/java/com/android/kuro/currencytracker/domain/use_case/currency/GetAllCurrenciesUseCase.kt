package com.android.kuro.currencytracker.domain.use_case.currency

import com.android.kuro.currencytracker.domain.model.Currency
import com.android.kuro.currencytracker.domain.repository.CurrencyRepository
import javax.inject.Inject

/**
 * Use case for retrieving all currencies from the database.
 *
 * @property repository The repository to access the data.
 */
class GetAllCurrenciesUseCase @Inject constructor(
    private val repository: CurrencyRepository
) {
    /**
     * Executes the use case.
     *
     * @return A list of all currencies.
     */
    suspend operator fun invoke(): List<Currency> {
        return repository.getAllCurrencies() ?: listOf()
    }
}