package com.android.kuro.currencytracker.di

import android.content.Context
import com.android.kuro.currencytracker.BuildConfig
import com.android.kuro.currencytracker.common.Constants.EXCHANGE_RATE_API
import com.android.kuro.currencytracker.data.data_source.network.api.CurrencyAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext context: Context): OkHttpClient {
        val cacheSize = (5 * 1024 * 1024).toLong()
        val mCache = Cache(context.cacheDir, cacheSize)
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .cache(mCache) // make your app offline-friendly without a database!
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .addNetworkInterceptor(interceptor)
            .addInterceptor { chain ->
                val request = chain.request()
                val originalUrl = request.url
                val finalUrl = originalUrl.newBuilder()
                    .addPathSegment(BuildConfig.API_KEY)
                    .build()

                chain.proceed(request.newBuilder().url(finalUrl).build())
            }
        return client.build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(EXCHANGE_RATE_API)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideCurrencyAPI(retrofit: Retrofit): CurrencyAPI =
        retrofit.create(CurrencyAPI::class.java)
}