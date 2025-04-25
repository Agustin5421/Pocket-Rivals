package com.mobile.pocketrivals.components.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.mobile.pocketrivals.data.PatchNote
import com.mobile.pocketrivals.ui.theme.Dimensions
import kotlinx.coroutines.delay

// TODO: should the interval be defined in another place?
// TODO: this component currently only supports patch notes, but I would like to make it able to
// support other types of news in the future
@Composable
fun PatchNotesCarousel(
  newsList: List<PatchNote>,
  modifier: Modifier = Modifier,
  navController: NavController,
  autoScrollInterval: Long = 3000L
) {
  val pagerState = rememberPagerState(pageCount = { newsList.size })

  LaunchedEffect(pagerState) {
    while (true) {
      delay(autoScrollInterval)
      val nextPage = (pagerState.currentPage + 1) % newsList.size
      pagerState.animateScrollToPage(nextPage)
    }
  }

  Box(modifier = modifier.fillMaxWidth().height(Dimensions.CarouselHeight)) {
    HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize()) { page ->
      Box(
        modifier = Modifier.fillMaxSize().padding(horizontal = Dimensions.MediumPadding),
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
