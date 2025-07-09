package com.example.caffeine.presentation.composables

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.Black
import com.example.caffeine.ui.theme.UrbanistFamily

@Composable
fun CupSection(modifier: Modifier = Modifier,imageRes: Int, size: String) {
    Box(modifier = modifier) {
        val verticalPadding by animateDpAsState(
            targetValue = when (size) {
                "S" -> 76.dp
                "L" -> 20.dp
                else -> 48.dp
            },
            animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
        )
        val horizontalPadding by animateDpAsState(
            targetValue = when (size) {
                "S" -> 103.dp
                "L" -> 57.dp
                else -> 80.dp
            },
            animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
        )
        val sizeOfLogo by animateDpAsState(
            targetValue = when (size) {
                "S" -> 40.dp
                "L" -> 77.dp
                else -> 66.dp
            },
            animationSpec = tween(durationMillis = 500, easing = FastOutSlowInEasing)
        )

        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = verticalPadding, horizontal = horizontalPadding)
                .align(Alignment.Center),
            contentScale = ContentScale.Fit
        )
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .size(sizeOfLogo)
                .align(Alignment.Center),
            contentScale = ContentScale.Fit
        )
        Text(
            text = when (size) {
                "S" -> "150 ML"
                "L" -> "400 ML"
                else -> "200 ML"
            },
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(top = 64.dp),
            fontFamily = UrbanistFamily,
            fontSize = 14.sp,
            letterSpacing = 0.25.sp,
            fontWeight = FontWeight.Medium,
            color = Black.copy(0.6f),
        )
    }
}