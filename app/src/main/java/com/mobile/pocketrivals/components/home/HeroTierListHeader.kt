package com.mobile.pocketrivals.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// TODO: extract text
@Composable
fun HeroTierListHeader() {
  Row(
    modifier =
      Modifier.fillMaxWidth()
        .background(MaterialTheme.colorScheme.onBackground)
        .padding(vertical = 12.dp, horizontal = 8.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      text = "#",
      modifier = Modifier.weight(0.5f),
      textAlign = TextAlign.Center,
      fontWeight = FontWeight.Bold,
      fontSize = 14.sp
    )
    Text(
      text = "Hero",
      modifier = Modifier.weight(1f),
      textAlign = TextAlign.Center,
      fontWeight = FontWeight.Bold,
      fontSize = 14.sp
    )
    Text(
      text = "Role",
      modifier = Modifier.weight(1f),
      textAlign = TextAlign.Center,
      fontWeight = FontWeight.Bold,
      fontSize = 14.sp
    )
    Text(
      text = "Win %",
      modifier = Modifier.weight(1f),
      textAlign = TextAlign.Center,
      fontWeight = FontWeight.Bold,
      fontSize = 14.sp
    )
    Text(
      text = "Pick %",
      modifier = Modifier.weight(1f),
      textAlign = TextAlign.Center,
      fontWeight = FontWeight.Bold,
      fontSize = 14.sp
    )
    Text(
      text = "Ban %",
      modifier = Modifier.weight(1f),
      textAlign = TextAlign.Center,
      fontWeight = FontWeight.Bold,
      fontSize = 14.sp
    )
  }
}

@Preview
@Composable
fun PreviewChampionStatsHeader() {
  Column { HeroTierListHeader() }
}
