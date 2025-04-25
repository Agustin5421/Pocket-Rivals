package com.mobile.pocketrivals.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.mobile.pocketrivals.PocketRivalsScreen
import com.mobile.pocketrivals.navigation.bottomNavBar.BottomBarItem
import com.mobile.pocketrivals.screens.ProfileScreen
import com.mobile.pocketrivals.screens.herodetail.HeroDetailScreen
import com.mobile.pocketrivals.screens.heroes.HeroesScreen
import com.mobile.pocketrivals.screens.home.HomeScreen
import com.mobile.pocketrivals.screens.patchnotes.PatchNotesScreen
import com.mobile.pocketrivals.screens.settings.SettingsScreen

@Composable
fun NavHostComposable(innerPadding: PaddingValues, navController: NavHostController) {
  NavHost(
    navController = navController,
    startDestination = BottomBarItem.Home.route,
    modifier = Modifier.fillMaxSize().padding(innerPadding)
  ) {
    composable(route = BottomBarItem.Home.route) { HomeScreen(navController) }
    composable(route = BottomBarItem.Heroes.route) { HeroesScreen(navController) }
    composable(route = BottomBarItem.Profile.route) { ProfileScreen() }
    composable(
      route = "${PocketRivalsScreen.HeroDetail}/{heroId}",
      arguments = listOf(navArgument("heroId") { type = NavType.StringType })
    ) { backStackEntry ->
      val heroId = backStackEntry.arguments?.getString("heroId")
      HeroDetailScreen(heroId = heroId)
    }
    composable(route = PocketRivalsScreen.Settings.name) { SettingsScreen() }
    composable(
      route = "${PocketRivalsScreen.PatchNotes}/{patchNotes}",
      arguments = listOf(navArgument("patchNotes") { type = NavType.StringType })
    ) { backStackEntry ->
      val patchNotesId = backStackEntry.arguments?.getString("patchNotes")
      PatchNotesScreen(patchNotesId = patchNotesId)
    }
  }
}
