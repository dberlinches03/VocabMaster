package com.david.vocabmaster.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import com.david.vocabmaster.model.HomeViewModel
import com.david.vocabmaster.ui.game.GameScreen
import com.david.vocabmaster.ui.login.LoginScreen
import com.david.vocabmaster.ui.register.RegisterScreen
import com.david.vocabmaster.ui.home.HomeScreen
import com.david.vocabmaster.ui.settings.SettingsScreen
import com.david.vocabmaster.ui.learned.LearnedWordsScreen
import com.david.vocabmaster.ui.stats.StatsScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Login.route
    ) {
        composable(NavRoute.Login.route) {
            LoginScreen(navController)
        }
        composable(NavRoute.Register.route) {
            RegisterScreen(navController)
        }
        composable(NavRoute.Home.route) {
            HomeScreen(navController)
        }
        composable(NavRoute.Settings.route) {
            SettingsScreen(navController)
        }
        composable(NavRoute.Learned.route) {
            LearnedWordsScreen(navController)
        }
        composable(NavRoute.Stats.route) {
            StatsScreen(navController)
        }
        composable(NavRoute.Game.route) {
            GameScreen(navController)
        }
    }
}
