package com.mobile.pocketrivals.components.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun SettingsButton() {
    IconButton(onClick = {
        //Do something
        }
    ) {
        Icon(
            imageVector = Icons.Default.Settings,
            contentDescription = "Configuration",
            tint = MaterialTheme.colorScheme.primary
        )
    }
}