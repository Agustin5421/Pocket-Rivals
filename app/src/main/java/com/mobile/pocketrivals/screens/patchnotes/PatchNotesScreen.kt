package com.mobile.pocketrivals.screens.patchnotes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.components.herodetail.Section
import com.mobile.pocketrivals.data.PatchNote
import com.mobile.pocketrivals.screens.home.HomeViewModel
import com.mobile.pocketrivals.ui.theme.Dimensions

@Composable
fun PatchNotesScreen(patchNotesId: String?) {
  val viewModel: HomeViewModel = hiltViewModel()
  val patchNotes by viewModel.patchNotes.collectAsStateWithLifecycle()

  val loading by viewModel.loading.collectAsStateWithLifecycle()
  val retry by viewModel.showRetry.collectAsStateWithLifecycle()

  val patch = remember(patchNotesId, patchNotes) { patchNotes.find { it.id == patchNotesId } }

  Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
    if (loading) {
      CircularProgressIndicator(
        color = MaterialTheme.colorScheme.tertiary,
        modifier = Modifier.size(Dimensions.LoaderSize)
      )
    } else if (retry) {
      Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(stringResource(R.string.there_was_an_error))
        Button(onClick = viewModel::retryApiCall) { Text(stringResource(R.string.retry)) }
      }
    } else if (patch == null) {
      Text(text = stringResource(R.string.patch_note_not_found), color = Color.Red)
    } else {
      PatchNoteDetailContent(patch)
    }
  }
}

@Composable
fun PatchNoteDetailContent(patchNote: PatchNote) {
  val scrollState = rememberScrollState()

  Column(
    modifier =
      Modifier.fillMaxSize()
        .verticalScroll(scrollState)
        .padding(bottom = Dimensions.MediumPadding)
        .padding(horizontal = Dimensions.MediumPadding),
  ) {
    val baseUrl = stringResource(R.string.https_marvelrivalsapi_com_rivals)
    val fullImageUrl = "$baseUrl${patchNote.imagePath}"
    val imagePainter = rememberAsyncImagePainter(model = fullImageUrl)

    Box(
      modifier =
        Modifier.fillMaxWidth()
          .height(Dimensions.PatchCardHeight)
          .padding(bottom = Dimensions.MediumPadding)
    ) {
      Image(
        painter = imagePainter,
        contentDescription = patchNote.title,
        modifier =
          Modifier.fillMaxSize()
            .clip(RoundedCornerShape(Dimensions.SmallRoundedCorner))
            .padding(top = Dimensions.LargePadding),
        contentScale = ContentScale.Crop
      )
    }

    Text(
      text = patchNote.title,
      style = MaterialTheme.typography.titleMedium,
      fontWeight = FontWeight.Bold,
      color = MaterialTheme.colorScheme.onPrimary,
      modifier =
        Modifier.padding(top = Dimensions.LargePadding).padding(bottom = Dimensions.MediumPadding)
    )

    Text(
      text = stringResource(R.string.date, patchNote.date),
      fontSize = Dimensions.SmallFontSize,
      color = MaterialTheme.colorScheme.onPrimary,
      modifier = Modifier.padding(bottom = Dimensions.MediumPadding)
    )

    Section(title = stringResource(R.string.summary)) {
      Text(
        text = patchNote.overview,
        fontSize = Dimensions.MediumFontSize,
        color = MaterialTheme.colorScheme.onPrimary,
        modifier = Modifier.padding(bottom = Dimensions.MediumPadding)
      )
    }

    Spacer(modifier = Modifier.height(Dimensions.MediumSpacer))

    Section(title = stringResource(R.string.new_changes)) {
      Text(
        text = patchNote.fullContent,
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.onPrimary,
      )
    }

    Spacer(modifier = Modifier.height(Dimensions.LargeSpacer))
  }
}
