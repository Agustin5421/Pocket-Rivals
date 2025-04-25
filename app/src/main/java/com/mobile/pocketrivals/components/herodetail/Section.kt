package com.mobile.pocketrivals.components.herodetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mobile.pocketrivals.ui.theme.Dimensions

@Composable
fun Section(title: String, content: @Composable () -> Unit) {
  Column(modifier = Modifier.fillMaxWidth()) {
    Text(
      text = title,
      style = MaterialTheme.typography.titleMedium,
      color = MaterialTheme.colorScheme.tertiary,
      modifier = Modifier.padding(Dimensions.MediumPadding)
    )
    HorizontalDivider(
      color = MaterialTheme.colorScheme.onBackground,
      thickness = Dimensions.SmallDividerThickness,
      modifier = Modifier.padding(bottom = Dimensions.MediumPadding)
    )
    content()
  }
}
