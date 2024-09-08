package com.android.kuro.currencytracker.navigation.utils

import kotlinx.serialization.Serializable

sealed class Destination {
    @Serializable
    data class HomeScreen(val currency: String = "VND") : Destination()

    @Serializable
    data object OnBoardScreen : Destination()

    @Serializable
    data object SelectCurrencyScreen : Destination()
}




