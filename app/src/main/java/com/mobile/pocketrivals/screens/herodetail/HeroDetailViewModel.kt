package com.mobile.pocketrivals.screens.herodetail

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.pocketrivals.data.Hero
import com.mobile.pocketrivals.storage.PocketRivalsDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroDetailViewModel
@Inject
constructor(
  @ApplicationContext private val context: Context
) : ViewModel() {
  private val heroDao = PocketRivalsDatabase.getDatabase(context).heroDao()

  private var _hero = MutableStateFlow<Hero?>(null)
  val hero = _hero.asStateFlow()

  private var _loading = MutableStateFlow(true)
  val loading = _loading.asStateFlow()

  private var _showRetry = MutableStateFlow(false)
  val showRetry = _showRetry.asStateFlow()

  fun loadHeroById(heroId: String) {
    _loading.value = true
    viewModelScope.launch {
      try {
        val heroFromDb = heroDao.getHeroById(heroId)
        if (heroFromDb != null) {
          _hero.value = heroFromDb
          _showRetry.value = false
        } else {
          _showRetry.value = true
        }
      } catch (_: Exception) {
        _showRetry.value = true
      } finally {
        _loading.value = false
      }
    }
  }


  fun retryApiCall(heroId: String) {
    loadHeroById(heroId)
  }
}
