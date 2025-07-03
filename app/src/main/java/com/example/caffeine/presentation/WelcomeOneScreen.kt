package com.example.caffeine.presentation

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.caffeine.R
import com.example.caffeine.ui.theme.Black
import com.example.caffeine.ui.theme.MineShaft
import com.example.caffeine.ui.theme.SingletonFamily
import com.example.caffeine.ui.theme.UrbanistFamily
import com.example.caffeine.ui.theme.White
import com.example.caffeine.ui.theme.White87
import com.example.caffeine.ui.theme.WildSand

@Composable
fun WelcomeOneScreen(navCloneable: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(16.dp)
            .verticalScroll(state = rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = R.drawable.user_image),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.add),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(WildSand)
                    .padding(12.dp)
            )
        }
        Box(modifier = Modifier.padding(top = 24.dp)) {
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

        val infiniteTransition = rememberInfiniteTransition(label = "Infinite Y Movement")

        val yOffset by infiniteTransition.animateFloat(
            initialValue = 0f,
            targetValue = 20f,
            animationSpec = infiniteRepeatable(
                animation = tween(durationMillis = 1000, easing = FastOutSlowInEasing),
                repeatMode = RepeatMode.Reverse
            ),
            label = "Y Offset Animation"
        )
        Image(
            painter = painterResource(id = R.drawable.coffee_ghost),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 33.dp)
                .size(244.dp)
                .offset(y = yOffset.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.shadow),
            contentDescription = null,
            modifier = Modifier
                .blur(12.dp)
                .offset(y = yOffset.dp)
                .padding(bottom = 40.dp)

        )


       Spacer(Modifier.weight(1f))

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = MineShaft,
                contentColor = White87
            ),
            contentPadding = PaddingValues(vertical = 18.5.dp, horizontal = 32.dp),
            modifier = Modifier.padding(bottom = 50.dp)
        ) {
            Text(
                text = "bring my coffee",
                fontFamily = UrbanistFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = White87,
                textAlign = TextAlign.Center,
            )
            Icon(
                painter = painterResource(id = R.drawable.coffee),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(24.dp),
                tint = White87
            )
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