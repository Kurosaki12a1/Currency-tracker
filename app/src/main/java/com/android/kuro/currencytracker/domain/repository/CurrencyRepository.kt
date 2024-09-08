package com.android.kuro.currencytracker.domain.repository

import com.android.kuro.currencytracker.domain.model.Currency

interface CurrencyRepository {
    suspend fun fetchAndSaveCurrency(baseCode: String)
    suspend fun getCurrencyByBaseCode(baseCode: String): Currency?
    suspend fun getAllCurrencies(): List<Currency>?
    suspend fun deleteCurrencyByBaseCode(baseCode: String)
    suspend fun deleteAllCurrencies()
}