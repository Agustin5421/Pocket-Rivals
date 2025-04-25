package com.mobile.pocketrivals

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.fragment.app.FragmentActivity
import androidx.navigation.compose.rememberNavController
import com.mobile.pocketrivals.components.home.TopBar
import com.mobile.pocketrivals.navigation.NavHostComposable
import com.mobile.pocketrivals.navigation.bottomNavBar.BottomBar
import com.mobile.pocketrivals.ui.theme.PocketRivalsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : FragmentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      val navController = rememberNavController()
      PocketRivalsTheme {
        Scaffold(
          modifier = Modifier.fillMaxSize(),
          topBar = { TopBar(navController) },
          bottomBar = { BottomBar(navController) }
        ) { innerPadding ->
          NavHostComposable(innerPadding, navController)
        }
      }
    }
  }
}
