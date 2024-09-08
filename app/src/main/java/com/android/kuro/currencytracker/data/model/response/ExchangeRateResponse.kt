package com.android.kuro.currencytracker.data.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExchangeRateResponse(
    @SerialName("result") val result: String?,
    @SerialName("documentation") val documentation: String?,
    @SerialName("terms_of_use") val termsOfUse: String?,
    @SerialName("time_last_update_unix") val timeLastUpdateUnix: Long?,
    @SerialName("time_last_update_utc") val timeLastUpdateUtc: String?,
    @SerialName("time_next_update_unix") val timeNextUpdateUnix: Long?,
    @SerialName("time_next_update_utc") val timeNextUpdateUtc: String?,
    @SerialName("base_code") val baseCode: String?,
    @SerialName("target_code") val targetCode: String?,
    @SerialName("conversion_rate") val conversionRate: Double?
)