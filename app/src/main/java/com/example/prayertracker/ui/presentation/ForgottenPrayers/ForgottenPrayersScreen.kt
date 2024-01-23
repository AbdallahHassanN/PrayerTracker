package com.example.steamdbmockup.ui.presentation.DetailScreen


import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.prayertracker.common.Constants.Isha
import com.example.prayertracker.common.Constants.Asr
import com.example.prayertracker.common.Constants.Dhuhr
import com.example.prayertracker.common.Constants.Fajr
import com.example.prayertracker.common.Constants.Maghrib
import com.example.prayertracker.common.Constants.TAG
import com.example.prayertracker.common.PrayerCountText
import com.example.prayertracker.common.TopBar


@Composable
fun ForgottenPrayersScreen(
    viewModel: ForgottenPrayersViewModel = hiltViewModel(),
    ) {

    val fajrCount = viewModel.fajr.value
    val dhuhrCount = viewModel.dhuhr.value
    val asrCount = viewModel.asr.value
    val maghribCount = viewModel.maghrib.value
    val ishaCount = viewModel.isha.value

    Log.d(TAG,"HH $fajrCount")
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopBar()
        Row {
            PrayerCountText(
                text = Fajr,
                count = fajrCount.toString()
            )
        }
        Row {
            PrayerCountText(text = Dhuhr,
                count = dhuhrCount.toString()
            )
        }
        Row {
            PrayerCountText(
                text = Asr,
                count = asrCount.toString()
            )
        }
        Row {
            PrayerCountText(text = Maghrib,
                count = maghribCount.toString()
            )
        }
        Row {
            PrayerCountText(text = Isha,
                count = ishaCount.toString()
            )
        }
    }
}


