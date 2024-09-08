package com.android.kuro.currencytracker.domain.mapper

import com.android.kuro.currencytracker.data.model.response.ExchangeRateResponse
import com.android.kuro.currencytracker.domain.model.ExchangeRate


fun ExchangeRateResponse.toExchangeRate(): ExchangeRate {
    return ExchangeRate(
        result = result ?: "", // Sử dụng "" nếu null
        documentation = documentation ?: "", // Sử dụng "" nếu null
        termsOfUse = termsOfUse ?: "", // Sử dụng "" nếu null
        timeLastUpdateUnix = timeLastUpdateUnix ?: 0L, // Sử dụng 0L nếu null
        timeLastUpdateUtc = timeLastUpdateUtc ?: "", // Sử dụng "" nếu null
        timeNextUpdateUnix = timeNextUpdateUnix ?: 0L, // Sử dụng 0L nếu null
        timeNextUpdateUtc = timeNextUpdateUtc ?: "", // Sử dụng "" nếu null
        baseCode = baseCode ?: "", // Sử dụng "" nếu null
        targetCode = targetCode ?: "", // Sử dụng "" nếu null
        conversionRate = conversionRate ?: 0.0 // Sử dụng 0.0 nếu null
    )
}