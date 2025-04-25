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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.components.heroes.HeroCard
import com.mobile.pocketrivals.mocks.Hero
import com.mobile.pocketrivals.screens.heroes.toTitleCase
import com.mobile.pocketrivals.ui.theme.Black10

@Composable
fun MainCard(hero: Hero) {
  Row(
    modifier = Modifier.fillMaxWidth().height(120.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    // Hero Image
    Box(modifier = Modifier.size(120.dp).clip(RoundedCornerShape(8.dp))) {
      HeroCard(hero.imageUrl, onClick = {})
    }
    Spacer(modifier = Modifier.width(16.dp))

    // Hero Name and Role
    Column(
      modifier = Modifier.height(120.dp).weight(1f),
      verticalArrangement = Arrangement.Center
    ) {
      Text(
        text = hero.name.toTitleCase(),
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        color = Black10
      )
      Spacer(modifier = Modifier.height(4.dp))
      Row(verticalAlignment = Alignment.CenterVertically) {
        // Role icon
        val iconResource =
          when (hero.role.lowercase()) {
            "vanguard" -> R.drawable.vanguard_image
            "strategist" -> R.drawable.strategist_image
            "duelist" -> R.drawable.dps_image
            else -> R.drawable.mock_hero_image
          }

        Icon(
          painter = painterResource(iconResource),
          contentDescription = hero.role,
          tint = Black10,
          modifier = Modifier.size(20.dp)
        )

        Spacer(modifier = Modifier.width(4.dp))
        Text(text = hero.role, fontSize = 16.sp, color = Black10.copy(alpha = 0.8f))
      }
      Text(
        text = "Real name: ${hero.realName}",
        fontSize = 14.sp,
        color = Black10.copy(alpha = 0.7f)
      )
    }
  }
}
