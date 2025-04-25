package com.mobile.pocketrivals.screens.herodetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mobile.pocketrivals.components.herodetail.AbilityCard
import com.mobile.pocketrivals.components.herodetail.DifficultyInfoRow
import com.mobile.pocketrivals.components.herodetail.InfoRow
import com.mobile.pocketrivals.components.herodetail.MainCard
import com.mobile.pocketrivals.components.herodetail.Section
import com.mobile.pocketrivals.screens.heroes.HeroesViewModel
import com.mobile.pocketrivals.ui.theme.Black10
import com.mobile.pocketrivals.ui.theme.White

// TODO: make another viewmodel for this screen
// TODO: extract text
// TODO: should do a switch for heroes who have more than 1 form
@Composable
fun HeroDetailScreen(heroId: String?) {
  val viewModel = hiltViewModel<HeroesViewModel>()
  val heroes by viewModel.heroes.collectAsStateWithLifecycle()

  val hero = remember(heroId, heroes) { heroes.find { it.id == heroId } }

  if (hero == null) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
      Text("Hero not found", color = Color.Black)
    }
    return
  }

  val scrollState = rememberScrollState()

  Column(
    modifier = Modifier.fillMaxSize().verticalScroll(scrollState).background(White).padding(16.dp)
  ) {
    // Header
    MainCard(hero)

    Spacer(modifier = Modifier.height(24.dp))

    // Basic Info
    Section(title = "Basic Information") {
      InfoRow("Attack Type", hero.attackType)
      DifficultyInfoRow(difficultyString = hero.difficulty)
      InfoRow("Member of", hero.team.joinToString(", "))
    }

    Spacer(modifier = Modifier.height(16.dp))

    // Bio
    Section(title = "Biography") {
      Text(
        text = hero.bio,
        fontSize = 14.sp,
        color = Black10,
        modifier = Modifier.padding(vertical = 8.dp)
      )
    }

    Spacer(modifier = Modifier.height(16.dp))

    // Abilities
    Section(title = "Abilities") {
      for (ability in hero.abilities) {
        AbilityCard(ability)
        Spacer(modifier = Modifier.height(8.dp))
      }
    }

    Spacer(modifier = Modifier.height(16.dp))

    Section(title = "Lore") {
      Text(
        text = hero.lore,
        fontSize = 14.sp,
        color = Black10,
        modifier = Modifier.padding(vertical = 8.dp)
      )
    }

    Spacer(modifier = Modifier.height(32.dp))
  }
}

fun String.toTitleCase(): String {
  return this.split(" ").joinToString(" ") {
    it.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
  }
}
