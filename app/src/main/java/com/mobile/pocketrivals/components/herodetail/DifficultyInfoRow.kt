package com.mobile.pocketrivals.components.herodetail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.ui.theme.Dimensions

@Composable
fun DifficultyInfoRow(difficultyString: String) {
  val difficulty =
    try {
      difficultyString.toInt().coerceIn(0, 5)
    } catch (_: NumberFormatException) {
      0
    }

  Row(
    modifier = Modifier.fillMaxWidth().padding(vertical = Dimensions.SmallPadding),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      text = stringResource(R.string.difficulty),
      fontSize = Dimensions.SmallFontSize,
      fontWeight = FontWeight.Bold,
      color = MaterialTheme.colorScheme.secondary,
      modifier = Modifier.width(Dimensions.InfoRowWidth)
    )

    Row(verticalAlignment = Alignment.CenterVertically) {
      repeat(difficulty) {
        Icon(
          imageVector = Icons.Filled.Star,
          contentDescription = null,
          tint = MaterialTheme.colorScheme.tertiary,
          modifier = Modifier.size(Dimensions.SmallIcon)
        )
      }

      repeat(5 - difficulty) {
        Icon(
          imageVector = Icons.Outlined.Star,
          contentDescription = null,
          tint = MaterialTheme.colorScheme.secondary,
          modifier = Modifier.size(Dimensions.SmallIcon)
        )
      }
    }
  }
}
