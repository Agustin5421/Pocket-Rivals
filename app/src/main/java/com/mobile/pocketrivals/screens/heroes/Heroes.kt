package com.mobile.pocketrivals.screens.heroes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.mobile.pocketrivals.components.heroes.HeroCardMap
import com.mobile.pocketrivals.components.heroes.HeroSearchBar
import com.mobile.pocketrivals.ui.theme.Dimensions

@Composable
fun HeroesScreen(navController: NavController) {
  var searchText by remember { mutableStateOf("") }
  val heroesViewModel = hiltViewModel<HeroesViewModel>()
  val heroes by heroesViewModel.heroes.collectAsStateWithLifecycle()

  val loading by heroesViewModel.loading.collectAsStateWithLifecycle()
  val retry by heroesViewModel.showRetry.collectAsStateWithLifecycle()

  val filteredHeroes =
    remember(searchText, heroes) {
      if (searchText.isEmpty()) {
        heroes
      } else {
        heroes.filter { hero -> hero.name.contains(searchText, ignoreCase = true) }
      }
    }

  Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
    if (loading) {
      CircularProgressIndicator(
        color = MaterialTheme.colorScheme.tertiary,
        modifier = Modifier.size(Dimensions.LoaderSize),
      )
    } else if (retry) {
      Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("There was an error")
        Button(onClick = heroesViewModel::retryApiCall) { Text("Retry") }
      }
    } else {
      Column(modifier = Modifier.fillMaxSize()) {
        HeroSearchBar(
          text = searchText,
          onTextChange = { searchText = it },
        )
        HeroCardMap(heroes = filteredHeroes, navController)
      }
    }
  }
}
