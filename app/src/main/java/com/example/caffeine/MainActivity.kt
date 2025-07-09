package com.example.caffeine

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
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
import com.example.caffeine.presentation.CoffeeReadyScreen
import com.example.caffeine.presentation.FinishScreen
import com.example.caffeine.presentation.HomeScreen
import com.example.caffeine.presentation.TakeSnackScreen
import com.example.caffeine.presentation.WaitingScreen
import com.example.caffeine.presentation.WelcomeOneScreen
import com.example.caffeine.presentation.WelcomeTwoScreen
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
                    Box(
                        Modifier
                            .fillMaxSize()
                            .padding(top = it.calculateTopPadding())
                    ) {
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

        composable(
            route = Screen.WelcomeTwo.route,
            exitTransition = {
                slideOutOfContainer(
                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                )
            }
        ) { WelcomeTwoScreen(navController) }

        composable(
            route = Screen.Home.route + "/{typeOfCup}",
            arguments = listOf(navArgument("typeOfCup") { defaultValue = "Black" })
        ) { HomeScreen(navController, typeOfCoffee = it.arguments?.getString("typeOfCup")) }

        composable(
            route = Screen.Waiting.route + "/{sizeOfCup}" + "/{typeOfCup}",
            arguments = listOf(
                navArgument("sizeOfCup") { defaultValue = "M" },
                navArgument("typeOfCup") { defaultValue = "Black" }
            )
        ) { WaitingScreen(navController, sizeOfCup = it.arguments?.getString("sizeOfCup"), typeOfCoffee = it.arguments?.getString("typeOfCup")) }


        composable(
            route = Screen.CoffeeReady.route + "/{typeOfCup}",
            arguments = listOf(navArgument("typeOfCup") { defaultValue = "Black" })
        ) { CoffeeReadyScreen(navController, typeOfCoffee = it.arguments?.getString("typeOfCup")) }
        composable(route = Screen.TakeSnack.route) { TakeSnackScreen(navController) }
        composable(
            route = Screen.Finish.route + "/{snackType}",
            arguments = listOf(navArgument("snackType") { defaultValue = "cupcake" })
        ) {
            FinishScreen(navController, snackType = it.arguments?.getString("snackType"))
        }
    }
}


