package com.mobile.pocketrivals.screens.heroes

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.pocketrivals.apiManager.ApiServiceImpl
import com.mobile.pocketrivals.data.Hero
import com.mobile.pocketrivals.storage.PocketRivalsDatabase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroesViewModel
@Inject
constructor(
  @ApplicationContext private val context: Context,
  private val apiServiceImpl: ApiServiceImpl
) : ViewModel() {
  private var _heroes = MutableStateFlow(listOf<Hero>())
  val heroes = _heroes.asStateFlow()

  private var _loading = MutableStateFlow(true)
  val loading = _loading.asStateFlow()

  private var _showRetry = MutableStateFlow(false)
  val showRetry = _showRetry.asStateFlow()

  private val heroDao = PocketRivalsDatabase.getDatabase(context).heroDao()

  init {
    loadHeroes()
  }

  fun retryApiCall() {
    loadHeroes()
  }

  private fun loadHeroes() {
    _loading.value = true
    viewModelScope.launch {
      try {
        // Try to get heroes from the database first
        val cachedHeroes = heroDao.getAllHeroes()
        cachedHeroes.observeForever { heroesFromDb ->
          if (heroesFromDb.isNotEmpty()) {
            _heroes.value = heroesFromDb
            _loading.value = false
            _showRetry.value = false
          } else {
            // If the database is empty, fetch from the API
            fetchHeroesFromApi()
          }
        }
      } catch (_: Exception) {
        // Handle database errors
        _showRetry.value = true
        _loading.value = false
      }
    }
  }

  private fun fetchHeroesFromApi() {
    apiServiceImpl.getHeroes(
      context = context,
      onSuccess = { heroes ->
        viewModelScope.launch {
          // Insert heroes into the database
          heroes.forEach { hero -> heroDao.insert(hero) }
          _heroes.emit(heroes)
          _showRetry.value = false
        }
      },
      onFail = { _showRetry.value = true },
      loadingFinished = { _loading.value = false }
    )
  }

  fun getHeroes(): List<Hero> {
    return _heroes.value
  }
}
