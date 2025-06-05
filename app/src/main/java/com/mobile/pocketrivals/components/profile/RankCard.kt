package com.mobile.pocketrivals.components.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.data.RankHistory
import com.mobile.pocketrivals.ui.theme.Dimensions
import com.mobile.pocketrivals.ui.theme.LightBlue

@Composable
fun RankSection(rankHistory: List<RankHistory>) {
    Column {
        Text(
            text = stringResource(R.string.historial_de_rangos),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = Dimensions.TitleBottomPadding),
            color = MaterialTheme.colorScheme.primary
        )

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(Dimensions.MediumSpacer),
            contentPadding = PaddingValues(horizontal = Dimensions.SmallPadding)
        ) {
            items(rankHistory.sortedByDescending { it.season }) { rank ->
                RankCard(rank = rank)
            }
        }
    }
}

@Composable
fun RankCard(rank: RankHistory) {
    Card(
        modifier = Modifier.width(Dimensions.RankCardWidth),
        shape = RoundedCornerShape(Dimensions.ButtonCorner),
        colors = CardDefaults.cardColors(
            containerColor = LightBlue
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimensions.CardPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.temporada, rank.season),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.height(Dimensions.SmallSpacer))

            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = rank.rank,
                modifier = Modifier.size(Dimensions.RankIconSize),
                tint = MaterialTheme.colorScheme.secondary
            )

            Spacer(modifier = Modifier.height(Dimensions.SmallSpacer))

            Text(
                text = rank.rank,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondary
            )

            Text(
                text = "${rank.points} pts",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.secondary
            )
        }
    }
}


