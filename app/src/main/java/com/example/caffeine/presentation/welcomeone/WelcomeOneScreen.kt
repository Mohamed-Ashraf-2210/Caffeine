package com.example.caffeine.presentation.welcomeone

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.caffeine.R
import com.example.caffeine.navigation.Screen
import com.example.caffeine.presentation.composables.AppBar
import com.example.caffeine.presentation.composables.ContinueButton
import com.example.caffeine.ui.theme.Black
import com.example.caffeine.ui.theme.MineShaft
import com.example.caffeine.ui.theme.SingletonFamily

@Composable
fun WelcomeOneScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(state = rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AppBar(Modifier.fillMaxWidth())
        TitleWithAnimation(Modifier.padding(top = 24.dp))
        CoffeeGhostWithAnimation(Modifier.fillMaxWidth())
        Spacer(Modifier.weight(1f))
        ContinueButton(
            title = "bring my coffee",
            icon = painterResource(id = R.drawable.coffee),
            Modifier.padding(bottom = 50.dp)
        ) {
            navController.navigate(Screen.WelcomeTwo.route)
        }
    }
}


@Composable
private fun StarWithAnimationColor(modifier: Modifier = Modifier) {
    val colorStar by rememberInfiniteTransition().animateColor(
        initialValue = Black.copy(alpha = .87f),
        targetValue = Black.copy(alpha = .12f),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 1000,
                delayMillis = 500
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    Icon(
        painter = painterResource(R.drawable.star),
        contentDescription = null,
        tint = colorStar,
        modifier = modifier.size(16.dp)
    )
}

@Composable
private fun TitleWithAnimation(modifier: Modifier = Modifier) {
    Box(modifier) {
        Text(
            text = "Hocus\n" +
                    "Pocus\n" +
                    "I Need Coffee\n" +
                    "to Focus",
            fontFamily = SingletonFamily,
            fontSize = 32.sp,
            color = MineShaft.copy(alpha = .87f),
            textAlign = TextAlign.Center,
            lineHeight = 50.sp,
            letterSpacing = 0.25.sp
        )
        StarWithAnimationColor(modifier = Modifier.align(Alignment.TopEnd))
        StarWithAnimationColor(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .offset(x = 16.dp)
        )
        StarWithAnimationColor(modifier = Modifier.padding(start = 10.dp, top = 65.dp))
    }
}

@Composable
private fun CoffeeGhostWithAnimation(modifier: Modifier = Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "Infinite Y Movement")

    val yOffset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 30f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500),
            repeatMode = RepeatMode.Reverse
        ),
        label = "Y Offset Animation"
    )

    Image(
        painter = painterResource(id = R.drawable.coffee_ghost),
        contentDescription = null,
        modifier = modifier
            .padding(top = 33.dp)
            .padding(horizontal = 58.dp)
            .offset(y = -yOffset.dp)
    )
    Image(
        painter = painterResource(id = R.drawable.shadow),
        contentDescription = null,
        modifier = modifier
            .padding(start = 98.dp, end = 84.dp)
            .blur(12.dp)
            .offset(y = yOffset.dp / 3)
            .padding(bottom = 40.dp)
    )
}