package com.android.kuro.currencytracker.domain.use_case.currency

import com.android.kuro.currencytracker.domain.repository.CurrencyRepository
import javax.inject.Inject

/**
 * Use case for deleting a currency by its base code from the database.
 *
 * @property repository The repository to access the data.
 */
class DeleteCurrencyByBaseCodeUseCase @Inject constructor(
    private val repository: CurrencyRepository
) {
    /**
     * Executes the use case.
     *
     * @param baseCode The base currency code to delete.
     */
    suspend operator fun invoke(baseCode: String) {
        repository.deleteCurrencyByBaseCode(baseCode)
    }
}