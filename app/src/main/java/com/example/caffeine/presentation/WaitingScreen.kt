package com.example.caffeine.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.caffeine.navigation.Screen
import com.example.caffeine.presentation.composables.CupSection
import com.example.caffeine.ui.theme.Black
import com.example.caffeine.ui.theme.ButtonColor
import com.example.caffeine.ui.theme.MineShaft
import com.example.caffeine.ui.theme.MineShaft60
import com.example.caffeine.ui.theme.MineShaft87
import com.example.caffeine.ui.theme.SingletonFamily
import com.example.caffeine.ui.theme.UrbanistFamily
import com.example.caffeine.ui.theme.White
import kotlinx.coroutines.delay
import kotlin.io.path.Path
import kotlin.io.path.moveTo

@Composable
fun WaitingScreen(navController: NavController, sizeOfCup: String?) {
    LaunchedEffect(Unit) {
        delay(300L)
        navController.navigate(Screen.CoffeeReady.route) {
            popUpTo(Screen.Waiting.route)
        }
    }

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CupSection(
            modifier = Modifier
                .padding(top = 80.dp)
                .padding(horizontal = 16.dp)
                .fillMaxWidth()
                .height(341.dp),
            size = sizeOfCup!!
        )
        LinearProgressIndicator(
            modifier = Modifier.padding(top = 100.dp).fillMaxWidth(),
            color = Black,
        )

        Spacer(Modifier.weight(1f))
        TextSection(Modifier.padding(top = 37.dp, bottom = 64.dp))
    }
}

@Composable
private fun TextSection(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(
            text = "Almost Done",
            fontFamily = UrbanistFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            color = MineShaft87,
            letterSpacing = 0.25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Your coffee will be finish in",
            fontFamily = UrbanistFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MineShaft60,
            letterSpacing = 0.25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp, bottom = 12.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = "CO",
                fontFamily = SingletonFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 32.sp,
                color = ButtonColor,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center,
            )
            Text(
                text = ":",
                fontFamily = SingletonFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 32.sp,
                color = MineShaft.copy(0.12f),
                textAlign = TextAlign.Center,
            )
            Text(
                text = "FF",
                fontFamily = SingletonFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 32.sp,
                color = ButtonColor,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center,
            )
            Text(
                text = ":",
                fontFamily = SingletonFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 32.sp,
                color = MineShaft.copy(0.12f),
                textAlign = TextAlign.Center,
            )
            Text(
                text = "EE",
                fontFamily = SingletonFamily,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 32.sp,
                color = ButtonColor,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center,
            )
        }
    }
}