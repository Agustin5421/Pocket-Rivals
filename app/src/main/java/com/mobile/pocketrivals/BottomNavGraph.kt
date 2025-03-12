package com.mobile.pocketrivals

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mobile.pocketrivals.components.BottomNavBarScreen
import com.mobile.pocketrivals.screens.HeroesScreen
import com.mobile.pocketrivals.screens.HomeScreen
import com.mobile.pocketrivals.screens.ProfileScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost (
        navController = navController,
        startDestination = BottomNavBarScreen.Home.route
    ) {
        composable(route = BottomNavBarScreen.Home.route) {
            HomeScreen()
        }
        composable(route = BottomNavBarScreen.Heroes.route) {
            HeroesScreen()
        }
        composable(route = BottomNavBarScreen.Profile.route) {
            ProfileScreen()
        }
    }

}