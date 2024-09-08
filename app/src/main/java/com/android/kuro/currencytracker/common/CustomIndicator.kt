package com.android.kuro.currencytracker.common

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.android.kuro.currencytracker.ui.theme.WelcomeSelectedIndicatorColor
import com.android.kuro.currencytracker.ui.theme.WelcomeUnSelectedIndicatorColor

@Composable
fun CustomIndicator(isSelected: Boolean) {
    val width: Dp by animateDpAsState(targetValue = if (isSelected) 30.dp else 10.dp, label = "")
    val color: Color by animateColorAsState(
        targetValue = if (isSelected) WelcomeSelectedIndicatorColor else WelcomeUnSelectedIndicatorColor,
        label = "color"
    )

    if (isSelected) {
        Box(
            modifier = Modifier
                .size(width, 10.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(color)
        )
    } else {
        Canvas(modifier = Modifier.size(width)) {
            drawCircle(color)
        }
    }
}