package com.mobile.pocketrivals.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.components.home.HeroStats
import com.mobile.pocketrivals.components.home.HeroTierList
import com.mobile.pocketrivals.components.home.PatchNotesCarousel
import com.mobile.pocketrivals.mocks.mockNews

@Composable
fun HomeScreen(navController: NavController) {

    Scaffold{ innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val news = mockNews
            PatchNotesCarousel(newsList = listOf(news, news, news), navController = navController)

            val heroStats = listOf(
                HeroStats(
                    rank = 1,
                    championName = "hero",
                    championIconResId = R.drawable.mock_hero_image,
                    roleIconResId = R.drawable.dps_image,
                    winRate = "1",
                    pickRate = "1",
                    banRate = "1"
                )
            )
            HeroTierList(modifier = Modifier.padding(top = 8.dp), heroStats)
        }
    }
}