package com.mobile.pocketrivals.screens.profile

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import com.mobile.pocketrivals.components.profile.ProfileContent
import com.mobile.pocketrivals.components.profile.UidInputCard
import com.mobile.pocketrivals.components.profile.UserInfoCard
import com.mobile.pocketrivals.data.PlayerProfile
import com.mobile.pocketrivals.data.UserData
import java.util.*

@Composable
fun AuthenticatedProfileScreen(
    userData: UserData,
    profileData: PlayerProfile?,
    isLoadingProfile: Boolean,
    onSignOut: () -> Unit,
    onLoadProfile: (String) -> Unit
) {
    var uidInput by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            UserInfoCard(
                userData = userData,
                onSignOut = onSignOut
            )
        }

        item {
            UidInputCard(
                uidInput = uidInput,
                onUidChange = { uidInput = it },
                onLoadProfile = {
                    if (uidInput.isNotBlank()) {
                        onLoadProfile(uidInput)
                        keyboardController?.hide()
                    }
                },
                isLoading = isLoadingProfile
            )
        }

        if (profileData != null) {
            item {
                ProfileContent(profile = profileData)
            }
        } else if (isLoadingProfile) {
            item {
                LoadingProfileCard()
            }
        }
    }
}