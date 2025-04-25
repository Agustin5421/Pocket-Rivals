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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.ui.theme.Dimensions

private data class HeaderItem(val text: String, val weight: Float)

@Composable
fun HeroTierListHeader() {
  val headerItems =
    listOf(
      HeaderItem(stringResource(R.string.numeral), Dimensions.SmallWeight),
      HeaderItem(stringResource(R.string.hero), Dimensions.MediumWeight),
      HeaderItem(stringResource(R.string.role), Dimensions.MediumWeight),
      HeaderItem(stringResource(R.string.win), Dimensions.MediumWeight),
      HeaderItem(stringResource(R.string.pick), Dimensions.MediumWeight),
      HeaderItem(stringResource(R.string.ban), Dimensions.MediumWeight)
    )

  Row(
    modifier =
      Modifier.fillMaxWidth()
        .background(MaterialTheme.colorScheme.onBackground)
        .padding(vertical = Dimensions.MediumPadding, horizontal = Dimensions.MediumPadding),
    verticalAlignment = Alignment.CenterVertically
  ) {
    headerItems.forEach { item ->
      Text(
        text = item.text,
        modifier = Modifier.weight(item.weight),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = Dimensions.SmallFontSize
      )
    }
  }
}

@Preview
@Composable
fun PreviewChampionStatsHeader() {
  Column { HeroTierListHeader() }
}
