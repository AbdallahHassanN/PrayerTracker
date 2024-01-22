package com.example.prayertracker.ui.presentation.MainScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.navapp.Screens
import com.example.prayertracker.R
import com.example.prayertracker.common.Constants.forgottenPrayersCardText
import com.example.prayertracker.common.Constants.latePrayerRecordCardText
import com.example.prayertracker.common.Constants.prayerLogCardText
import com.example.prayertracker.common.PrayerCard
import com.example.prayertracker.common.TopBar

@Composable
fun MainScreen(
    navController: NavController,
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        TopBar()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PrayerCard(text = latePrayerRecordCardText,
                imageResource = R.drawable.download,
                onClick = {
                    navController.navigate(Screens.LatePrayerRecord.route)
                })
            PrayerCard(text = forgottenPrayersCardText,
                imageResource = R.drawable.mosque,
                onClick = {
                    navController.navigate(Screens.ForgottenPrayers.route)
                })
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 100.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            PrayerCard(text = prayerLogCardText,
                imageResource = R.drawable.praying,
                onClick = {
                    navController.navigate(Screens.PrayerLog.route)
                })
        }
    }
}

