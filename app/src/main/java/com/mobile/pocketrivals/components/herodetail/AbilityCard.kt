package com.mobile.pocketrivals.components.herodetail

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.data.Ability
import com.mobile.pocketrivals.ui.theme.Dimensions

@Composable
fun AbilityCard(ability: Ability) {
  if (ability.name == null) return

  val heroImage = ability.icon
  val baseUrl = stringResource(R.string.https_marvelrivalsapi_com_rivals)
  val fullImageUrl = "$baseUrl$heroImage"
  var isExpanded by remember { mutableStateOf(false) }

  Card(
    modifier = Modifier.fillMaxWidth().clickable { isExpanded = !isExpanded },
    shape = RoundedCornerShape(Dimensions.MediumRoundedCorner),
    elevation = CardDefaults.cardElevation(Dimensions.CardElevation),
    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)
  ) {
    Column(modifier = Modifier.fillMaxWidth().animateContentSize()) {
      Row(
        modifier = Modifier.fillMaxWidth().padding(Dimensions.LargePadding),
        verticalAlignment = Alignment.CenterVertically
      ) {
        // Ability Icon
        Image(
          painter = rememberAsyncImagePainter(model = fullImageUrl),
          contentDescription = ability.name,
          modifier =
            Modifier.size(Dimensions.MediumIcon)
              .clip(RoundedCornerShape(Dimensions.SmallRoundedCorner))
        )

        Spacer(modifier = Modifier.width(Dimensions.MediumSpacer))

        // Ability Details
        Column(modifier = Modifier.weight(Dimensions.MediumWeight)) {
          Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
              text = ability.name.toString(),
              fontSize = Dimensions.MediumFontSize,
              fontWeight = FontWeight.Bold,
              color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.width(Dimensions.SmallSpacer))
          }
        }
      }

      AnimatedVisibility(visible = isExpanded) {
        Column(
          modifier =
            Modifier.fillMaxWidth()
              .padding(
                start = Dimensions.LargePadding,
                end = Dimensions.LargePadding,
                bottom = Dimensions.LargePadding
              )
        ) {
          HorizontalDivider(
            modifier = Modifier.padding(vertical = Dimensions.MediumPadding),
            thickness = Dimensions.MediumDividerThickness,
            color = MaterialTheme.colorScheme.primary
          )

          Text(
            text = ability.description ?: stringResource(R.string.no_description_available),
            fontSize = Dimensions.SmallFontSize,
            color = MaterialTheme.colorScheme.onSecondary
          )
        }
      }
    }
  }
}
