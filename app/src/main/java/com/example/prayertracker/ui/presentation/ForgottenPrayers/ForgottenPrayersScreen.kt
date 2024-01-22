package com.example.steamdbmockup.ui.presentation.DetailScreen


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.prayertracker.common.Constants
import com.example.prayertracker.common.Constants.elAishaa
import com.example.prayertracker.common.Constants.elAsr
import com.example.prayertracker.common.Constants.elDohr
import com.example.prayertracker.common.Constants.elFagr
import com.example.prayertracker.common.Constants.elMaghrab
import com.example.prayertracker.common.PrayerCard
import com.example.prayertracker.common.PrayerCountText
import com.example.prayertracker.common.TopBar


@Composable
fun ForgottenPrayersScreen(
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopBar()
        Row {
            PrayerCountText(text = elFagr, count = 0 )
        }
        Row {
            PrayerCountText(text = elDohr, count = 0 )
        }
        Row {
            PrayerCountText(text = elAsr, count = 0 )
        }
        Row {
            PrayerCountText(text = elMaghrab, count = 0 )
        }
        Row {
            PrayerCountText(text = elAishaa, count = 0 )
        }
    }
}


