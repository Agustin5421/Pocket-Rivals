package com.mobile.pocketrivals.screens.heroes

import com.mobile.pocketrivals.components.heroes.HeroSearchBar
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mobile.pocketrivals.components.heroes.HeroCardMap
import com.mobile.pocketrivals.mocks.mockHeroes

@Composable
fun HeroesScreen(navController: NavController) {
    var searchText by remember { mutableStateOf("") }
    val heroesViewModel = HeroesViewModel()
    val originalHeroes = heroesViewModel.getHeroes()

    val filteredHeroes = remember(searchText) {
        if (searchText.isEmpty()) {
            originalHeroes
        } else {
            originalHeroes.filter { hero ->
                hero.name.contains(searchText, ignoreCase = true)
            }
        }
    }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            HeroSearchBar(
                text = searchText,
                onTextChange = { searchText = it },
            )
            HeroCardMap(heroes = filteredHeroes, navController)
        }
    }

}
