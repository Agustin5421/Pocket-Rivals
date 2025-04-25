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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.mobile.pocketrivals.PocketRivalsScreen
import com.mobile.pocketrivals.data.PatchNote

@Composable
fun PatchNotesCard(
  patchNotes: PatchNote,
  navController: NavController,
  modifier: Modifier = Modifier
) {
  // TODO: remove hardcoded baseUrl
  val baseUrl = "https://marvelrivalsapi.com/rivals"
  val fullImageUrl = "$baseUrl${patchNotes.imagePath}"
  val imagePainter = rememberAsyncImagePainter(model = fullImageUrl)

  Card(
    modifier =
      modifier.fillMaxWidth().height(230.dp).clickable {
        navController.navigate("${PocketRivalsScreen.PatchNotes}/${patchNotes.id}")
      },
    shape = RoundedCornerShape(8.dp),
    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
  ) {
    Image(
      painter = imagePainter,
      contentDescription = patchNotes.title,
      modifier = Modifier.fillMaxSize(),
      contentScale = ContentScale.Crop
    )
  }
}
