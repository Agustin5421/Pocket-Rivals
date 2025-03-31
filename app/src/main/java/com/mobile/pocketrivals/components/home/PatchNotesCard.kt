package com.mobile.pocketrivals.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mobile.pocketrivals.R


@Composable
fun PatchNotesCard(modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.patch_notes)
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp),
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop,
            painter = image,
            contentDescription = null
        )
    }
}