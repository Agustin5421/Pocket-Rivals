package com.mobile.pocketrivals.components.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.ui.theme.Dimensions

@Composable
fun GoogleLoginButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier.height(Dimensions.SearchBarHeight),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.White,
            contentColor = Color.Black
        ),
        shape = RoundedCornerShape(Dimensions.ButtonCorner),
        border = BorderStroke(Dimensions.ButtonBorder, Color.LightGray),
        contentPadding = PaddingValues(
            horizontal = Dimensions.GoogleButtonPadding,
            vertical = Dimensions.GoogleButtonPaddingVertical
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = Dimensions.CardElevation,
            pressedElevation = Dimensions.ButtonPressedElevation
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(Dimensions.GoogleButtonIcon),
                painter = painterResource(R.drawable.google_logo),
                contentDescription = "Google"
            )
            Spacer(modifier = Modifier.width(Dimensions.MediumSpacer))
            Text(
                text = stringResource(R.string.continuar_con_google),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
