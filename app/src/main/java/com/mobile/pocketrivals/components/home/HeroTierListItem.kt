package com.mobile.pocketrivals.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.ui.theme.Dimensions

// TODO: on fetching the data from the API
// TODO: I should create these entities and save them in the DB
data class HeroStats(
  val rank: Int,
  val championName: String,
  val championIconResId: Int,
  val roleIconResId: Int,
  val winRate: String,
  val pickRate: String,
  val banRate: String
)

@Composable
fun HeroTierListItem(stats: HeroStats, modifier: Modifier = Modifier) {
  Row(
    modifier =
      modifier
        .fillMaxWidth()
        .padding(vertical = Dimensions.LargePadding, horizontal = Dimensions.MediumPadding),
    verticalAlignment = Alignment.CenterVertically
  ) {
    // Rank
    Box(modifier = Modifier.weight(Dimensions.SmallWeight), contentAlignment = Alignment.Center) {
      Text(
        text = stats.rank.toString(),
        fontSize = Dimensions.SmallFontSize,
        textAlign = TextAlign.Center
      )
    }

    // Hero image
    Box(modifier = Modifier.weight(Dimensions.MediumWeight), contentAlignment = Alignment.Center) {
      Image(
        painter = painterResource(id = stats.championIconResId),
        contentDescription = stats.championName,
        contentScale = ContentScale.Crop,
        modifier =
          Modifier.size(Dimensions.SmallImage)
            .clip(RoundedCornerShape(Dimensions.MediumRoundedCorner))
      )
    }

    // Role
    Box(modifier = Modifier.weight(Dimensions.MediumWeight), contentAlignment = Alignment.Center) {
      Icon(
        painter = painterResource(id = stats.roleIconResId),
        contentDescription = stringResource(R.string.role),
        modifier = Modifier.size(Dimensions.SmallImage / 2),
        tint = MaterialTheme.colorScheme.secondary
      )
    }

    // Win Rate
    Box(modifier = Modifier.weight(Dimensions.MediumWeight), contentAlignment = Alignment.Center) {
      Text(text = stats.winRate, fontSize = Dimensions.SmallFontSize, textAlign = TextAlign.Center)
    }

    // Pick Rate
    Box(modifier = Modifier.weight(Dimensions.MediumWeight), contentAlignment = Alignment.Center) {
      Text(text = stats.pickRate, fontSize = Dimensions.SmallFontSize, textAlign = TextAlign.Center)
    }

    // Ban Rate
    Box(modifier = Modifier.weight(Dimensions.MediumWeight), contentAlignment = Alignment.Center) {
      Text(text = stats.banRate, fontSize = Dimensions.SmallFontSize, textAlign = TextAlign.Center)
    }
  }
}
