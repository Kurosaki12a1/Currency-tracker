package com.android.kuro.currencytracker.data.data_source.database.converter

import androidx.room.TypeConverter
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class CurrencyTypeConverters {

    @TypeConverter
    fun fromMap(conversionRates: Map<String, Double>?): String {
        return Json.encodeToString(conversionRates ?: mapOf())
    }

    @TypeConverter
    fun toMap(conversionRatesString: String): Map<String, Double> {
        return Json.decodeFromString(conversionRatesString)
    }
}