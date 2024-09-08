package com.android.kuro.currencytracker.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ExchangeRate(
    val result: String,
    val documentation: String,
    val termsOfUse: String,
    val timeLastUpdateUnix: Long,
    val timeLastUpdateUtc: String,
    val timeNextUpdateUnix: Long,
    val timeNextUpdateUtc: String,
    val baseCode: String,
    val targetCode: String,
    val conversionRate: Double
)