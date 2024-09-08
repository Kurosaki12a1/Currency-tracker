package com.android.kuro.currencytracker.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.android.kuro.currencytracker.navigation.utils.Destination

@Composable
fun HomeScreen(
    data: Destination.HomeScreen?
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = { }) {
            Text(text = "This is home screen")
        }
    }
}