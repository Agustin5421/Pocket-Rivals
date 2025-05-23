package com.mobile.pocketrivals.components.home.tierlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.ui.theme.Dimensions

@Composable
fun HeroTierList(modifier: Modifier = Modifier, heroStats: List<HeroStats>) {
  Surface(
    modifier = modifier.fillMaxWidth().background(MaterialTheme.colorScheme.onPrimary),
  ) {
    CompositionLocalProvider(LocalTextStyle provides TextStyle(color = Color.Black)) {
      Column {
        HeroTierListHeader()

        HorizontalDivider(
          color = MaterialTheme.colorScheme.surfaceVariant,
          thickness = Dimensions.SmallDividerThickness
        )
        // Hero List
        LazyColumn {
          items(heroStats) { heroStat ->
            HeroTierListItem(stats = heroStat)
            HorizontalDivider(
              color = MaterialTheme.colorScheme.surfaceVariant,
              thickness = Dimensions.SmallDividerThickness
            )
          }
        }
      }
    }
  }
}

@Preview(showBackground = true)
@Composable
fun PreviewHeroTierList() {
  val heroStats = remember {
    listOf(
      HeroStats(
        rank = 1,
        championName = "Knull",
        championIconResId = R.drawable.knull_mock,
        roleIconResId = R.drawable.dps_image,
        winRate = "54.31%",
        pickRate = "10.69%",
        banRate = "43.09%"
      ),
      HeroStats(
        rank = 1,
        championName = "Daredevil",
        championIconResId = R.drawable.daredevil_image_mock,
        roleIconResId = R.drawable.dps_image,
        winRate = "54.31%",
        pickRate = "10.69%",
        banRate = "43.09%"
      ),
      HeroStats(
        rank = 1,
        championName = "Adam Warlock",
        championIconResId = R.drawable.loki_image_mock,
        roleIconResId = R.drawable.vanguard_image,
        winRate = "54.31%",
        pickRate = "10.69%",
        banRate = "43.09%"
      )
    )
  }

  Surface(color = MaterialTheme.colorScheme.background) { HeroTierList(heroStats = heroStats) }
}
