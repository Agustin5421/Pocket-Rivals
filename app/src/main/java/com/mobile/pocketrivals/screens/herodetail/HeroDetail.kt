package com.mobile.pocketrivals.screens.herodetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.components.herodetail.AbilityCard
import com.mobile.pocketrivals.components.herodetail.DifficultyInfoRow
import com.mobile.pocketrivals.components.herodetail.HeroMainCard
import com.mobile.pocketrivals.components.herodetail.InfoRow
import com.mobile.pocketrivals.components.herodetail.Section
import com.mobile.pocketrivals.data.Hero
import com.mobile.pocketrivals.ui.theme.Dimensions

@Composable
fun HeroDetailScreen(heroId: String?) {
  val viewModel = hiltViewModel<HeroDetailViewModel>()

  val hero by viewModel.hero.collectAsStateWithLifecycle()
  val loading by viewModel.loading.collectAsStateWithLifecycle()
  val retry by viewModel.showRetry.collectAsStateWithLifecycle()

  LaunchedEffect(heroId) {
    if (heroId != null) {
      viewModel.loadHeroById(heroId)
    }
  }

  Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
    if (loading) {
      CircularProgressIndicator(
        color = MaterialTheme.colorScheme.tertiary,
        modifier = Modifier.size(Dimensions.LoaderSize)
      )
    } else if (retry) {
      Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(stringResource(R.string.there_was_an_error))
        Button(onClick = { heroId?.let { viewModel.retryApiCall(it) } }) {
          Text(stringResource(R.string.retry))
        }      }
    } else if (hero == null) {
      Text(stringResource(R.string.hero_not_found), color = MaterialTheme.colorScheme.secondary)
    } else {
      if (hero != null) {
        HeroDetailContent(hero!!)
      }
    }
  }
}

@Composable
fun HeroDetailContent(hero: Hero) {
  val scrollState = rememberScrollState()

  Column(
    modifier =
      Modifier.fillMaxSize()
        .verticalScroll(scrollState)
        .background(MaterialTheme.colorScheme.background)
        .padding(Dimensions.MediumPadding)
  ) {
    // Header
    HeroMainCard(hero)

    Spacer(modifier = Modifier.height(Dimensions.LargeSpacer))

    // Basic Info
    Section(title = stringResource(R.string.basic_information)) {
      InfoRow(stringResource(R.string.attack_type), hero.attackType)
      DifficultyInfoRow(difficultyString = hero.difficulty)
      InfoRow(stringResource(R.string.member_of), hero.team.joinToString(", "))
    }

    Spacer(modifier = Modifier.height(Dimensions.MediumSpacer))

    // Bio
    Section(title = stringResource(R.string.biography)) {
      Text(
        text = hero.bio,
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.secondary,
        modifier = Modifier.padding(vertical = Dimensions.SmallPadding)
      )
    }

    Spacer(modifier = Modifier.height(Dimensions.MediumSpacer))

    // Abilities
    Section(title = stringResource(R.string.abilities)) {
      for (ability in hero.abilities) {
        AbilityCard(ability)
        Spacer(modifier = Modifier.height(Dimensions.SmallSpacer))
      }
    }

    Spacer(modifier = Modifier.height(Dimensions.MediumSpacer))

    // Lore
    Section(title = stringResource(R.string.lore)) {
      Text(
        text = hero.lore,
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.secondary,
        modifier = Modifier.padding(vertical = Dimensions.SmallPadding)
      )
    }

    Spacer(modifier = Modifier.height(Dimensions.ExtraLargeSpacer))
  }
}

fun String.toTitleCase(): String {
  return this.split(" ").joinToString(" ") {
    it.replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
  }
}
