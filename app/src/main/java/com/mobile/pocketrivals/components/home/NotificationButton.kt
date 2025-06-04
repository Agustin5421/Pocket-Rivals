package com.mobile.pocketrivals.components.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.notification.NotificationManager

@Composable
fun NotificationButton(navController: NavController) {
  val notificationManager = NotificationManager(navController.context)
  IconButton(onClick = {
    notificationManager.scheduleNotification()
  }) {
    Icon(
      imageVector = Icons.Default.Notifications,
      contentDescription = stringResource(R.string.configuration),
      tint = MaterialTheme.colorScheme.primary
    )
  }
}
