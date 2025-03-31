package com.mobile.pocketrivals.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.mobile.pocketrivals.mocks.Hero
import com.mobile.pocketrivals.mocks.mockHeroes

@Composable
fun HeroDetailScreen(heroId: String?) {
    val hero = getHeroById(heroId)
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Hero's name is: " + hero.name, color = Color.Black)
    }
}

fun getHeroById(heroId: String?) : Hero{
    for (hero in mockHeroes.heroes){
        if (hero.id == heroId){
            return hero
        }
    }
    return Hero(
        "1", "mock",
        realName = TODO(),
        imageUrl = TODO(),
        heroCard = TODO(),
        role = TODO(),
        attackType = TODO(),
        team = TODO(),
        difficulty = TODO(),
        bio = TODO(),
        lore = TODO(),
        loreCard = TODO(),
        transformations = TODO(),
        costumes = TODO(),
        abilities = TODO(),
    )
}
