package com.mobile.pocketrivals.screens.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.components.profile.GoogleLoginButton
import com.mobile.pocketrivals.ui.theme.Dimensions

@Composable
fun LoginScreen(onGoogleLoginClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(Dimensions.ExtraLargeSpacer)
        ) {
            Spacer(modifier = Modifier.height(Dimensions.GoogleLoginTopSpacer))

            Text(
                text = "Marvel Rivals",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.tertiary
            )

            Spacer(modifier = Modifier.height(Dimensions.SmallSpacer))

            Text(
                text = stringResource(R.string.accede_a_tu_perfil_de_jugador),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(Dimensions.GoogleLoginBottomSpacer))

            GoogleLoginButton(
                onClick = onGoogleLoginClick,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
