package com.mobile.pocketrivals.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.ui.theme.Dimensions.LargeIcon
import com.mobile.pocketrivals.ui.theme.Dimensions.MediumSpacer
import com.mobile.pocketrivals.ui.theme.Dimensions.SmallSpacer

@Composable
fun BiometricAuthenticationScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = Icons.Default.Face,
                contentDescription = stringResource(R.string.huella_dactilar),
                modifier = Modifier.size(LargeIcon),
                tint = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(MediumSpacer))
            Text(
                text = stringResource(R.string.autenticaci_n_requerida),
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(SmallSpacer))
            Text(
                text = stringResource(R.string.necesitas_autenticarte_para_continuar),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )
        }
    }
}