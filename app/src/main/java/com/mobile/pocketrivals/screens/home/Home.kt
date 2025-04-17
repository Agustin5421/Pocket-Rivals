package com.mobile.pocketrivals.screens.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mobile.pocketrivals.components.home.HeroTierList
import com.mobile.pocketrivals.components.home.PatchNotesCarousel
import com.mobile.pocketrivals.components.home.TopBar
import com.mobile.pocketrivals.mocks.heroStats
import com.mobile.pocketrivals.mocks.mockNews

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TopBar(navController = navController)



        val news = mockNews
        PatchNotesCarousel(newsList = listOf(news, news, news), navController = navController)

        /*
        PatchNotesCard(modifier = Modifier
            .padding(top = 8.dp)
            .padding(horizontal = 2.dp),
            patchNotes = news,
            navController = navController
        )
         */

        val heroStats = heroStats
        //TODO: fetch from DB Hero Stats
        HeroTierList(modifier = Modifier
            .padding(top = 8.dp), heroStats
        )

    }


}
