package com.android.kuro.currencytracker.domain.use_case.currency

import com.android.kuro.currencytracker.domain.model.Currency
import com.android.kuro.currencytracker.domain.repository.CurrencyRepository
import javax.inject.Inject

/**
 * Use case for retrieving a currency by its base code from the database.
 *
 * @property repository The repository to access the data.
 */
class GetCurrencyByBaseCodeUseCase @Inject constructor(
    private val repository: CurrencyRepository
) {
    /**
     * Executes the use case.
     *
     * @param baseCode The base currency code to retrieve.
     * @return The latest updated currency associated with the base code or null if not found.
     */
    suspend operator fun invoke(baseCode: String): Currency? {
        return repository.getCurrencyByBaseCode(baseCode)
    }
}