package com.example.prayertracker.common


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.navapp.Screens
import com.example.prayertracker.ui.theme.Teal200

@Composable
fun TopBar() {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = Teal200,
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()

            ) {
                Text(
                    text = "Prayer Tracker",
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(10.dp)
                        .weight(1f),
                )
            }
        }
    }
}