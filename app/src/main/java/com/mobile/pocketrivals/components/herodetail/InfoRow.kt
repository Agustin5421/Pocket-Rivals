package com.mobile.pocketrivals.components.herodetail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.pocketrivals.ui.theme.Black10

@Composable
fun InfoRow(label: String, value: String) {
  Row(
    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
    verticalAlignment = Alignment.CenterVertically
  ) {
    Text(
      text = "$label:",
      fontSize = 14.sp,
      fontWeight = FontWeight.Bold,
      color = Black10,
      modifier = Modifier.width(120.dp)
    )
    Text(text = value, fontSize = 14.sp, color = Black10)
  }
}
