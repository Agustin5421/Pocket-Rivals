package com.mobile.pocketrivals.apiManager

import android.content.Context
import android.widget.Toast
import com.mobile.pocketrivals.R
import com.mobile.pocketrivals.data.Hero
import com.mobile.pocketrivals.data.PatchNotesResponse
import javax.inject.Inject
import retrofit.Call
import retrofit.Callback
import retrofit.GsonConverterFactory
import retrofit.Response
import retrofit.Retrofit

class ApiServiceImpl @Inject constructor() {

  fun getHeroes(
    context: Context,
    onSuccess: (List<Hero>) -> Unit,
    onFail: () -> Unit,
    loadingFinished: () -> Unit
  ) {
    val retrofit: Retrofit =
      Retrofit.Builder()
        .baseUrl(context.getString(R.string.rivals_api))
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: ApiService = retrofit.create(ApiService::class.java)
    val call: Call<List<Hero>> = service.getHeroes(context.getString(R.string.api_key))

    call.enqueue(
      object : Callback<List<Hero>> {
        override fun onResponse(response: Response<List<Hero>>?, retrofit: Retrofit?) {
          loadingFinished()
          if (response?.isSuccess == true) {
            val heroes: List<Hero> = response.body()
            onSuccess(heroes)
          } else {
            onFailure(Exception(context.getString(R.string.bad_request)))
          }
        }

        override fun onFailure(t: Throwable?) {
          Toast.makeText(context, context.getString(R.string.can_t_get_heroes), Toast.LENGTH_SHORT)
            .show()
          onFail()
          loadingFinished()
        }
      }
    )
  }

  fun getPatchNotes(
    context: Context,
    onSuccess: (PatchNotesResponse) -> Unit,
    onFail: () -> Unit,
    loadingFinished: () -> Unit
  ) {
    val retrofit: Retrofit =
      Retrofit.Builder()
        .baseUrl(context.getString(R.string.rivals_api))
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val service: ApiService = retrofit.create(ApiService::class.java)
    val call: Call<PatchNotesResponse> =
      service.getPatchNotes(context.getString(R.string.api_key), 1, 3)

    call.enqueue(
      object : Callback<PatchNotesResponse> {
        override fun onResponse(response: Response<PatchNotesResponse>?, retrofit: Retrofit?) {
          loadingFinished()
          if (response?.isSuccess == true) {
            val patchNotes: PatchNotesResponse = response.body()
            onSuccess(patchNotes)
          } else {
            onFailure(Exception(context.getString(R.string.bad_request)))
          }
        }

        override fun onFailure(t: Throwable?) {
          Toast.makeText(
              context,
              context.getString(R.string.can_t_get_patch_notes),
              Toast.LENGTH_SHORT
            )
            .show()
          onFail()
          loadingFinished()
        }
      }
    )
  }
}
