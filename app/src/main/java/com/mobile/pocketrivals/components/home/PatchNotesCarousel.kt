package com.mobile.pocketrivals.components.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mobile.pocketrivals.mocks.PatchNotes

@Composable
fun PatchNotesCarousel(
  newsList: List<PatchNotes>,
  modifier: Modifier = Modifier,
  navController: NavController
) {
  val pagerState = rememberPagerState(pageCount = { newsList.size })

  Box(modifier = modifier.fillMaxWidth().height(250.dp)) {
    HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize()) { page ->
      Box(
        modifier = Modifier.fillMaxSize().padding(horizontal = 8.dp),
        contentAlignment = Alignment.Center
      ) {
        PatchNotesCard(
          patchNotes = newsList[page],
          navController = navController,
          modifier = Modifier.fillMaxWidth()
        )
      }
    }
  }
}
