package com.mobile.pocketrivals.navigation.bottomNavBar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.ui.theme.Dimensions

@Composable
fun BottomBar(navController: NavHostController) {
  val screens =
    listOf(
      BottomBarItem.Home,
      BottomBarItem.Heroes,
      BottomBarItem.Profile,
    )
  val navBackStackEntry by navController.currentBackStackEntryAsState()
  val currentDestination = navBackStackEntry?.destination

  NavigationBar(contentColor = Color.White, containerColor = MaterialTheme.colorScheme.secondary) {
    screens.forEach { screen ->
      AddItem(
        screen = screen,
        currentDestination = currentDestination,
        navController = navController
      )
    }
  }
}

@Composable
fun RowScope.AddItem(
  screen: BottomBarItem,
  currentDestination: NavDestination?,
  navController: NavHostController
) {
  NavigationBarItem(
    label = { Text(text = screen.title) },
    icon = {
      // Since I´m using vector assets, with this I can use the imageVector property
      if (screen.iconRes != null) {
        Icon(
          painter = painterResource(id = screen.iconRes),
          contentDescription = stringResource(R.string.navigation_icon),
          modifier = Modifier.size(Dimensions.GoogleButtonIcon)
        )
      } else {
        Icon(
          imageVector = screen.icon,
          contentDescription = stringResource(R.string.navigation_icon),
          modifier = Modifier.size(Dimensions.GoogleButtonIcon)
        )
      }
    },
    selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
    onClick = {
      navController.navigate(screen.route) {
        popUpTo(navController.graph.findStartDestination().id)
        launchSingleTop = true
      }
    },
    colors =
      NavigationBarItemDefaults.colors(
        selectedIconColor = MaterialTheme.colorScheme.tertiary,
        unselectedIconColor = MaterialTheme.colorScheme.primary,
        selectedTextColor = MaterialTheme.colorScheme.tertiary,
        unselectedTextColor = MaterialTheme.colorScheme.primary,
        indicatorColor = Color.Transparent
      )
  )
}
