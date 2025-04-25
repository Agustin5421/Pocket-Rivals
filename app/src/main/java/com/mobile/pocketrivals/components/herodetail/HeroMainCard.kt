package com.mobile.pocketrivals.components.herodetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.components.heroes.HeroCard
import com.mobile.pocketrivals.data.Hero
import com.mobile.pocketrivals.screens.herodetail.toTitleCase
import com.mobile.pocketrivals.ui.theme.Dimensions

@Composable
fun HeroMainCard(hero: Hero) {
  Row(
    modifier = Modifier.fillMaxWidth().height(Dimensions.MediumCard),
    verticalAlignment = Alignment.CenterVertically
  ) {
    // Hero Image
    Box(
      modifier =
        Modifier.size(Dimensions.MediumImage)
          .clip(RoundedCornerShape(Dimensions.MediumRoundedCorner))
    ) {
      HeroCard(hero.imageUrl, onClick = {})
    }
    Spacer(modifier = Modifier.width(Dimensions.MediumSpacer))

    // Hero Name and Role
    Column(verticalArrangement = Arrangement.Center) {
      Text(
        text = hero.name.toTitleCase(),
        fontSize = Dimensions.LargeFontSize,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.secondary
      )
      Spacer(modifier = Modifier.height(Dimensions.MediumSpacer))

      Row(verticalAlignment = Alignment.CenterVertically) {
        // Role icon
        val iconResource =
          when (hero.role.lowercase()) {
            stringResource(R.string.vanguard) -> R.drawable.vanguard_image
            stringResource(R.string.strategist) -> R.drawable.strategist_image
            stringResource(R.string.duelist) -> R.drawable.dps_image
            else -> R.drawable.mock_hero_image
          }

        Icon(
          painter = painterResource(iconResource),
          contentDescription = hero.role,
          tint = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(Dimensions.SmallIcon)
        )

        Spacer(modifier = Modifier.width(Dimensions.MediumSpacer))
        Text(
          text = hero.role,
          fontSize = Dimensions.MediumFontSize,
          color = MaterialTheme.colorScheme.secondary
        )
      }
      Text(
        text = stringResource(R.string.real_name, hero.realName),
        fontSize = Dimensions.SmallFontSize,
        color = MaterialTheme.colorScheme.secondary
      )
    }
  }
}
