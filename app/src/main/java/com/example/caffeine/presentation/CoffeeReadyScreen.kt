package com.example.caffeine.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.caffeine.R
import com.example.caffeine.navigation.Screen
import com.example.caffeine.presentation.composables.ContinueButton
import com.example.caffeine.presentation.composables.TakeAwaySwitch
import com.example.caffeine.ui.theme.MineShaft
import com.example.caffeine.ui.theme.UrbanistFamily

@Composable
fun CoffeeReadyScreen(navController: NavController) {

    var isTakeAway = remember { mutableStateOf(true) }



    Box(Modifier.fillMaxSize()) {

        Column(
            Modifier.fillMaxSize().padding(top = 251.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(Modifier.height(300.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.cup),
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Fit
                )
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = null,
                    modifier = Modifier.size(64.dp).align(Alignment.Center),
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
            ) {
                navController.navigate(Screen.TakeSnack.route)
            }

        }
    }
}