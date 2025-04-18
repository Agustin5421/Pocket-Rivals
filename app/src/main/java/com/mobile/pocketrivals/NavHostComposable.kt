package com.mobile.pocketrivals

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mobile.pocketrivals.components.bottomNavBar.BottomBarItem
import com.mobile.pocketrivals.screens.ProfileScreen
import com.mobile.pocketrivals.screens.heroes.HeroDetailScreen
import com.mobile.pocketrivals.screens.heroes.HeroesScreen
import com.mobile.pocketrivals.screens.home.HomeScreen
import com.mobile.pocketrivals.screens.home.PatchNotes
import com.mobile.pocketrivals.screens.home.SettingsScreen

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
        composable(route = "${PocketRivalsScreen.PatchNote}/{patchNotes}",
            arguments = listOf(navArgument("patchNotes") { type = NavType.StringType })
        ) { backStackEntry ->
            val patchNotesId = backStackEntry.arguments?.getString("patchNotes")
            PatchNotes(patchNotesId = patchNotesId)
        }

    }
}