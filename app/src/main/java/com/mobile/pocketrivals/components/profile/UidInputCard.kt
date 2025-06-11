package com.mobile.pocketrivals.components.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.ui.theme.Dimensions
import com.mobile.pocketrivals.ui.theme.LightBlue

@Composable
fun UidInputCard(
    uidInput: String,
    onUidChange: (String) -> Unit,
    onLoadProfile: () -> Unit,
    isLoading: Boolean
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(Dimensions.ButtonCorner),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimensions.UidInputCardPadding)
        ) {
            Text(
                text = stringResource(R.string.buscar_perfil),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = Dimensions.TitleBottomPadding),
                color = MaterialTheme.colorScheme.primary
            )

            OutlinedTextField(
                value = uidInput,
                onValueChange = onUidChange,
                label = { Text(stringResource(R.string.uid_del_jugador), color = MaterialTheme.colorScheme.primary) },
                placeholder = { Text(stringResource(R.string.ingresa_el_uid_del_perfil), color = MaterialTheme.colorScheme.primary.copy(alpha = 0.7f)) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(Dimensions.MediumRoundedCorner),
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = { onLoadProfile() }),
                textStyle = LocalTextStyle.current.copy(color = MaterialTheme.colorScheme.primary),
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedBorderColor = MaterialTheme.colorScheme.primary,
                    focusedBorderColor = MaterialTheme.colorScheme.primary,
                    cursorColor = MaterialTheme.colorScheme.primary
                ),
                trailingIcon = {
                    IconButton(
                        onClick = onLoadProfile,
                        enabled = uidInput.isNotBlank() && !isLoading
                    ) {
                        if (isLoading) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(Dimensions.UidInputLoader),
                                strokeWidth = Dimensions.MediumDividerThickness,
                                color = MaterialTheme.colorScheme.primary
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = stringResource(R.string.buscar),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            )

            Spacer(modifier = Modifier.height(Dimensions.TitleBottomPadding))

            Button(
                onClick = onLoadProfile,
                modifier = Modifier.fillMaxWidth(),
                enabled = uidInput.isNotBlank() && !isLoading,
                shape = RoundedCornerShape(Dimensions.MediumRoundedCorner),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    contentColor = MaterialTheme.colorScheme.secondary,
                    disabledContainerColor = MaterialTheme.colorScheme.tertiary,
                    disabledContentColor = MaterialTheme.colorScheme.secondary
                )
            ) {
                if (isLoading) {
                    CircularProgressIndicator(
                        modifier = Modifier.size(Dimensions.UidInputLoader),
                        strokeWidth = Dimensions.MediumDividerThickness,
                    )
                    Spacer(modifier = Modifier.width(Dimensions.SmallSpacer))
                    Text(stringResource(R.string.cargando))
                } else {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier.size(Dimensions.UidInputLoader)
                    )
                    Spacer(modifier = Modifier.width(Dimensions.SmallSpacer))
                    Text(stringResource(R.string.buscar_perfil))
                }
            }

        }
    }

}
