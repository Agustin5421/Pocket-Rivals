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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.rememberAsyncImagePainter
import com.mobile.pocketrivals.components.herodetail.Section
import com.mobile.pocketrivals.data.PatchNote
import com.mobile.pocketrivals.screens.home.HomeViewModel

@Composable
fun PatchNotesScreen(patchNotesId: String?) {
  val viewModel: HomeViewModel = hiltViewModel()
  val patchNotes by viewModel.patchNotes.collectAsStateWithLifecycle()

  val patch = remember(patchNotesId, patchNotes) { patchNotes.find { it.id == patchNotesId } }

  if (patch != null) {
    PatchNoteDetailContent(patch)
  } else {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
      Text(text = "Patch note not found", color = Color.Red)
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
        .padding(bottom = 16.dp)
        .padding(horizontal = 16.dp),
  ) {
    // Header
    Text(
      text = patchNote.title,
      fontSize = 24.sp,
      fontWeight = FontWeight.Bold,
      color = MaterialTheme.colorScheme.primary,
      modifier = Modifier.padding(bottom = 8.dp)
    )

    Text(
      text = "Date: ${patchNote.date}",
      fontSize = 14.sp,
      color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
      modifier = Modifier.padding(bottom = 16.dp)
    )

    // Banner image
    val baseUrl = "https://marvelrivalsapi.com/rivals"
    val fullImageUrl = "$baseUrl${patchNote.imagePath}"
    val imagePainter = rememberAsyncImagePainter(model = fullImageUrl)

    Box(modifier = Modifier.fillMaxWidth().height(250.dp).padding(bottom = 16.dp)) {
      Image(
        painter = imagePainter,
        contentDescription = patchNote.title,
        modifier = Modifier.fillMaxSize().clip(RoundedCornerShape(8.dp)),
        contentScale = ContentScale.Crop
      )
    }

    // Overview
    Section(title = "Summary") {
      Text(
        text = patchNote.overview,
        fontSize = 16.sp,
        color = MaterialTheme.colorScheme.onBackground,
        modifier = Modifier.padding(bottom = 16.dp)
      )
    }

    Spacer(modifier = Modifier.height(16.dp))

    // Full content
    Section(title = "New changes") {
      val sections = parseFullContent(patchNote.fullContent)

      sections.forEach { (sectionTitle, sectionContent) ->
        if (sectionTitle.isNotEmpty()) {
          Text(
            text = sectionTitle,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
          )
        }

        Text(
          text = sectionContent,
          fontSize = 15.sp,
          color = MaterialTheme.colorScheme.onBackground,
          lineHeight = 24.sp
        )
      }
    }

    Spacer(modifier = Modifier.height(24.dp))
  }
}

// This is straight from Chatgpt, I ain´t hiding it
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
