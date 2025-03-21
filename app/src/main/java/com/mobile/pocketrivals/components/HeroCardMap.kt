package com.mobile.pocketrivals.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mobile.pocketrivals.mocks.Hero


@Composable
fun HeroCardMap(heroes: List<Hero>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3), // Define 3 columnas por fila
        modifier = Modifier.fillMaxSize()
    ) {
        items(heroes) { hero ->
            HeroCard(heroImage = hero.imageUrl)
        }
    }
}


