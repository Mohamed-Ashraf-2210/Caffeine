package com.example.caffeine.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.caffeine.R
import com.example.caffeine.navigation.Screen
import com.example.caffeine.presentation.composables.ContinueButton
import com.example.caffeine.ui.theme.MineShaft87
import com.example.caffeine.ui.theme.UrbanistFamily
import com.example.caffeine.ui.theme.WildSand

@Composable
fun TakeSnackScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.cancel),
            contentDescription = "Cancel",
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
                .size(48.dp)
                .clip(CircleShape)
                .background(WildSand)
                .padding(12.dp)
        )

        Text(
            text = "Take your snack",
            fontFamily = UrbanistFamily,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.25.sp,
            color = MineShaft87,
            modifier = Modifier.padding(start = 16.dp, top = 24.dp)
        )

        Spacer(modifier = Modifier.weight(1f))
        ContinueButton(
            title = "Thank youuu",
            icon = painterResource(id = R.drawable.arrow_right),
            Modifier
                .padding(bottom = 50.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            navController.navigate(Screen.Finish.route)
        }


    }
}