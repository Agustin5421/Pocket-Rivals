package com.mobile.pocketrivals.components.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.mobile.pocketrivals.R

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HeroTierList(modifier: Modifier = Modifier) {
    CompositionLocalProvider(LocalTextStyle provides TextStyle(color = Color.Black)) {
        Column(modifier = modifier) {
            Box(modifier = Modifier
                .background(color = MaterialTheme.colorScheme.onPrimary)
                .padding(8.dp)
            ) {
                HeroTierListHeader()
            }

            Column (modifier = Modifier.background(color = MaterialTheme.colorScheme.onSecondary)){

                val sampleStats = HeroStats(
                    rank = 1,
                    championName = "Moon Knight",
                    championIconResId = R.drawable.mock_hero_image,
                    roleIconResId = R.drawable.dps_image,
                    winRate = "54.31%",
                    pickRate = "10.69%",
                    banRate = "43.09%"
                )
                HeroStatsRow(stats = sampleStats)

                val sampleStats2 = HeroStats(
                    rank = 1,
                    championName = "Adam Warlock",
                    championIconResId = R.drawable.mock_hero_image,
                    roleIconResId = R.drawable.dps_image,
                    winRate = "54.31%",
                    pickRate = "10.69%",
                    banRate = "43.09%"
                )
                HeroStatsRow(stats = sampleStats2)
            }
        }
    }

}