package com.android.kuro.currencytracker.navigation.graph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.android.kuro.currencytracker.navigation.utils.NavigationGraph

@Composable
fun RootNavGraph(
    navController: NavHostController,
    paddingValues: PaddingValues,
    startDestination: NavigationGraph
) {
    NavHost(
        modifier = Modifier.padding(paddingValues),
        navController = navController,
        startDestination = startDestination
    ) {
        homeNavGraph()
        onBoardNavGraph()
    }
}