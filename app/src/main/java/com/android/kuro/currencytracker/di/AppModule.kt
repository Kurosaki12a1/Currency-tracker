package com.android.kuro.currencytracker.di

import android.content.Context
import com.android.kuro.currencytracker.data.data_source.database.preferences.AppPreferences
import com.android.kuro.currencytracker.navigation.utils.AppNavigator
import com.android.kuro.currencytracker.navigation.utils.AppNavigatorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAppNavigator(): AppNavigator = AppNavigatorImpl()

    @Provides
    @Singleton
    fun provideAppPreferences(@ApplicationContext context: Context): AppPreferences =
        AppPreferences(context)
}