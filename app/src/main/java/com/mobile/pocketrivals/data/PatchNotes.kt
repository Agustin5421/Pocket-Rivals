package com.mobile.pocketrivals.data

import com.google.gson.annotations.SerializedName

data class PatchNotesResponse(
  @SerializedName("total_balances") val totalBalances: Int,
  val balances: List<PatchNote>
)

data class PatchNote(
  val id: String,
  val title: String,
  val date: String,
  val overview: String,
  val fullContent: String,
  val imagePath: String
)
