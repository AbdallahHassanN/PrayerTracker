package com.example.prayertracker.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.prayertracker.ui.theme.Teal200

@Composable
fun PrayerCard(
    text: String,
    imageResource: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(180.dp)
            .height(150.dp)
            .padding(10.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(Teal200),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Row(
            modifier = Modifier
                .align(Alignment.End)
        ) {
            val image = loadPicture(
                image = imageResource,
            ).value
            image?.let { img ->
                Image(
                    bitmap = img.asImageBitmap(),
                    contentDescription = "PrayerImage",
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .padding(
                            top = 5.dp,
                            end = 10.dp
                        ),
                    contentScale = ContentScale.Crop
                )
            }
        }
        Row(
            modifier = Modifier
                .align(Alignment.End)
        ) {
            Text(
                text = text,
                modifier = Modifier
                    .padding(
                        top = 5.dp,
                        end = 5.dp
                    ),
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
            )
        }
    }
}