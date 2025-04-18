package com.mobile.pocketrivals.components.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.unit.dp
import com.mobile.pocketrivals.R


@Composable
fun HeroTierList(modifier: Modifier = Modifier, heroStats: List<HeroStats>) {
    CompositionLocalProvider(LocalTextStyle provides TextStyle(color = Color.Black)) {
        Column(modifier = modifier) {
            Box(modifier = Modifier
                .background(color = MaterialTheme.colorScheme.onPrimary)
                .padding(8.dp)
            ) {
                HeroTierListHeader()
            }

            LazyColumn {
                items(heroStats) { heroStat ->
                    HeroTierListItem(stats = heroStat)
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
                championName = "Adam Warlock",
                championIconResId = R.drawable.mock_hero_image,
                roleIconResId = R.drawable.dps_image,
                winRate = "54.31%",
                pickRate = "10.69%",
                banRate = "43.09%"
            ),
            HeroStats(
                rank = 1,
                championName = "Adam Warlock",
                championIconResId = R.drawable.mock_hero_image,
                roleIconResId = R.drawable.dps_image,
                winRate = "54.31%",
                pickRate = "10.69%",
                banRate = "43.09%"
            ),
            HeroStats(
                rank = 1,
                championName = "Adam Warlock",
                championIconResId = R.drawable.mock_hero_image,
                roleIconResId = R.drawable.dps_image,
                winRate = "54.31%",
                pickRate = "10.69%",
                banRate = "43.09%"
            )

        )
    }

    Surface(color = MaterialTheme.colorScheme.background) {
        HeroTierList(heroStats = heroStats)
    }
}