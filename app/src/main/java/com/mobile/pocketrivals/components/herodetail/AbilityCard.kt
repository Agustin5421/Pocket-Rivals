package com.mobile.pocketrivals.components.herodetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.mocks.Ability
import com.mobile.pocketrivals.ui.theme.Black10
import com.mobile.pocketrivals.ui.theme.Gold
import com.mobile.pocketrivals.ui.theme.Grey10

@Composable
fun AbilityCard(ability: Ability) {
    val heroImage = ability.icon
    val baseUrl = "https://marvelrivalsapi.com"
    val fullImageUrl = "$baseUrl$heroImage"

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Grey10)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Ability Icon
            //TODO: replace with real image
            Image(
                painter = painterResource(id = R.drawable.mock_hero_image),
                contentDescription = ability.name,
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(4.dp))
            )

            Spacer(modifier = Modifier.width(12.dp))

            // Ability Details
            Column(modifier = Modifier.weight(1f)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    /*
                    Text(
                        text = ability.name,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Black10
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = ability.type,
                        fontSize = 12.sp,
                        color = Black10.copy(alpha = 0.6f)
                    )

                     */
                }
            }
        }
    }
}