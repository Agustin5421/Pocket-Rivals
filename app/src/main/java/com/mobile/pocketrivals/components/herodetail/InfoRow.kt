package com.mobile.pocketrivals.components.herodetail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.mobile.pocketrivals.ui.theme.Black10
import com.mobile.pocketrivals.ui.theme.Dimensions

@Composable
fun InfoRow(label: String, value: String) {
  Row(
    modifier = Modifier.fillMaxWidth().padding(vertical = Dimensions.SmallPadding),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      text = "$label:",
      fontSize = Dimensions.SmallFontSize,
      fontWeight = FontWeight.Bold,
      color = MaterialTheme.colorScheme.secondary,
      modifier = Modifier.width(Dimensions.InfoRowWidth)
    )
    Text(text = value, fontSize = Dimensions.SmallFontSize, color = Black10)
  }
}
