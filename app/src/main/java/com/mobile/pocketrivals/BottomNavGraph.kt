package com.mobile.pocketrivals

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mobile.pocketrivals.components.bottomNavBar.BottomNavBarScreenType
import com.mobile.pocketrivals.screens.HeroesScreen
import com.mobile.pocketrivals.screens.HomeScreen
import com.mobile.pocketrivals.screens.ProfileScreen

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost (
        navController = navController,
        startDestination = BottomNavBarScreenType.Home.route
    ) {
        composable(route = BottomNavBarScreenType.Home.route) {
            HomeScreen()
        }
        composable(route = BottomNavBarScreenType.Heroes.route) {
            HeroesScreen()
        }
        composable(route = BottomNavBarScreenType.Profile.route) {
            ProfileScreen()
        }
    }

}