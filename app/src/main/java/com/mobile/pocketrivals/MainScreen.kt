package com.mobile.pocketrivals

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.mobile.pocketrivals.components.bottomNavBar.BottomBar


@RequiresApi(Build.VERSION_CODES.O)
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


