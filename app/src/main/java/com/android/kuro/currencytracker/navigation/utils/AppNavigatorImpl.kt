package com.android.kuro.currencytracker.navigation.utils

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.channels.Channel
import javax.inject.Inject

class AppNavigatorImpl @Inject constructor() : AppNavigator {
    override val navigationChannel: Channel<NavigationIntent> = Channel<NavigationIntent>(
        capacity = Int.MAX_VALUE,
        onBufferOverflow = BufferOverflow.DROP_LATEST,
    )

    override suspend fun <T : Any> navigateBack(route: T?, inclusive: Boolean) {
        navigationChannel.send(
            NavigationIntent.NavigateBack(
                route = route,
                inclusive = inclusive
            )
        )
    }

    override fun <T : Any> tryNavigateBack(route: T?, inclusive: Boolean) {
        navigationChannel.trySend(
            NavigationIntent.NavigateBack(
                route = route,
                inclusive = inclusive
            )
        )
    }

    override suspend fun <T : Any> navigateTo(
        route: T,
        popUpToRoute: String?,
        inclusive: Boolean,
        isSingleTop: Boolean
    ) {
        navigationChannel.send(
            NavigationIntent.NavigateTo(
                route = route,
                popUpToRoute = popUpToRoute,
                inclusive = inclusive,
                isSingleTop = isSingleTop,
            )
        )
    }

    override fun <T : Any> tryNavigateTo(
        route: T,
        popUpToRoute: String?,
        inclusive: Boolean,
        isSingleTop: Boolean
    ) {
        navigationChannel.trySend(
            NavigationIntent.NavigateTo(
                route = route,
                popUpToRoute = popUpToRoute,
                inclusive = inclusive,
                isSingleTop = isSingleTop,
            )
        )
    }
}