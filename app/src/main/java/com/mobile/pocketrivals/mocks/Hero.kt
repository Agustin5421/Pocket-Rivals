package com.mobile.pocketrivals.mocks

data class Hero(
    val id: String,
    val name: String,
    val realName: String,
    val imageUrl: Int,
    val heroCard: String,
    val role: String,
    val attackType: String,
    val team: String,
    val difficulty: String,
    val bio: String,
    val lore: String,
    val loreCard: String,
    val transformations: List<String>,
    val costumes: List<String>,
    val abilities: List<String>
)

// Example mock data
val mockHero = Hero(
    id = "ironman-001",
    name = "Iron Man",
    realName = "Tony Stark",
    imageUrl = 2,
    heroCard = "/premium/banners/1016_banner.png?expires=1739246863&signature=d3d5ed098cc28ea881eb1c1f2e332ca00cff3c82b2de1af334a71d2a57802104",
    role = "DPS",
    attackType = "ranged",
    team = "Avengers",
    difficulty = "medium",
    bio = "A genius billionaire playboy philanthropist, Tony Stark is Iron Man.",
    lore = "After surviving a near-death experience, Tony Stark builds the first Iron Man suit.",
    loreCard = "/premium/lore/1016_lore_banner.png?expires=1739246863&signature=0ebdfc2ef7e280be743c0e49c785491b50d74726032956fe240915bfe47262be",
    transformations = listOf("Mark I", "Mark II", "Mark III"),
    costumes = listOf("Iron Patriot", "War Machine"),
    abilities = listOf("Repulsor Blast", "Flight", "Laser")
)