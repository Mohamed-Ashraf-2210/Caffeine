package com.example.caffeine.presentation.welcometwo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.caffeine.R
import com.example.caffeine.navigation.Screen
import com.example.caffeine.presentation.composables.AppBar
import com.example.caffeine.presentation.composables.ContinueButton
import com.example.caffeine.ui.theme.MineShaft
import com.example.caffeine.ui.theme.Nobel
import com.example.caffeine.ui.theme.UrbanistFamily
import com.example.caffeine.ui.theme.textColor

@Composable
fun WelcomeTwoScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 16.dp)
            .verticalScroll(state = rememberScrollState()),
    ) {
        AppBar(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        )
        WelcomeTwoText()

        Spacer(Modifier.weight(1f))
        ContinueButton(
            title = "Continue",
            icon = painterResource(id = R.drawable.arrow_right),
            Modifier.padding(bottom = 50.dp).align(Alignment.CenterHorizontally)
        ) {
            navController.navigate(Screen.Home.route)
        }
    }
}

@Composable
private fun WelcomeTwoText() {
    Text(
        text = "Good Morning",
        modifier = Modifier.padding(top = 16.dp, start = 16.dp),
        fontFamily = UrbanistFamily,
        fontSize = 36.sp,
        letterSpacing = 0.25.sp,
        fontWeight = FontWeight.Bold,
        color = Nobel,
        textAlign = TextAlign.Start
    )
    Text(
        text = "Hamsa ☀",
        modifier = Modifier.padding(start = 16.dp),
        fontFamily = UrbanistFamily,
        fontSize = 36.sp,
        letterSpacing = 0.25.sp,
        fontWeight = FontWeight.Bold,
        color = textColor,
        textAlign = TextAlign.Start
    )
    Text(
        text = "What would you like to drink today?",
        modifier = Modifier.padding(top = 4.dp, start = 16.dp),
        fontFamily = UrbanistFamily,
        fontSize = 16.sp,
        letterSpacing = 0.25.sp,
        fontWeight = FontWeight.Bold,
        color = MineShaft.copy(0.8f),
        textAlign = TextAlign.Start
    )
}