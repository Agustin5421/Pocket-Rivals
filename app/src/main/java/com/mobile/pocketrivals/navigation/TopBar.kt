package com.mobile.pocketrivals.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.mobile.pocketrivals.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController) {
  TopAppBar(
    title = {
      Text(
        text = stringResource(R.string.pocket_rivals),
        color = MaterialTheme.colorScheme.tertiary
      )
    },
    actions = {
      // SettingsButton(navController)
    },
    modifier = Modifier.fillMaxWidth(),
    colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.secondary)
  )
}
