package com.mobile.pocketrivals.components.bottomNavBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavBarScreenType(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home: BottomNavBarScreenType(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object Heroes: BottomNavBarScreenType(
        route = "heroes",
        title = "Heroes",
        icon = Icons.Default.Face
    )
    object Profile: BottomNavBarScreenType(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}