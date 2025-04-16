package com.mobile.pocketrivals.mocks
import com.mobile.pocketrivals.R

data class PatchNote (
    val id: Int,
    val title: String,
    val content: String,
    val imageUrl: Int
)

val mockNews = PatchNote(
    1,
    "This is a Patch Note!",
    "We killed Namor!",
    imageUrl = R.drawable.patch_notes
)