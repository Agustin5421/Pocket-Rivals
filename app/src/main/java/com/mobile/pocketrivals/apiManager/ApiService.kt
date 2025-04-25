package com.mobile.pocketrivals.apiManager

import com.mobile.pocketrivals.mocks.Hero
import retrofit.Call
import retrofit.http.GET
import retrofit.http.Header

interface ApiService {
  @GET("heroes") fun getHeroes(@Header("x-api-key") apiKey: String): Call<List<Hero>>
}
