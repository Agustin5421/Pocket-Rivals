package com.mobile.pocketrivals.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.mobile.pocketrivals.PocketRivalsScreen
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.data.PatchNote
import com.mobile.pocketrivals.ui.theme.Dimensions

@Composable
fun PatchNotesCard(
  patchNotes: PatchNote,
  navController: NavController,
  modifier: Modifier = Modifier
) {
  val baseUrl = stringResource(R.string.https_marvelrivalsapi_com_rivals)
  val fullImageUrl = "$baseUrl${patchNotes.imagePath}"
  val imagePainter = rememberAsyncImagePainter(model = fullImageUrl)

  Card(
    modifier =
      modifier.fillMaxWidth().height(Dimensions.PatchCardHeight).clickable {
        navController.navigate("${PocketRivalsScreen.PatchNotes}/${patchNotes.id}")
      },
    shape = RoundedCornerShape(Dimensions.MediumRoundedCorner),
    elevation = CardDefaults.cardElevation(defaultElevation = Dimensions.Elevation)
  ) {
    Image(
      painter = imagePainter,
      contentDescription = patchNotes.title,
      modifier = Modifier.fillMaxSize(),
      contentScale = ContentScale.Crop
    )
  }
}
