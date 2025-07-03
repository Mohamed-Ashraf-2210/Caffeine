package com.example.caffeine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.caffeine.navigation.Screen
import com.example.caffeine.presentation.WelcomeOneScreen
import com.example.caffeine.ui.theme.CaffeineTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaffeineTheme {
                NavigationStack()
            }
        }
    }
}

@Composable
fun NavigationStack() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.WelcomeOne.route) {
        composable(Screen.WelcomeOne.route) { WelcomeOneScreen(navController) }
        composable(Screen.WelcomeTwo.route) { WelcomeOneScreen(navController) }
    }
}
