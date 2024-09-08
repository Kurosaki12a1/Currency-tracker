package com.android.kuro.currencytracker.data.data_source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.kuro.currencytracker.data.data_source.database.converter.CurrencyTypeConverters
import com.android.kuro.currencytracker.data.data_source.database.dao.CurrencyDao
import com.android.kuro.currencytracker.data.model.entity.CurrencyEntity

@Database(entities = [CurrencyEntity::class], version = 1, exportSchema = false)
@TypeConverters(CurrencyTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
}