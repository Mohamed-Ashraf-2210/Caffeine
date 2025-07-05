package com.example.caffeine.navigation

open class Screen(val route: String) {
    object WelcomeOne : Screen("welcome_one")
    object WelcomeTwo : Screen("welcome_two")
    object Home : Screen("home")
    object Waiting : Screen("waiting")
    object CoffeeReady : Screen("coffee_ready")
}