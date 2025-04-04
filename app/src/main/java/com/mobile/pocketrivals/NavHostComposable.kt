package com.mobile.pocketrivals

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mobile.pocketrivals.components.bottomNavBar.BottomBarItem
import com.mobile.pocketrivals.screens.HeroDetailScreen
import com.mobile.pocketrivals.screens.HeroesScreen
import com.mobile.pocketrivals.screens.HomeScreen
import com.mobile.pocketrivals.screens.ProfileScreen
import com.mobile.pocketrivals.screens.SettingsScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavHostComposable(navController: NavHostController) {
    NavHost (
        navController = navController,
        startDestination = BottomBarItem.Home.route
    ) {
        composable(route = BottomBarItem.Home.route) {
            HomeScreen(navController)
        }
        composable(route = BottomBarItem.Heroes.route) {
            HeroesScreen(navController)
        }
        composable(route = BottomBarItem.Profile.route) {
            ProfileScreen()
        }
        composable(route = "${PocketRivalsScreen.HeroDetail}/{heroId}",
            arguments = listOf(navArgument("heroId") { type = NavType.StringType })
        ) { backStackEntry ->
            val heroId = backStackEntry.arguments?.getString("heroId")
            HeroDetailScreen(heroId = heroId)
        }
        composable(route = PocketRivalsScreen.Settings.name) {
            SettingsScreen()
        }

    }
}