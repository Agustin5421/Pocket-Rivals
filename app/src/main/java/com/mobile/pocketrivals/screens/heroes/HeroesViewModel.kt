package com.mobile.pocketrivals.screens.heroes

import androidx.lifecycle.ViewModel
import com.mobile.pocketrivals.mocks.Hero
import com.mobile.pocketrivals.mocks.mockHeroes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HeroesViewModel @Inject constructor() : ViewModel(){
    //TODO: fetch from API
    private var _heroes = MutableStateFlow(mockHeroes.heroes)
    val heroes = _heroes.asStateFlow()

    fun getHeroById(heroId: String?) : Hero {
        for (hero in mockHeroes.heroes){
            if (hero.id == heroId){
                return hero
            }
        }
        return Hero(
            id = TODO(),
            name = TODO(),
            realName = TODO(),
            imageUrl = TODO(),
            heroCard = TODO(),
            role = TODO(),
            attackType = TODO(),
            team = TODO(),
            difficulty = TODO(),
            bio = TODO(),
            lore = TODO(),
            loreCard = TODO(),
            transformations = TODO(),
            costumes = TODO(),
            abilities = TODO()
        )
    }
}