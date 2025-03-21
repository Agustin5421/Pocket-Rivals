package com.mobile.pocketrivals.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mobile.pocketrivals.components.HeroCardMap
import com.mobile.pocketrivals.mocks.mockHeroes

@Composable
fun HeroesScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        HeroCardMap(heroes = mockHeroes.heroes)
    }
}
