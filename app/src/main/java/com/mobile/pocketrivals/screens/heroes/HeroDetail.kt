package com.mobile.pocketrivals.screens.heroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.ui.theme.Black10
import com.mobile.pocketrivals.ui.theme.White
import coil.compose.rememberAsyncImagePainter
import com.mobile.pocketrivals.components.herodetail.AbilityCard
import com.mobile.pocketrivals.components.herodetail.InfoRow
import com.mobile.pocketrivals.components.herodetail.Section

//TODO: should use HeroCard instead of new component
//TODO: make another viewmodel for this screen
//TODO: extract text
@Composable
fun HeroDetailScreen(heroId: String?) {
    val viewModel: HeroesViewModel = hiltViewModel()
    val heroes by viewModel.heroes.collectAsState()


    val hero = remember(heroId, heroes) {
        heroes.find { it.id == heroId }
    }

    val heroImage = hero?.imageUrl
    val baseUrl = "https://marvelrivalsapi.com"
    val fullImageUrl = "$baseUrl$heroImage"


    if (hero == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Hero not found", color = Color.Black)
        }
        return
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(White)
            .padding(16.dp)
    ) {
        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Hero Image
            Image(
                painter = rememberAsyncImagePainter(model = fullImageUrl),
                contentDescription = hero.name.toTitleCase(),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Hero Name and Role
            Column(
                modifier = Modifier
                    .height(120.dp)
                    .weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = hero.name.toTitleCase(),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Black10
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Role icon
                    Icon(
                        painter = painterResource(R.drawable.mock_hero_image),
                        contentDescription = hero.role,
                        tint = Black10,
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = hero.role,
                        fontSize = 16.sp,
                        color = Black10.copy(alpha = 0.8f)
                    )
                }
                Text(
                    text = "Real name: ${hero.realName}",
                    fontSize = 14.sp,
                    color = Black10.copy(alpha = 0.7f)
                )
            }
        }

         Spacer(modifier = Modifier.height(24.dp))

         // Basic Info Section
         Section(title = "Información Básica") {
             InfoRow("Tipo de ataque", hero.attackType)
             InfoRow("Dificultad", hero.difficulty)
             InfoRow("Equipo", hero.team.joinToString(", "))
         }

         Spacer(modifier = Modifier.height(16.dp))

         // Bio Section
         Section(title = "Biografía") {
             Text(
                 text = hero.bio,
                 fontSize = 14.sp,
                 color = Black10,
                 modifier = Modifier.padding(vertical = 8.dp)
             )
         }

         Spacer(modifier = Modifier.height(16.dp))

         // Abilities Section
         Section(title = "Habilidades") {
             for (ability in hero.abilities) {
                 AbilityCard(ability)
                 Spacer(modifier = Modifier.height(8.dp))
             }
         }


         Spacer(modifier = Modifier.height(16.dp))

                // Lore Section (if it exists and is different from bio)
        if (hero.lore.isNotEmpty() && hero.lore != hero.bio) {
            Section(title = "Historia") {
                Text(
                    text = hero.lore,
                    fontSize = 14.sp,
                    color = Black10,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }

        // Space at the bottom for better scrolling experience
        Spacer(modifier = Modifier.height(32.dp))
    }




}

fun String.toTitleCase(): String {
    return this.split(" ")
        .joinToString(" ") {
            it.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase() else it.toString()
            }
        }
}
