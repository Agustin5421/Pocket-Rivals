package com.mobile.pocketrivals.screens.heroes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel

//TODO: is it supposed to be that lagged?
@Composable
fun HeroDetailScreen(heroId: String?) {
    val viewModel: HeroesViewModel = hiltViewModel()
    val heroes by viewModel.heroes.collectAsState()

    val hero = remember(heroId, heroes) {
        heroes.find { it.id == heroId }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Hero's name is: " + hero?.name, color = Color.Black)
    }
}
