package com.mobile.pocketrivals.screens.heroes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HeroDetailScreen(heroId: String?) {
    val heroesViewModel = hiltViewModel<HeroesViewModel>()
    val hero = heroesViewModel.getHeroById(heroId)

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Hero's name is: " + hero.name, color = Color.Black)
    }
}
