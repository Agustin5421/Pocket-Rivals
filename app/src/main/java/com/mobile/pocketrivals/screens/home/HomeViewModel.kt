package com.mobile.pocketrivals.screens.home

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.apiManager.ApiServiceImpl
import com.mobile.pocketrivals.data.PatchNote
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class HomeViewModel
@Inject
constructor(
  @ApplicationContext private val context: Context,
  private val apiServiceImpl: ApiServiceImpl
) : ViewModel() {
  private var _patchNotes = MutableStateFlow(listOf<PatchNote>())
  val patchNotes = _patchNotes.asStateFlow()

  private var _loading = MutableStateFlow(true)
  val loading = _loading.asStateFlow()

  private var _showRetry = MutableStateFlow(false)
  val showRetry = _showRetry.asStateFlow()

  init {
    loadPatchNotes()
  }

  fun retryApiCall() {
    loadPatchNotes()
  }

  private fun loadPatchNotes() {
    _loading.value = true
    apiServiceImpl.getPatchNotes(
      context = context,
      onSuccess = {
        viewModelScope.launch { _patchNotes.emit(it.balances) }
        _showRetry.value = false
      },
      onFail = { _showRetry.value = true },
      loadingFinished = { _loading.value = false }
    )
  }

  fun getNews(): List<PatchNote> {
    return _patchNotes.value
  }

  fun getNewsById(id: String?): PatchNote {
    for (patchNote in _patchNotes.value) {
      if (patchNote.id == id) {
        return patchNote
      }
    }
    // TODO: Handle this case properly
    throw IllegalArgumentException(context.getString(R.string.error))
  }
}
