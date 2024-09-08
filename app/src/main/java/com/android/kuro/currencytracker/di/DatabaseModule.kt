package com.android.kuro.currencytracker.di

import android.content.Context
import androidx.room.Room
import com.android.kuro.currencytracker.common.Constants.DATABASE_NAME
import com.android.kuro.currencytracker.data.data_source.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        ).allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    fun provideCurrencyDao(appDatabase: AppDatabase) = appDatabase.currencyDao()
}