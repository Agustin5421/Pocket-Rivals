package com.mobile.pocketrivals.screens.home

import androidx.lifecycle.ViewModel
import com.mobile.pocketrivals.mocks.PatchNotes
import com.mobile.pocketrivals.mocks.mockNews
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {

    fun getNews() : List<PatchNotes> {
        return listOf(mockNews)
    }

    fun getNewsById(id: Int): PatchNotes {
        return PatchNotes(1, "This is a Patch Note!", "We killed Namor!", 1)
    }
}