package com.android.kuro.currencytracker.screen.onboard

import androidx.lifecycle.ViewModel
import com.android.kuro.currencytracker.navigation.utils.AppNavigator
import com.android.kuro.currencytracker.navigation.utils.Destination
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardViewModel @Inject constructor(
    private val appNavigator: AppNavigator
) : ViewModel() {

    fun navigateToHome(title: String, age: Int) {
     //   appNavigator.tryNavigateTo(Destination.HomeScreen(title, age))
    }
}