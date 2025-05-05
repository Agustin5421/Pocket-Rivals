package com.mobile.pocketrivals.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update


@Dao
interface HeroesDao {
    @Insert
    suspend fun insert(heroes: Hero)

    @Update
    suspend fun update(hero: Hero)

    @Delete
    suspend fun delete(hero: Hero)

    @Query("SELECT * FROM heroes")
    fun getAllHeroes(): LiveData<List<Hero>>
}
