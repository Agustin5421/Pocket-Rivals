package com.mobile.pocketrivals.components.heroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.compose.rememberAsyncImagePainter
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.ui.theme.Dimensions

@Composable
fun HeroCard(heroImage: String, onClick: () -> Unit) {
  // TODO: replace with saved string
  val baseUrl = stringResource(R.string.https_marvelrivalsapi_com)
  val fullImageUrl = "$baseUrl$heroImage"
  val imagePainter = rememberAsyncImagePainter(model = fullImageUrl)

  Box(
    modifier = Modifier.fillMaxSize().padding(Dimensions.MediumPadding).clickable { onClick() },
    contentAlignment = Alignment.TopStart
  ) {
    Card(modifier = Modifier.size(width = Dimensions.MediumCard, height = Dimensions.MediumCard)) {
      Image(
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop,
        painter = imagePainter,
        contentDescription = null,
        alignment = Alignment.TopCenter
      )
    }
  }
}
