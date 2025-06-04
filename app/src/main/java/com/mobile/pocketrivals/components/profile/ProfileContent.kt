package com.mobile.pocketrivals.components.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.mobile.pocketrivals.data.PlayerProfile

@Composable
fun ProfileContent(profile: PlayerProfile) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ProfileHeader(player = profile.player)
        RankSection(rankHistory = profile.rankHistory)
        BestHeroSection(heroMatchups = profile.heroMatchups)
        MatchHistorySection(matchHistory = profile.matchHistory)
    }
}