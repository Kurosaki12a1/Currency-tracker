package com.android.kuro.currencytracker.navigation.utils

import kotlinx.coroutines.channels.Channel

interface AppNavigator {
    val navigationChannel: Channel<NavigationIntent>

    suspend fun <T : Any> navigateBack(
        route: T? = null,
        inclusive: Boolean = false,
    )

    fun <T : Any> tryNavigateBack(
        route: T? = null,
        inclusive: Boolean = false,
    )

    suspend fun <T : Any> navigateTo(
        route: T,
        popUpToRoute: String? = null,
        inclusive: Boolean = false,
        isSingleTop: Boolean = false,
    )

    fun <T : Any> tryNavigateTo(
        route: T,
        popUpToRoute: String? = null,
        inclusive: Boolean = false,
        isSingleTop: Boolean = false,
    )
}

sealed class NavigationIntent {
    data class NavigateBack<T : Any>(
        val route: T? = null,
        val inclusive: Boolean = false,
    ) : NavigationIntent()

    data class NavigateTo<T : Any>(
        val route: T,
        val popUpToRoute: String? = null,
        val inclusive: Boolean = false,
        val isSingleTop: Boolean = false,
    ) : NavigationIntent()
}
