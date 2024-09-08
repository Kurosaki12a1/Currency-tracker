package com.android.kuro.currencytracker.navigation.graph

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.android.kuro.currencytracker.navigation.utils.Destination
import com.android.kuro.currencytracker.navigation.utils.NavigationGraph
import com.android.kuro.currencytracker.screen.home.HomeScreen

fun NavGraphBuilder.homeNavGraph() {
    navigation<NavigationGraph.HomeGraph>(
        startDestination = Destination.HomeScreen()
    ) {
        composable<Destination.HomeScreen> {
            val argument = it.toRoute<Destination.HomeScreen>()
            HomeScreen(data = argument)
        }
    }
}