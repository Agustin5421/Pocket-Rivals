package com.mobile.pocketrivals

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.mobile.pocketrivals.components.bottomNavBar.BottomBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(){
    val navController = rememberNavController()
    Scaffold (
        bottomBar = { BottomBar(navController = navController)}
    ) {
        NavHostComposable(navController = navController)
    }
}
