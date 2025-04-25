package com.mobile.pocketrivals.components.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.mobile.pocketrivals.R

@Composable
fun SettingsButton(navController: NavController) {
  IconButton(onClick = { navController.navigate("settings") }) {
    Icon(
      imageVector = Icons.Default.Settings,
      contentDescription = stringResource(R.string.configuration),
      tint = MaterialTheme.colorScheme.primary
    )
  }
}
