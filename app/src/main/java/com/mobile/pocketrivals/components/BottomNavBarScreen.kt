package com.mobile.pocketrivals.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object Home: BottomNavBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object Heroes: BottomNavBarScreen(
        route = "heroes",
        title = "Heroes",
        icon = Icons.Default.Face
    )
    object Profile: BottomNavBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}