package com.mobile.pocketrivals.components.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
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
    LazyRow(
        modifier = modifier
            .height(250.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(newsList) { patchNotes ->
            PatchNotesCard(patchNotes = patchNotes, navController)
        }
    }
}
