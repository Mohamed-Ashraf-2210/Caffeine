package com.example.caffeine.presentation

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.caffeine.R
import com.example.caffeine.navigation.Screen
import com.example.caffeine.presentation.composables.ContinueButton
import com.example.caffeine.presentation.composables.TakeAwaySwitch
import com.example.caffeine.ui.theme.ButtonColor
import com.example.caffeine.ui.theme.MineShaft
import com.example.caffeine.ui.theme.MineShaft87
import com.example.caffeine.ui.theme.UrbanistFamily
import com.example.caffeine.ui.theme.WildSand

@Composable
fun CoffeeReadyScreen(navController: NavController, typeOfCoffee: String?) {

    var isTakeAway = remember { mutableStateOf(true) }
    var openScreen by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        openScreen = true
    }
    val topPadding by animateDpAsState(
        targetValue = if (openScreen) {
            0.dp
        } else {
            -(300).dp
        },
        label = "Top Padding Animation"
    )
    val bottomPadding by animateDpAsState(
        targetValue = if (openScreen) {
            0.dp
        } else {
            300.dp
        },
        label = "Top Padding Animation"
    )


    Box(Modifier.fillMaxSize()) {

        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 251.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(Modifier.height(300.dp)) {
                Image(
                    painter = painterResource(
                        when(typeOfCoffee) {
                        "Espresso" -> R.drawable.empty_cup_espresso
                        "Latte" -> R.drawable.empty_cup_latte
                        "Black" -> R.drawable.empty_cup_black
                        else -> R.drawable.empty_cup_macchiato
                    }),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(64.dp)
                        .align(Alignment.Center),
                    contentScale = ContentScale.Fit,
                )
            }
            Row(
                Modifier.padding(top = 47.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TakeAwaySwitch(
                    isTakeAway = isTakeAway.value,
                    modifier = Modifier.height(40.dp)
                ) {
                    isTakeAway.value = !isTakeAway.value
                }
                Text(
                    text = "Take Away",
                    color = MineShaft.copy(0.7f),
                    fontFamily = UrbanistFamily,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.25.sp,
                    fontSize = 14.sp
                )
            }
            ContinueButton(
                title = "Take snack",
                icon = painterResource(id = R.drawable.arrow_right),
                Modifier
                    .padding(bottom = 50.dp, top = 16.dp)
                    .align(Alignment.CenterHorizontally)
                    .offset(y = bottomPadding)
            ) {
                navController.navigate(Screen.TakeSnack.route)
            }
        }

        Column(
            Modifier
                .fillMaxSize()
                .offset(y = topPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.cancel),
                contentDescription = "Cancel",
                modifier = Modifier
                    .padding(16.dp)
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(WildSand)
                    .padding(12.dp)
                    .align(Alignment.Start)
            )

            Icon(
                painter = painterResource(id = R.drawable.tick),
                contentDescription = "Tick",
                modifier = Modifier
                    .size(56.dp)
                    .shadow(elevation = 8.dp, shape = CircleShape, spotColor = ButtonColor)
                    .clip(CircleShape)
                    .background(ButtonColor)
                    .padding(12.dp)
            )
            Text(
                text = "Your coffee is ready,\nEnjoy",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = UrbanistFamily,
                letterSpacing = 0.25.sp,
                color = MineShaft87,
                modifier = Modifier.padding(top = 24.dp)
            )
            Image(
                painter = painterResource(
                    when(typeOfCoffee) {
                        "Espresso" -> R.drawable.espresso_cover
                        "Latte" -> R.drawable.lattee_cover
                        "Black" -> R.drawable.black_cover
                        else -> R.drawable.macchiato_cover
                    }
                ),
                contentDescription = null,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .size(260.dp,69.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}