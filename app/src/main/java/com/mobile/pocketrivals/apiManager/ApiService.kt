package com.mobile.pocketrivals.apiManager

import retrofit.Call
import com.mobile.pocketrivals.mocks.Hero
import retrofit.http.GET
import retrofit.http.Query


interface ApiService {
    @GET("heroes")
    fun getHeroes(@Query("api_key") apiKey: String): Call<List<Hero>>
}