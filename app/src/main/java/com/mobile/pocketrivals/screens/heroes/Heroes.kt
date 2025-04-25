package com.mobile.pocketrivals.screens.heroes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mobile.pocketrivals.components.heroes.HeroCardMap
import com.mobile.pocketrivals.components.heroes.HeroSearchBar

@Composable
fun HeroesScreen(navController: NavController) {
    var searchText by remember { mutableStateOf("") }
    val heroesViewModel = hiltViewModel<HeroesViewModel>()

    val heroes by heroesViewModel.heroes.collectAsState()
    val filteredHeroes = remember(searchText, heroes) {
        if (searchText.isEmpty()) {
            heroes
        } else {
            heroes.filter { hero ->
                hero.name.contains(searchText, ignoreCase = true)
            }
        }
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HeroSearchBar(
            text = searchText,
            onTextChange = { searchText = it },
        )
        HeroCardMap(heroes = filteredHeroes, navController)
    }
}
