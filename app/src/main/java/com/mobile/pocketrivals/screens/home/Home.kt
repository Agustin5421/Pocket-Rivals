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
import com.mobile.pocketrivals.components.home.PatchNotesCard
import com.mobile.pocketrivals.components.home.TopBar

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


        PatchNotesCard(modifier = Modifier
            .padding(top = 8.dp)
            .padding(horizontal = 2.dp)

        )

        HeroTierList(modifier = Modifier
            .padding(top = 8.dp)
        )

    }


}
