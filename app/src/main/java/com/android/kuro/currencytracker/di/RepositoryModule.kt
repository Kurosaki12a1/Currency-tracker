package com.android.kuro.currencytracker.di

import com.android.kuro.currencytracker.data.data_source.database.dao.CurrencyDao
import com.android.kuro.currencytracker.data.data_source.database.preferences.AppPreferences
import com.android.kuro.currencytracker.data.data_source.network.api.CurrencyAPI
import com.android.kuro.currencytracker.data.repository.CurrencyRepositoryImpl
import com.android.kuro.currencytracker.data.repository.PreferencesRepositoryImpl
import com.android.kuro.currencytracker.domain.repository.CurrencyRepository
import com.android.kuro.currencytracker.domain.repository.PreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideCurrencyRepository(
        currencyApi: CurrencyAPI,
        currencyDao: CurrencyDao
    ): CurrencyRepository = CurrencyRepositoryImpl(currencyApi, currencyDao)

    @Provides
    @Singleton
    fun providePreferencesRepository(
        appPreferences: AppPreferences
    ): PreferencesRepository = PreferencesRepositoryImpl(appPreferences)
}