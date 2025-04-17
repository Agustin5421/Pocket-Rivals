package com.mobile.pocketrivals.apiManager

import android.content.Context
import android.widget.Toast
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.mocks.Hero
import retrofit.Call
import retrofit.Callback
import retrofit.GsonConverterFactory
import retrofit.Response
import retrofit.Retrofit
import javax.inject.Inject

class ApiServiceImpl @Inject constructor() {

    fun getHeroes(context: Context, onSuccess: (List<Hero>) -> Unit,
                  onFail: () -> Unit, loadingFinished: () -> Unit) {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(context.getString(R.string.rivals_api))
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service: ApiService = retrofit.create(ApiService::class.java)
        val call: Call<List<Hero>> = service.getHeroes(context.getString(R.string.api_key))


        call.enqueue(object : Callback<List<Hero>> {
            override fun onResponse(response: Response<List<Hero>>?, retrofit: Retrofit?) {
                loadingFinished()
                if(response?.isSuccess == true) {
                    val heroes: List<Hero> = response.body()
                    onSuccess(heroes)
                } else {
                    onFailure(Exception("Bad request"))
                }
            }


            override fun onFailure(t: Throwable?) {
                Toast.makeText(context, "Can't get heroes", Toast.LENGTH_SHORT).show()
                onFail()
                loadingFinished()
            }
        }
        )
    }
}
