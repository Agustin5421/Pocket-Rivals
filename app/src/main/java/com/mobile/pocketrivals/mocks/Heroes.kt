package com.mobile.pocketrivals.mocks

import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.components.home.HeroStats

data class Heroes(
    val heroes: List<Hero>
)
val heroImage = R.drawable.mock_hero_image

val heroStats =
    listOf(
        HeroStats(
            rank = 1,
            championName = "Adam Warlock",
            championIconResId = R.drawable.mock_hero_image,
            roleIconResId = R.drawable.dps_image,
            winRate = "54.31%",
            pickRate = "10.69%",
            banRate = "43.09%"
        ),
        HeroStats(
            rank = 1,
            championName = "Adam Warlock",
            championIconResId = R.drawable.mock_hero_image,
            roleIconResId = R.drawable.dps_image,
            winRate = "54.31%",
            pickRate = "10.69%",
            banRate = "43.09%"
        ),
        HeroStats(
            rank = 1,
            championName = "Adam Warlock",
            championIconResId = R.drawable.mock_hero_image,
            roleIconResId = R.drawable.dps_image,
            winRate = "54.31%",
            pickRate = "10.69%",
            banRate = "43.09%"
        )

    )


val mockHeroes = Heroes(
    heroes = listOf(
        Hero(
            id = "ironman-001",
            name = "Iron Man",
            realName = "Tony Stark",
            imageUrl = R.drawable.mock_hero_image,
            heroCard = "/premium/banners/1016_banner.png",
            role = "DPS",
            attackType = "ranged",
            team = "Avengers",
            difficulty = "medium",
            bio = "A genius billionaire playboy philanthropist, Tony Stark is Iron Man.",
            lore = "After surviving a near-death experience, Tony Stark builds the first Iron Man suit.",
            loreCard = "/premium/lore/1016_lore_banner.png",
            transformations = listOf("Mark I", "Mark II", "Mark III"),
            costumes = listOf("Iron Patriot", "War Machine"),
            abilities = listOf("Repulsor Blast", "Flight", "Laser")
        ),
        Hero(
            id = "captainamerica-001",
            name = "Captain America",
            realName = "Steve Rogers",
            imageUrl = heroImage,
            heroCard = "/premium/banners/1017_banner.png",
            role = "Tank",
            attackType = "melee",
            team = "Avengers",
            difficulty = "hard",
            bio = "A super soldier with an indestructible shield, Steve Rogers fights for justice.",
            lore = "Given the Super Soldier Serum, Steve Rogers became Captain America.",
            loreCard = "/premium/lore/1017_lore_banner.png",
            transformations = listOf("Classic Suit", "Stealth Suit", "Endgame Suit"),
            costumes = listOf("Winter Soldier Outfit", "Commander Rogers"),
            abilities = listOf("Shield Throw", "Super Strength", "Leadership")
        ),
        Hero(
            id = "thor-001",
            name = "Thor",
            realName = "Thor Odinson",
            imageUrl = heroImage,
            heroCard = "/premium/banners/1018_banner.png",
            role = "Bruiser",
            attackType = "melee",
            team = "Avengers",
            difficulty = "medium",
            bio = "The God of Thunder wields Mjolnir to protect Asgard and Earth.",
            lore = "As the son of Odin, Thor fights to prove himself worthy of the throne.",
            loreCard = "/premium/lore/1018_lore_banner.png",
            transformations = listOf("Classic Thor", "Ragnarok Thor", "Stormbreaker"),
            costumes = listOf("Gladiator Thor", "King Thor"),
            abilities = listOf("Mjolnir Throw", "Lightning Strike", "Thunderclap")
        ),
        Hero(
            id = "hulk-001",
            name = "Hulk",
            realName = "Bruce Banner",
            imageUrl = heroImage,
            heroCard = "/premium/banners/1019_banner.png",
            role = "Tank",
            attackType = "melee",
            team = "Avengers",
            difficulty = "hard",
            bio = "After a gamma radiation accident, Bruce Banner transforms into the Hulk.",
            lore = "The angrier he gets, the stronger he becomes.",
            loreCard = "/premium/lore/1019_lore_banner.png",
            transformations = listOf("Savage Hulk", "Professor Hulk", "World Breaker"),
            costumes = listOf("Gladiator Hulk", "Joe Fixit"),
            abilities = listOf("Smash", "Thunderclap", "Regeneration")
        ),
        Hero(
            id = "blackwidow-001",
            name = "Black Widow",
            realName = "Natasha Romanoff",
            imageUrl = heroImage,
            heroCard = "/premium/banners/1020_banner.png",
            role = "Assassin",
            attackType = "ranged",
            team = "Avengers",
            difficulty = "medium",
            bio = "A highly trained spy and assassin, Natasha Romanoff fights with precision.",
            lore = "Raised in the Red Room, she turned against her past to become a hero.",
            loreCard = "/premium/lore/1020_lore_banner.png",
            transformations = listOf("Classic Widow", "Endgame Widow"),
            costumes = listOf("Stealth Suit", "White Widow"),
            abilities = listOf("Widow’s Bite", "Acrobatics", "Espionage")
        )
    )
)