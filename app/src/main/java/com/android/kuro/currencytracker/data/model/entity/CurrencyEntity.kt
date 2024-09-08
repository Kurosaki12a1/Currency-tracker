package com.android.kuro.currencytracker.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.android.kuro.currencytracker.common.Constants.CURRENCY_TABLE
import com.android.kuro.currencytracker.data.data_source.database.converter.CurrencyTypeConverters
import kotlinx.serialization.Serializable

@Entity(tableName = CURRENCY_TABLE)
@Serializable
@TypeConverters(CurrencyTypeConverters::class) // Sử dụng TypeConverter cho Map
data class CurrencyEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val baseCode: String,
    val result: String,
    val timeLastUpdateUnix: Long,
    val timeLastUpdateUtc: String,
    val timeNextUpdateUnix: Long,
    val timeNextUpdateUtc: String,
    val conversionRates: Map<String, Double> // Lưu trữ kiểu Map với TypeConverter
)