package com.example.caffeine

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.caffeine.navigation.Screen
import com.example.caffeine.presentation.home.HomeScreen
import com.example.caffeine.presentation.welcomeone.WelcomeOneScreen
import com.example.caffeine.presentation.welcometwo.WelcomeTwoScreen
import com.example.caffeine.ui.theme.CaffeineTheme
import com.example.caffeine.ui.theme.White

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CaffeineTheme {
                Scaffold(
                    Modifier.fillMaxSize(),
                    containerColor = White,
                ) {
                    Box(Modifier
                        .fillMaxSize()
                        .padding(top = it.calculateTopPadding())) {
                        NavigationStack()
                    }
                }
            }
        }
    }
}

@Composable
fun NavigationStack() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.WelcomeOne.route) {
        composable(Screen.WelcomeOne.route) { WelcomeOneScreen(navController) }
        composable(Screen.WelcomeTwo.route) { WelcomeTwoScreen(navController) }
        composable(
            route = Screen.Home.route + "/{typeOfCup}",
            arguments = listOf(navArgument("typeOfCup") { defaultValue = "Black" })
        ) { HomeScreen(navController, text = it.arguments?.getString("typeOfCup")) }
    }
}
