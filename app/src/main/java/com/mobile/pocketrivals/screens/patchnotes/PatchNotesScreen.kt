package com.mobile.pocketrivals.screens.patchnotes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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

  val patch = remember(patchNotesId, patchNotes) { patchNotes.find { it.id == patchNotesId } }

  if (patch != null) {
    PatchNoteDetailContent(patch)
  } else {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
      Text(text = stringResource(R.string.patch_note_not_found), color = Color.Red)
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
    Text(
      text = patchNote.title,
      fontSize = Dimensions.LargeFontSize,
      fontWeight = FontWeight.Bold,
      color = MaterialTheme.colorScheme.primary,
      modifier = Modifier.padding(bottom = Dimensions.SmallPadding)
    )

    Text(
      text = "Date: ${patchNote.date}",
      fontSize = Dimensions.SmallFontSize,
      color = MaterialTheme.colorScheme.onSurface,
      modifier = Modifier.padding(bottom = Dimensions.MediumPadding)
    )

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
        modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(Dimensions.SmallRoundedCorner)),
        contentScale = ContentScale.Crop
      )
    }

    Section(title = stringResource(R.string.summary)) {
      Text(
        text = patchNote.overview,
        fontSize = Dimensions.MediumFontSize,
        color = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier.padding(bottom = Dimensions.MediumPadding)
      )
    }

    Spacer(modifier = Modifier.height(Dimensions.MediumSpacer))

    Section(title = stringResource(R.string.new_changes)) {
      val sections = parseFullContent(patchNote.fullContent)

      sections.forEach { (sectionTitle, sectionContent) ->
        if (sectionTitle.isNotEmpty()) {
          Text(
            text = sectionTitle,
            fontSize = Dimensions.MediumFontSize,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.secondary,
            modifier =
              Modifier.padding(top = Dimensions.MediumPadding, bottom = Dimensions.SmallPadding)
          )
        }

        Text(
          text = sectionContent,
          fontSize = Dimensions.SmallFontSize,
          color = MaterialTheme.colorScheme.onBackground,
          lineHeight = Dimensions.MediumFontSize
        )
      }
    }

    Spacer(modifier = Modifier.height(Dimensions.LargeSpacer))
  }
}

private fun parseFullContent(fullContent: String): List<Pair<String, String>> {
  val sections = mutableListOf<Pair<String, String>>()
  val lines = fullContent.split("\n")

  var currentTitle = ""
  var currentContent = StringBuilder()

  lines.forEach { line ->
    when {
      line.trim().isNotEmpty() && line.trim() == line.trim().uppercase() && !line.contains(" ") -> {
        if (currentContent.isNotEmpty()) {
          sections.add(Pair(currentTitle, currentContent.toString().trim()))
          currentContent = StringBuilder()
        }
        currentTitle = line.trim()
      }
      else -> {
        if (line.trim().isNotEmpty()) {
          currentContent.append(line.trim()).append("\n")
        } else if (currentContent.isNotEmpty()) {
          currentContent.append("\n")
        }
      }
    }
  }

  if (currentContent.isNotEmpty()) {
    sections.add(Pair(currentTitle, currentContent.toString().trim()))
  }

  return sections
}
