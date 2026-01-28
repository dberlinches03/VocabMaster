package com.david.vocabmaster.navigation

sealed class NavRoute(val route: String) {
    object Login : NavRoute("login")
    object Register : NavRoute("register")
    object Home : NavRoute("home")
    object Settings : NavRoute("settings")
    object Learned : NavRoute("learned")
    object Stats : NavRoute("stats")
}