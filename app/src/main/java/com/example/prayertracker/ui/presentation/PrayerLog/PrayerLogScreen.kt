package com.example.prayertracker.ui.presentation.PrayerLog


import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.prayertracker.common.ButtonPrayerText
import com.example.prayertracker.common.Constants.TAG
import com.example.prayertracker.common.Constants.btnAddText
import com.example.prayertracker.common.Constants.done
import com.example.prayertracker.common.Constants.Isha
import com.example.prayertracker.common.Constants.Asr
import com.example.prayertracker.common.Constants.Dhuhr
import com.example.prayertracker.common.Constants.Fajr
import com.example.prayertracker.common.Constants.Maghrib
import com.example.prayertracker.common.Constants.prayer
import com.example.prayertracker.common.TopBar


@Composable
fun PrayerLogScreen(
) {
    val radioOptions = listOf(
        "$done $prayer $Fajr",
        "$done $prayer $Dhuhr",
        "$done $prayer $Asr",
        "$done $prayer $Maghrib",
        "$done $prayer $Isha"
    )
    var selectedOption by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopBar()
        Column(
            modifier = Modifier.padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            radioOptions.forEach { prayerName ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = prayerName,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .padding(10.dp)
                            .wrapContentWidth(Alignment.End)
                            .weight(1f)
                    )
                    RadioButton(
                        selected = (prayerName == selectedOption),
                        onClick = {
                            selectedOption = prayerName
                        }
                    )
                }
            }
        }
        Row {
            ButtonPrayerText(text = btnAddText) {
                if(selectedOption == radioOptions[0]){
                    Log.d(TAG,radioOptions[0])
                } else if(selectedOption == radioOptions[1]) {
                    Log.d(TAG,radioOptions[1])
                } else if(selectedOption == radioOptions[2]) {
                    Log.d(TAG,radioOptions[2])
                } else if(selectedOption == radioOptions[3]) {
                    Log.d(TAG,radioOptions[3])
                } else {
                    Log.d(TAG,radioOptions[4])
                }
            }
        }
    }
}

