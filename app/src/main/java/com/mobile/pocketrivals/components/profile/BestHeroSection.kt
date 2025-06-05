package com.mobile.pocketrivals.components.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.data.HeroMatchup
import com.mobile.pocketrivals.ui.theme.Dimensions
import com.mobile.pocketrivals.ui.theme.WinrateGreen

@Composable
fun BestHeroSection(heroMatchups: List<HeroMatchup>) {
    val bestHero = heroMatchups.maxByOrNull { it.winRate }

    if (bestHero != null) {
        Column {
            Text(
                text = stringResource(R.string.mejor_h_roe),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = Dimensions.TitleBottomPadding)
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(Dimensions.MediumRoundedCorner)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(Dimensions.CardPadding),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(bestHero.heroImageUrl)
                            .crossfade(true)
                            .build(),
                        contentDescription = bestHero.heroName,
                        modifier = Modifier
                            .size(Dimensions.SmallImage)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(Dimensions.RowSpacer))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = bestHero.heroName,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = stringResource(R.string.tasa_de_victoria, bestHero.winRate),
                            style = MaterialTheme.typography.bodyMedium,
                            color = WinrateGreen
                        )
                    }

                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = stringResource(R.string.mejor_h_roe),
                        tint = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.size(Dimensions.SmallIcon)
                    )
                }
            }
        }
    }
}
