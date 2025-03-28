package com.mobile.pocketrivals.components.bottomNavBar

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.mobile.pocketrivals.PocketRivalsScreen
import com.mobile.pocketrivals.R

sealed class BottomBarItem(
    val route: String,
    val title: String,
    val icon: ImageVector,
    @DrawableRes val iconRes: Int? = null

){
    object Home: BottomBarItem(
        route = PocketRivalsScreen.Home.name,
        title = PocketRivalsScreen.Home.name,
        icon = Icons.Default.Home
    )
    object Heroes: BottomBarItem(
        route = PocketRivalsScreen.Heroes.name,
        title = PocketRivalsScreen.Heroes.name,
        icon = Icons.Default.Face,
        iconRes = R.drawable.loki_svgrepo_com
    )
    object Profile: BottomBarItem(
        route = PocketRivalsScreen.Profile.name,
        title = PocketRivalsScreen.Profile.name,
        icon = Icons.Default.Person
    )
}