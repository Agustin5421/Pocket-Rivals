package com.mobile.pocketrivals.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun PatchNotes(patchNotesId: String?) {
  val homeViewModel = HomeViewModel()

  // TODO: change this
  val patchNote = homeViewModel.getNewsById(patchNotesId!!.toInt())

  Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
    Text(text = patchNote.title, color = Color.Black)
  }
}
