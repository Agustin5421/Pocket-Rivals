package com.mobile.pocketrivals.screens.profile

import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mobile.pocketrivals.components.profile.ProfileContent
import com.mobile.pocketrivals.components.profile.UidInputCard
import com.mobile.pocketrivals.components.profile.UserInfoCard
import com.mobile.pocketrivals.ui.theme.Dimensions.ExtraLargePadding

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun ProfileScreen() {
  val viewModel = hiltViewModel<ProfileViewModel>()
  val userData = viewModel.userData.collectAsStateWithLifecycle()
  val context = LocalContext.current
  val activityContext = context as Activity
  val isAuthenticated by viewModel.isAuthenticated.collectAsStateWithLifecycle()

  val biometricManager = remember { BiometricManager.from(context) }
  val canAuthenticate = remember {
    biometricManager.canAuthenticate(BIOMETRIC_STRONG or DEVICE_CREDENTIAL)
  }


  // Trigger authentication only if biometric is available
  LaunchedEffect(canAuthenticate) {
    if (canAuthenticate == BiometricManager.BIOMETRIC_SUCCESS) {
      viewModel.authenticate(context)
    } else {
      // Assume success if biometrics are not available
      viewModel.skipAuthentication()
    }
  }

  when {
    isAuthenticated -> {
      if (userData.value == null) {
        LoginScreen(
          onGoogleLoginClick = { viewModel.launchCredentialManager(activityContext) }
        )
      } else {
        AuthenticatedProfileScreen(
          userData = userData.value!!,
          onSignOut = { viewModel.signOut() }
        )
      }
    }
    canAuthenticate == BiometricManager.BIOMETRIC_SUCCESS -> {
      BiometricAuthenticationScreen()
    }
    else -> {
      // Fallback: continue to login or show authenticated screen as appropriate
      if (userData.value == null) {
        LoginScreen(
          onGoogleLoginClick = { viewModel.launchCredentialManager(activityContext) }
        )
      } else {
        AuthenticatedProfileScreen(
          userData = userData.value!!,
          onSignOut = { viewModel.signOut() }
        )
      }
    }
  }
}


@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun AuthenticatedProfileScreen(
  userData: com.google.firebase.auth.FirebaseUser,
  onSignOut: () -> Unit
) {
  val viewModel = hiltViewModel<ProfileViewModel>()
  var uidInput by remember { mutableStateOf("") }

  val profileData by viewModel.playerProfile.collectAsStateWithLifecycle()
  val isLoadingProfile by viewModel.loading.collectAsStateWithLifecycle()

  LazyColumn(
    modifier = Modifier
      .fillMaxSize()
      .padding(ExtraLargePadding),
    verticalArrangement = Arrangement.spacedBy(ExtraLargePadding)
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
            viewModel.getProfile(uidInput)
          }
        },
        isLoading = isLoadingProfile
      )
    }

    if (profileData != null) {
      item {
        ProfileContent(profile = profileData!!)
      }
    }
  }
}
