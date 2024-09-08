package com.android.kuro.currencytracker.navigation.utils

import kotlinx.serialization.Serializable

sealed class NavigationGraph {
    @Serializable
    data object HomeGraph : NavigationGraph()

    @Serializable
    data object OnBoardGraph : NavigationGraph()
}

