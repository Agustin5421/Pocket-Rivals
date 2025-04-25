package com.mobile.pocketrivals.screens.heroes


import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mobile.pocketrivals.apiManager.ApiServiceImpl
import com.mobile.pocketrivals.mocks.Hero
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HeroesViewModel @Inject constructor(
    @ApplicationContext private val context: Context,
    private val apiServiceImpl: ApiServiceImpl
) : ViewModel(){
    private var _heroes = MutableStateFlow(listOf<Hero>())
    val heroes = _heroes.asStateFlow()

    private var _loading = MutableStateFlow(true)
    val loading = _loading.asStateFlow()

    private var _showRetry = MutableStateFlow(false)
    val showRetry = _showRetry.asStateFlow()

    init {
        loadHeroes()
    }

    fun retryApiCall() {
        loadHeroes()
    }


    private fun loadHeroes() {
        _loading.value = true
        apiServiceImpl.getHeroes(
            context = context,
            onSuccess = {
                viewModelScope.launch {
                    _heroes.emit(it)
                }
                _showRetry.value = false
            },
            onFail = {
                _showRetry.value = true
            },
            loadingFinished = {
                _loading.value = false
            }
        )
    }


    fun getHeroById(heroId: String?) : Hero {
        for (hero in _heroes.value){
            if (hero.id == heroId){
                return hero
            }
        }
        throw IllegalArgumentException("Error")
    }

    fun getHeroes() : List<Hero> {
        return _heroes.value
    }
}