package com.mobile.pocketrivals.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.components.home.news.PatchNotesCarousel
import com.mobile.pocketrivals.components.home.tierlist.HeroStats
import com.mobile.pocketrivals.ui.theme.Dimensions

@Composable
fun HomeScreen(navController: NavController) {
  val homeViewModel = hiltViewModel<HomeViewModel>()
  val patchNotes by homeViewModel.patchNotes.collectAsStateWithLifecycle()
  val loading by homeViewModel.loading.collectAsStateWithLifecycle()
  val retry by homeViewModel.showRetry.collectAsStateWithLifecycle()

  Scaffold { innerPadding ->
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
      if (loading) {
        CircularProgressIndicator(
          color = MaterialTheme.colorScheme.tertiary,
          modifier = Modifier.size(Dimensions.LoaderSize)
        )
      } else if (retry) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
          Text(stringResource(R.string.there_was_an_error))
          Button(onClick = homeViewModel::retryApiCall) { Text(stringResource(R.string.retry)) }
        }
      } else {

        Column(
          modifier = Modifier.fillMaxSize(),
          verticalArrangement = Arrangement.Top,
        ) {
          Text(
            text = stringResource(R.string.welcome_to_pocket_rivals),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier
              .padding(Dimensions.LargePadding)
              .padding(top = Dimensions.ExtraLargePadding),
            textAlign = TextAlign.Left,
            fontWeight = FontWeight.Bold
          )
          PatchNotesCarousel(patchNotes, navController = navController)

          //HeroTierList(modifier = Modifier, mockHeroStats)
        }
      }
    }
  }
}

val mockHeroStats =
  listOf(
    HeroStats(
      rank = 1,
      championName = "hero",
      championIconResId = R.drawable.mock_hero_image,
      roleIconResId = R.drawable.dps_image,
      winRate = "55.31%",
      pickRate = "42.31%",
      banRate = "22.09%"
    ),
    HeroStats(
      rank = 2,
      championName = "hero",
      championIconResId = R.drawable.loki_image_mock,
      roleIconResId = R.drawable.strategist_image,
      winRate = "52.31%",
      pickRate = "37.31%",
      banRate = "23.09%"
    ),
    HeroStats(
      rank = 3,
      championName = "hero",
      championIconResId = R.drawable.knull_mock,
      roleIconResId = R.drawable.vanguard_image,
      winRate = "50.31%",
      pickRate = "43.09%",
      banRate = "21.09%"
    ),
    HeroStats(
      rank = 4,
      championName = "hero",
      championIconResId = R.drawable.daredevil_image_mock,
      roleIconResId = R.drawable.dps_image,
      winRate = "32.31%",
      pickRate = "21.31%",
      banRate = "11.09%"
    )
  )
