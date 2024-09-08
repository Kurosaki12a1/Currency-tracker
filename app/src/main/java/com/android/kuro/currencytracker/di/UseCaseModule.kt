package com.android.kuro.currencytracker.di

import com.android.kuro.currencytracker.domain.repository.CurrencyRepository
import com.android.kuro.currencytracker.domain.repository.PreferencesRepository
import com.android.kuro.currencytracker.domain.use_case.currency.DeleteAllCurrenciesUseCase
import com.android.kuro.currencytracker.domain.use_case.currency.DeleteCurrencyByBaseCodeUseCase
import com.android.kuro.currencytracker.domain.use_case.currency.FetchAndSaveCurrencyUseCase
import com.android.kuro.currencytracker.domain.use_case.currency.GetAllCurrenciesUseCase
import com.android.kuro.currencytracker.domain.use_case.currency.GetCurrencyByBaseCodeUseCase
import com.android.kuro.currencytracker.domain.use_case.preferences.ClearPreferencesUseCase
import com.android.kuro.currencytracker.domain.use_case.preferences.GetDefaultCurrencyUseCase
import com.android.kuro.currencytracker.domain.use_case.preferences.GetNextSyncTimeUseCase
import com.android.kuro.currencytracker.domain.use_case.preferences.GetOnboardingStatusUseCase
import com.android.kuro.currencytracker.domain.use_case.preferences.SetDefaultCurrencyUseCase
import com.android.kuro.currencytracker.domain.use_case.preferences.SetNextSyncTimeUseCase
import com.android.kuro.currencytracker.domain.use_case.preferences.SetOnboardingStatusUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideFetchAndSaveCurrencyUseCase(
        repository: CurrencyRepository
    ): FetchAndSaveCurrencyUseCase {
        return FetchAndSaveCurrencyUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetCurrencyByBaseCodeUseCase(
        repository: CurrencyRepository
    ): GetCurrencyByBaseCodeUseCase {
        return GetCurrencyByBaseCodeUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetAllCurrenciesUseCase(
        repository: CurrencyRepository
    ): GetAllCurrenciesUseCase {
        return GetAllCurrenciesUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideDeleteCurrencyByBaseCodeUseCase(
        repository: CurrencyRepository
    ): DeleteCurrencyByBaseCodeUseCase {
        return DeleteCurrencyByBaseCodeUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideDeleteAllCurrenciesUseCase(
        repository: CurrencyRepository
    ): DeleteAllCurrenciesUseCase {
        return DeleteAllCurrenciesUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideSetOnboardingStatusUseCase(
        repository: PreferencesRepository
    ): SetOnboardingStatusUseCase {
        return SetOnboardingStatusUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetOnboardingStatusUseCase(
        repository: PreferencesRepository
    ): GetOnboardingStatusUseCase {
        return GetOnboardingStatusUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideSetNextSyncTimeUseCase(
        repository: PreferencesRepository
    ): SetNextSyncTimeUseCase {
        return SetNextSyncTimeUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetNextSyncTimeUseCase(
        repository: PreferencesRepository
    ): GetNextSyncTimeUseCase {
        return GetNextSyncTimeUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideSetDefaultCurrencyUseCase(
        repository: PreferencesRepository
    ): SetDefaultCurrencyUseCase {
        return SetDefaultCurrencyUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetDefaultCurrencyUseCase(
        repository: PreferencesRepository
    ): GetDefaultCurrencyUseCase {
        return GetDefaultCurrencyUseCase(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideClearPreferencesUseCase(
        repository: PreferencesRepository
    ): ClearPreferencesUseCase {
        return ClearPreferencesUseCase(repository)
    }
}