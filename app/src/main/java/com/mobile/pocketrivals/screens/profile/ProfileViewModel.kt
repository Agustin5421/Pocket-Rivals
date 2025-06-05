package com.mobile.pocketrivals.screens.profile

import android.content.Context
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.credentials.Credential
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import androidx.credentials.exceptions.ClearCredentialException
import androidx.credentials.exceptions.GetCredentialException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential.Companion.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.apiManager.ApiServiceImpl
import com.mobile.pocketrivals.data.PlayerProfile
import com.mobile.pocketrivals.security.BiometricAuthManager
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


const val TAG = "UserViewModel"

@RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val biometricAuthManager: BiometricAuthManager,
    private val apiServiceImpl: ApiServiceImpl,
    @ApplicationContext private val context: Context,
): ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _userData = MutableStateFlow(auth.currentUser)
    val userData = _userData.asStateFlow()

    private var _isAuthenticated = MutableStateFlow(false)
    val isAuthenticated = _isAuthenticated.asStateFlow()

    private val _playerProfile = MutableStateFlow<PlayerProfile?>(null)
    val playerProfile = _playerProfile.asStateFlow()

    private val _loading = MutableStateFlow(false)
    val loading = _loading.asStateFlow()

    private val _showRetry = MutableStateFlow(false)

    // Accept the Activity context here
    fun launchCredentialManager(activityContext: Context) {
        val credentialManager = CredentialManager.create(activityContext)


        // Instantiate a Google sign-in request
        val googleIdOption = GetGoogleIdOption.Builder()
            // Your server's client ID, not your Android client ID.
            .setServerClientId(activityContext.getString(R.string.google_web_client_id)) // Use the passed context here too
            // Only show accounts previously used to sign in.
            .setFilterByAuthorizedAccounts(false)
            .build()

        // Create the Credential Manager request
        val request = GetCredentialRequest.Builder()
            .addCredentialOption(googleIdOption)
            .build()

        viewModelScope.launch {
            try {
                // Launch Credential Manager UI - Pass the activityContext here
                val result = credentialManager.getCredential(
                    context = activityContext, // Use the context parameter passed to the function
                    request = request
                )

                // Extract credential from the result returned by Credential Manager
                handleSignIn(result.credential)
            } catch (e: GetCredentialException) {
                Log.e(TAG, "Couldn't retrieve user's credentials: ${e.localizedMessage}")
            }
        }
    }

    private fun handleSignIn(credential: Credential) {
        // Check if credential is of type Google ID
        if (credential is CustomCredential && credential.type == TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
            // Create Google ID Token
            val googleIdTokenCredential = GoogleIdTokenCredential.createFrom(credential.data)

            // Sign in to Firebase with using the token
            firebaseAuthWithGoogle(googleIdTokenCredential.idToken)
        } else {
            Log.w(TAG, "Credential is not of type Google ID!")
        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign in success
                    Log.d(TAG, "signInWithCredential:success")
                    val user = auth.currentUser
                    viewModelScope.launch {
                        _userData.emit(user)
                    }
                } else {
                    // Sign in fails
                    viewModelScope.launch {
                        _userData.emit(null)
                    }
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                }
            }
    }

    fun signOut() {
        auth.signOut()

        // When a user signs out, clear the current user credential state from all credential providers.
        viewModelScope.launch {
            try {
                viewModelScope.launch {
                    _userData.emit(null)
                }
            } catch (e: ClearCredentialException) {
                Log.e(TAG, "Couldn't clear user credentials: ${e.localizedMessage}")
            }
        }
    }

    fun authenticate(context: Context) {
        biometricAuthManager.authenticate(
            context,
            onError = {
                _isAuthenticated.value = false
                Toast.makeText(context, "There was an error in the authentication", Toast.LENGTH_SHORT).show()
            },
            onSuccess = {
                _isAuthenticated.value = true
            },
            onFail = {
                _isAuthenticated.value = false
                Toast.makeText(context, "The authentication failed, try again", Toast.LENGTH_SHORT).show()
            }
        )
    }

    fun skipAuthentication() {
        _isAuthenticated.value = true
    }


    fun getProfile(username: String) {
        _loading.value = true


        apiServiceImpl.getPlayerProfile(
            username = username,
            context = context,
            onSuccess = { playerProfile ->
                viewModelScope.launch {
                    _playerProfile.emit(playerProfile)
                    _showRetry.value = false
                }
            },
            onFail = {
                _showRetry.value = true
            },
            loadingFinished = {
                _loading.value = false
            }
        )
    }
}
