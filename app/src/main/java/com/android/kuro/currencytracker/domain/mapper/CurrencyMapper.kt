package com.android.kuro.currencytracker.domain.mapper

import com.android.kuro.currencytracker.common.Constants.DOCUMENTATION_URL
import com.android.kuro.currencytracker.common.Constants.TERM_OF_USE
import com.android.kuro.currencytracker.data.model.entity.CurrencyEntity
import com.android.kuro.currencytracker.data.model.response.CurrencyResponse
import com.android.kuro.currencytracker.domain.model.Currency

fun CurrencyResponse.toCurrency(): Currency {
    return Currency(
        result = result ?: "", // Sử dụng "" nếu null
        documentation = documentation ?: "", // Sử dụng "" nếu null
        termsOfUse = termsOfUse ?: "", // Sử dụng "" nếu null
        timeLastUpdateUnix = timeLastUpdateUnix ?: 0L, // Sử dụng 0L nếu null
        timeLastUpdateUtc = timeLastUpdateUtc ?: "", // Sử dụng "" nếu null
        timeNextUpdateUnix = timeNextUpdateUnix ?: 0L, // Sử dụng 0L nếu null
        timeNextUpdateUtc = timeNextUpdateUtc ?: "", // Sử dụng "" nếu null
        baseCode = baseCode ?: "", // Sử dụng "" nếu null
        conversionRates = conversionRates ?: mapOf() // Sử dụng map trống nếu null
    )
}

fun CurrencyResponse.toCurrencyEntity(): CurrencyEntity {
    return CurrencyEntity(
        baseCode = baseCode ?: "", // Sử dụng "" nếu null
        result = result ?: "", // Sử dụng "" nếu null
        timeLastUpdateUnix = timeLastUpdateUnix ?: 0L, // Sử dụng 0L nếu null
        timeLastUpdateUtc = timeLastUpdateUtc ?: "", // Sử dụng "" nếu null
        timeNextUpdateUnix = timeNextUpdateUnix ?: 0L, // Sử dụng 0L nếu null
        timeNextUpdateUtc = timeNextUpdateUtc ?: "", // Sử dụng "" nếu null
        conversionRates = conversionRates ?: mapOf() // Sử dụng map trống nếu null
    )
}

fun CurrencyEntity.toCurrency(): Currency {
    return Currency(
        baseCode = baseCode,
        documentation = DOCUMENTATION_URL,
        termsOfUse = TERM_OF_USE,
        result = result,
        timeLastUpdateUnix = timeLastUpdateUnix,
        timeLastUpdateUtc = timeLastUpdateUtc,
        timeNextUpdateUnix = timeNextUpdateUnix,
        timeNextUpdateUtc = timeNextUpdateUtc,
        conversionRates = conversionRates
    )
}