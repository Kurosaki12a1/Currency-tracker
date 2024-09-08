package com.android.kuro.currencytracker.data.data_source.network.api

import com.android.kuro.currencytracker.data.model.response.CurrencyResponse
import com.android.kuro.currencytracker.data.model.response.ExchangeRateResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CurrencyAPI {
    @GET("latest/{currency}")
    suspend fun getConversation(@Path("currency") currency: String): CurrencyResponse

    @GET("pair/{currency1}/{currency2}")
    suspend fun getPairConversation(
        @Path("currency1") currency1: String,
        @Path("currency2") currency2: String
    ): ExchangeRateResponse

    @GET("pair/{currency1}/{currency2}/{amount}")
    suspend fun getPairConversation(
        @Path("currency1") currency1: String,
        @Path("currency2") currency2: String,
        @Path("amount") amount: Double
    ): ExchangeRateResponse
}