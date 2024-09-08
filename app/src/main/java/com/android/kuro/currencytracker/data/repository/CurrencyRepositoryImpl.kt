package com.android.kuro.currencytracker.data.repository

import com.android.kuro.currencytracker.data.data_source.database.dao.CurrencyDao
import com.android.kuro.currencytracker.data.data_source.network.api.CurrencyAPI
import com.android.kuro.currencytracker.domain.mapper.toCurrency
import com.android.kuro.currencytracker.domain.mapper.toCurrencyEntity
import com.android.kuro.currencytracker.domain.model.Currency
import com.android.kuro.currencytracker.domain.repository.CurrencyRepository
import javax.inject.Inject

class CurrencyRepositoryImpl @Inject constructor(
    private val currencyApi: CurrencyAPI,
    private val currencyDao: CurrencyDao
) : CurrencyRepository {
    override suspend fun fetchAndSaveCurrency(baseCode: String) {
        // Fetch data from the API
        val response = currencyApi.getConversation(baseCode)

        // Map from CurrencyResponse (DTO) to CurrencyEntity (Entity)
        val currency = response.toCurrencyEntity()

        // Insert or update data in Room database
        currencyDao.insertOrUpdateCurrency(currency)
    }

    override suspend fun getCurrencyByBaseCode(baseCode: String): Currency? {
        // Fetch CurrencyEntity from DB
        val currencyEntity = currencyDao.getCurrencyByBaseCode(baseCode)
        // Map from CurrencyEntity to Currency (Model)
        return currencyEntity?.toCurrency()
    }

    override suspend fun getAllCurrencies(): List<Currency> {
        // Fetch all CurrencyEntity from DB
        val currencyEntities = currencyDao.getAllCurrencies()
        // Map all CurrencyEntity to Currency (Model)
        return currencyEntities.map { it.toCurrency() }
    }

    override suspend fun deleteCurrencyByBaseCode(baseCode: String) {
        currencyDao.deleteCurrencyByBaseCode(baseCode)
    }

    override suspend fun deleteAllCurrencies() {
        currencyDao.deleteAllCurrencies()
    }
}