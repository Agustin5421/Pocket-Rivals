package com.mobile.pocketrivals.apiManager

import com.mobile.pocketrivals.data.Hero
import com.mobile.pocketrivals.data.PatchNotesResponse
import com.mobile.pocketrivals.data.PlayerProfile
import retrofit.Call
import retrofit.http.GET
import retrofit.http.Header
import retrofit.http.Path
import retrofit.http.Query

interface ApiService {
  @GET("heroes") fun getHeroes(@Header("x-api-key") apiKey: String): Call<List<Hero>>

  @GET("balances")
  fun getPatchNotes(
    @Header("x-api-key") apiKey: String,
    @Query("page") page: Int,
    @Query("limit") limit: Int
  ): Call<PatchNotesResponse>

  @GET("player/{username}")
  fun getPlayerStats(
    @Header("x-api-key") apiKey: String,
    @Path("username") username: String
  ): Call<PlayerProfile>

}
