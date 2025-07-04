package com.example.caffeine.presentation.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.caffeine.ui.theme.Black

@Composable
fun HomeScreen(navController: NavController) {
    Text(
        text = "Welcome to Home Screen",
        modifier = androidx.compose.ui.Modifier.padding(16.dp),
        fontSize = 24.sp,
        color = Black
    )
}