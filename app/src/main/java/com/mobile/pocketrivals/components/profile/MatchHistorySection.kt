package com.mobile.pocketrivals.components.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.data.MatchHistory
import com.mobile.pocketrivals.ui.theme.LossRed
import com.mobile.pocketrivals.ui.theme.WinrateGreen
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

import com.mobile.pocketrivals.ui.theme.Dimensions

@Composable
fun MatchHistorySection(matchHistory: List<MatchHistory>) {
    Column {
        Text(
            text = stringResource(R.string.historial_de_partidas),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = Dimensions.TitleBottomPadding),
            color = MaterialTheme.colorScheme.secondary
        )

        matchHistory.take(5).forEach { match ->
            MatchCard(match = match)
            Spacer(modifier = Modifier.height(Dimensions.MediumSpacer))
        }
    }
}

@Composable
fun MatchCard(match: MatchHistory) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(Dimensions.MediumRoundedCorner),
        colors = CardDefaults.cardColors(
            containerColor = if (match.result == "win")
                WinrateGreen
            else
                LossRed
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(Dimensions.TitleBottomPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = if (match.result == "win") Icons.Default.CheckCircle else Icons.Default.Clear,
                contentDescription = match.result,
                tint = if (match.result == "win") WinrateGreen else LossRed,
                modifier = Modifier.size(Dimensions.GoogleButtonIcon)
            )

            Spacer(modifier = Modifier.width(Dimensions.MediumSpacer))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = if (match.result == "win") stringResource(R.string.victoria) else stringResource(
                        R.string.derrota
                    ),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Medium,
                    color = if (match.result == "win") WinrateGreen else LossRed
                )
                Text(
                    text = formatDate(match.date),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Row(
                horizontalArrangement = Arrangement.spacedBy(Dimensions.RowSpacer)
            ) {
                StatColumn(stringResource(R.string.k), match.kills.toString())
                StatColumn(stringResource(R.string.d), match.deaths.toString())
                StatColumn(stringResource(R.string.a), match.assists.toString())
            }
        }
    }
}


@Composable
fun StatColumn(label: String, value: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold
        )
    }
}

private fun formatDate(dateString: String): String {
    return try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
        val date = inputFormat.parse(dateString)
        outputFormat.format(date ?: Date())
    } catch (e: Exception) {
        dateString
    }
}