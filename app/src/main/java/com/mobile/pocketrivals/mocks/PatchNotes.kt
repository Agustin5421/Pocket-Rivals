package com.mobile.pocketrivals.mocks
import com.mobile.pocketrivals.R

data class PatchNotes (
    val id: Int,
    val title: String,
    val content: String,
    val imageUrl: Int
)

val mockNews = PatchNotes(
    1,
    "This is a Patch Note!",
    "We killed Namor!",
    imageUrl = R.drawable.patch_notes
)