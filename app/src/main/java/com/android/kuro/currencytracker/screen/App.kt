package com.android.kuro.currencytracker.screen

import android.app.Activity
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.android.kuro.currencytracker.navigation.graph.RootNavGraph
import com.android.kuro.currencytracker.navigation.utils.AppNavigator
import com.android.kuro.currencytracker.navigation.utils.NavigationGraph
import com.android.kuro.currencytracker.navigation.utils.NavigationIntent
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
fun App(
    appNavigator: AppNavigator
) {
    SetUpSystemUi()
    val navController = rememberNavController()

    NavigationEffects(
        navHostController = navController,
        navigationChannel = appNavigator.navigationChannel
    )

    Scaffold { padding ->
        RootNavGraph(
            navController = navController,
            paddingValues = padding,
            startDestination = NavigationGraph.OnBoardGraph
        )
    }
}

@Composable
private fun SetUpSystemUi() {
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = Color.White,
        darkIcons = true
    )
}

@Composable
fun NavigationEffects(
    navigationChannel: Channel<NavigationIntent>,
    navHostController: NavHostController
) {
    val activity = (LocalContext.current as? Activity)
    LaunchedEffect(activity, navHostController, navigationChannel) {
        navigationChannel.receiveAsFlow().collect { intent ->
            if (activity?.isFinishing == true) {
                return@collect
            }
            when (intent) {
                is NavigationIntent.NavigateBack<*> -> {
                    if (intent.route != null) {
                        navHostController.popBackStack(intent.route, intent.inclusive)
                    } else {
                        navHostController.popBackStack()
                    }
                }

                is NavigationIntent.NavigateTo<*> -> {
                    navHostController.navigate(intent.route) {
                        launchSingleTop = intent.isSingleTop
                        intent.popUpToRoute?.let { popUpToRoute ->
                            popUpTo(popUpToRoute) { inclusive = intent.inclusive }
                        }
                    }
                }
            }
        }
    }
}
