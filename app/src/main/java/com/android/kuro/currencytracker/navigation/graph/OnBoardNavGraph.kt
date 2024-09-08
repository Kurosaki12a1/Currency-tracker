package com.android.kuro.currencytracker.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.android.kuro.currencytracker.navigation.utils.Destination
import com.android.kuro.currencytracker.navigation.utils.NavigationGraph
import com.android.kuro.currencytracker.screen.onboard.OnBoardScreen
import com.android.kuro.currencytracker.screen.select_currency.SelectCurrencyScreen

fun NavGraphBuilder.onBoardNavGraph() {
    navigation<NavigationGraph.OnBoardGraph>(startDestination = Destination.OnBoardScreen) {
        composable<Destination.OnBoardScreen> {
            OnBoardScreen()
        }
        composable<Destination.SelectCurrencyScreen> {
            SelectCurrencyScreen()
        }
    }
}