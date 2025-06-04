package com.mobile.pocketrivals.screens.profile

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.mobile.pocketrivals.R
import android.app.Activity
import android.hardware.biometrics.BiometricManager.Authenticators.BIOMETRIC_STRONG
import android.hardware.biometrics.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import androidx.biometric.BiometricManager
import androidx.compose.runtime.getValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember


@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@Composable
fun ProfileScreen() {
  val viewModel = hiltViewModel<ProfileViewModel>()
  val userData = viewModel.userData.collectAsStateWithLifecycle()

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
      // Biometric features are available
      if(isAuthenticated) {
        if (userData.value == null) {
          GoogleLoginButton(
            modifier = Modifier,
            // Pass the activityContext when calling the ViewModel function
            onClick = { viewModel.launchCredentialManager(activityContext) }
          )
        } else {
          Column {
            AsyncImage(
              model = userData.value?.photoUrl,
              contentDescription = "",
              modifier = Modifier.size(40.dp),
            )
            Text(
              userData.value?.displayName ?: ""
            )
            Text(
              userData.value?.email ?: ""
            )

            Button(onClick = { viewModel.signOut() }) {
              Text("Sign out")
            }
          }
        }
      } else {
        Text(text = "You need to authenticate")
      }
    }

    BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
      // No biometric features available on this device
      Text(text = "This phone is not prepared for biometric features")
    }

    BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
      // Biometric features are currently unavailable.
      Text(text = "Biometric auth is unavailable")
    }

    BiometricManager.BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED -> {
      // Biometric features available but a security vulnerability has been discovered
      Text(text = "You can't use biometric auth until you have updated your security details")
    }

    BiometricManager.BIOMETRIC_ERROR_UNSUPPORTED -> {
      // Biometric features are currently unavailable because the specified options are incompatible with the current Android version..
      Text(text = "You can't use biometric auth with this Android version")
    }

    BiometricManager.BIOMETRIC_STATUS_UNKNOWN -> {
      // Unable to determine whether the user can authenticate using biometrics
      Text(text = "You can't use biometric auth")
    }

    BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
      // The user can't authenticate because no biometric or device credential is enrolled.
      Text(text = "You can't use biometric auth")
    }
  }
}

@Composable
private fun GoogleLoginButton(
  onClick: () -> Unit,
  modifier: Modifier
) {
  GoogleButtonUI(
    modifier = modifier,
    onClick = onClick,
  )
}

@Composable
private fun GoogleButtonUI(
  onClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Button(
    modifier = modifier,
    onClick = onClick,
    colors = ButtonDefaults.buttonColors(
      containerColor = Color.White,
      contentColor = Color.Black
    ),
    shape = RoundedCornerShape(12.dp),
    border = BorderStroke(1.dp, Color.LightGray),
    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp)
  ) {
    Image(
      modifier = Modifier.size(24.dp),
      painter = painterResource(R.drawable.knull_mock),
      contentDescription = null
    )
    Spacer(modifier = Modifier.width(8.dp))
    Text("Continue with Google")
  }
}
