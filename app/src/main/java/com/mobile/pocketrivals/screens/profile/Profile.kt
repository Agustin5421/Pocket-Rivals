package com.mobile.pocketrivals.screens.profile

import android.app.Activity
import android.hardware.biometrics.BiometricManager.Authenticators.BIOMETRIC_STRONG
import android.hardware.biometrics.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import java.util.*

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun ProfileScreen() {
  val viewModel = hiltViewModel<ProfileViewModel>()
  val userData = viewModel.userData.collectAsStateWithLifecycle()
  val profileData = viewModel.profileData.collectAsStateWithLifecycle()
  val isLoadingProfile = viewModel.isLoadingProfile.collectAsStateWithLifecycle()

  val context = LocalContext.current
  val activityContext = context as Activity

  val isAuthenticated by viewModel.isAuthenticated.collectAsStateWithLifecycle()

  LaunchedEffect(Unit) {
    viewModel.authenticate(context)
  }

  val biometricManager = remember { BiometricManager.from(context) }

  val isBiometricAvailable = remember {
    biometricManager.canAuthenticate(BIOMETRIC_STRONG or DEVICE_CREDENTIAL)
  }

  when (isBiometricAvailable) {
    BiometricManager.BIOMETRIC_SUCCESS -> {
      if (isAuthenticated) {
        if (userData.value == null) {
          // Show Google Login
          LoginScreen(
            onGoogleLoginClick = { viewModel.launchCredentialManager(activityContext) }
          )
        } else {
          // Show Profile Screen with UID input
          AuthenticatedProfileScreen(
            userData = userData.value!!,
            profileData = profileData.value,
            isLoadingProfile = isLoadingProfile.value,
            onSignOut = { viewModel.signOut() },
            onLoadProfile = { uid -> viewModel.loadUserProfile(uid) }
          )
        }
      } else {
        BiometricAuthenticationScreen()
      }
    }

    BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
      ErrorScreen("Este dispositivo no tiene características biométricas disponibles")
    }

    BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
      ErrorScreen("La autenticación biométrica no está disponible actualmente")
    }

    BiometricManager.BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED -> {
      ErrorScreen("No puedes usar autenticación biométrica hasta actualizar los detalles de seguridad")
    }

    BiometricManager.BIOMETRIC_ERROR_UNSUPPORTED -> {
      ErrorScreen("No puedes usar autenticación biométrica con esta versión de Android")
    }

    BiometricManager.BIOMETRIC_STATUS_UNKNOWN -> {
      ErrorScreen("No se puede determinar si puedes usar autenticación biométrica")
    }

    BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
      ErrorScreen("No puedes usar autenticación biométrica porque no tienes credenciales registradas")
    }
  }
}
