package com.mobile.pocketrivals.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.pocketrivals.R

//TODO: on fetching the data from the API 
//TODO: I should create these entities and save them in the DB
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
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // List
        Text(
            text = stats.rank.toString(),
            modifier = Modifier.width(30.dp),
            fontSize = 14.sp
        )

        // Hero
        val size = 30.dp
        Box(
            modifier = Modifier
                .height(size)
                .width(size)
                .clip(RoundedCornerShape(8.dp))
        )
        {
            Image(
                painter = painterResource(id = stats.championIconResId),
                contentDescription = stats.championName,
                contentScale = ContentScale.Crop,
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Role
        Icon(
            painter = painterResource(id = stats.roleIconResId),
            contentDescription = "Rol",
            modifier = Modifier.size(24.dp),
            tint = Color.Gray
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Win Rate
        Text(
            text = stats.winRate,
            modifier = Modifier.width(60.dp),
            fontSize = 14.sp,
            textAlign = TextAlign.End
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Pick Rate
        Text(
            text = stats.pickRate,
            modifier = Modifier.width(60.dp),
            fontSize = 14.sp,
            textAlign = TextAlign.End
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Ban rate
        Text(
            text = stats.banRate,
            modifier = Modifier.width(60.dp),
            fontSize = 14.sp,
            textAlign = TextAlign.End
        )
    }
}

// Preview
@Preview(showBackground = true, backgroundColor = 0xFF222233)
@Composable
fun PreviewChampionStatsRow() {
    val sampleStats = HeroStats(
        rank = 1,
        championName = "Moon Knight",
        championIconResId = R.drawable.mock_hero_image,
        roleIconResId = R.drawable.dps_image,
        winRate = "54.31%",
        pickRate = "10.69%",
        banRate = "43.09%"
    )
    HeroTierListItem(stats = sampleStats)
}