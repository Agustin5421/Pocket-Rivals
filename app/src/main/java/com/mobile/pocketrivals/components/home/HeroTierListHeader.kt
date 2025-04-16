package com.mobile.pocketrivals.components.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeroTierListHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
        ,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Position
        Text(
            text = "#",
            modifier = Modifier.width(30.dp),
            fontSize = 14.sp
        )

        // Hero
        Text(
            text = "Hero",
            modifier = Modifier.width(30.dp + 8.dp),
            fontSize = 14.sp
        )

        // Role
        Text(
            text = "Role",
            modifier = Modifier.width(24.dp + 16.dp),
            fontSize = 14.sp
        )

        // Win
        Text(
            text = "Win",
            modifier = Modifier.width(60.dp),
            fontSize = 14.sp,
            textAlign = TextAlign.End
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Pick
        Text(
            text = "Pick",
            modifier = Modifier.width(60.dp),
            fontSize = 14.sp,
            textAlign = TextAlign.End
        )

        Spacer(modifier = Modifier.width(8.dp))

        // Ban
        Text(
            text = "Ban",
            modifier = Modifier.width(60.dp),
            fontSize = 14.sp,
            textAlign = TextAlign.End
        )
    }
}

@Preview
@Composable
fun PreviewChampionStatsHeader() {
    Column {
        HeroTierListHeader()
    }

}