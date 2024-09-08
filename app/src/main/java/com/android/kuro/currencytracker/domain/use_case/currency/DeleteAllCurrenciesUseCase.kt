package com.android.kuro.currencytracker.domain.use_case.currency

import com.android.kuro.currencytracker.domain.repository.CurrencyRepository
import javax.inject.Inject

/**
 * Use case for deleting all currencies from the database.
 *
 * @property repository The repository to access the data.
 */
class DeleteAllCurrenciesUseCase @Inject constructor(
    private val repository: CurrencyRepository
) {
    /**
     * Executes the use case.
     */
    suspend operator fun invoke() {
        repository.deleteAllCurrencies()
    }
}