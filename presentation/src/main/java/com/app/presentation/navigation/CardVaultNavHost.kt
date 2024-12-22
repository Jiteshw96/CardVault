package com.app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.app.presentation.ui.home.HomeScreen


@Composable
fun CardVaultNavHost(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = Navigation.Home.destination) {
        composable(Navigation.Home.destination) {
            HomeScreen()
        }
    }
}