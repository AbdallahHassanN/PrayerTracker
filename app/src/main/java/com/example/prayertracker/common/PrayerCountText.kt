package com.example.prayertracker.common

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.prayertracker.common.Constants.elFagr
import com.example.prayertracker.common.Constants.prayersCount

@Composable
fun PrayerCountText(
    text: String,
    count: Int
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "$count",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .wrapContentWidth(Alignment.Start)
                .padding(10.dp)
                .weight(1f)
        )
        Text(
            text = "$prayersCount $text",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .padding(10.dp)
        )

    }
}

@Preview
@Composable
fun Display() {
    PrayerCountText(text = elFagr, count = 0)
}