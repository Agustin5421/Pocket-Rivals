package com.mobile.pocketrivals.components.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.mobile.pocketrivals.data.PlayerProfile
import com.mobile.pocketrivals.ui.theme.Dimensions.ExtraLargePadding

@Composable
fun ProfileContent(profile: PlayerProfile) {
    Column(
        verticalArrangement = Arrangement.spacedBy(ExtraLargePadding)
    ) {
        ProfileHeader(player = profile.player)
        RankSection(rankHistory = profile.rankHistory)
        BestHeroSection(heroMatchups = profile.heroMatchups)
        MatchHistorySection(matchHistory = profile.matchHistory)
    }
}