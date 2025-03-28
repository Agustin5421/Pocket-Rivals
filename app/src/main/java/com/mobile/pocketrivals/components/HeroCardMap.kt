package com.mobile.pocketrivals.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mobile.pocketrivals.mocks.Hero


@Composable
fun HeroCardMap(heroes: List<Hero>, navController: NavController) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize()
    ) {
        items(heroes) { hero ->
            HeroCard(
                heroImage = hero.imageUrl,
                onClick = { navController.navigate("heroDetail/${hero.id}") }
            )
        }
    }
}


