package com.android.kuro.currencytracker.data.data_source.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.android.kuro.currencytracker.data.model.entity.CurrencyEntity

@Dao
interface CurrencyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCurrency(currency: CurrencyEntity)

    @Update
    suspend fun updateCurrency(currency: CurrencyEntity)

    @Query("SELECT * FROM CURRENCY_TABLE WHERE baseCode = :baseCode ORDER BY timeLastUpdateUnix DESC LIMIT 1")
    suspend fun getCurrencyByBaseCode(baseCode: String): CurrencyEntity?

    @Query("SELECT * FROM CURRENCY_TABLE")
    suspend fun getAllCurrencies(): List<CurrencyEntity>

    @Query("DELETE FROM CURRENCY_TABLE WHERE baseCode = :baseCode")
    suspend fun deleteCurrencyByBaseCode(baseCode: String)

    @Query("DELETE FROM CURRENCY_TABLE")
    suspend fun deleteAllCurrencies()

    suspend fun insertOrUpdateCurrency(currency: CurrencyEntity) {
        val existingCurrency = getCurrencyByBaseCode(currency.baseCode)

        if (existingCurrency == null || existingCurrency.timeLastUpdateUnix != currency.timeLastUpdateUnix) {
            // Nếu không tồn tại hoặc timeLastUpdateUnix khác, thì chèn bản ghi mới
            insertCurrency(currency)
        } else {
            // Nếu tồn tại và timeLastUpdateUnix trùng, thì cập nhật bản ghi
            updateCurrency(currency)
        }
    }
}