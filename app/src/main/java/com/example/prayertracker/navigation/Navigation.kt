package com.example.navapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.prayertracker.ui.presentation.LatePrayerRecord.LatePrayerRecordScreen
import com.example.prayertracker.ui.presentation.MainScreen.MainScreen
import com.example.prayertracker.ui.presentation.PrayerLog.PrayerLogScreen
import com.example.steamdbmockup.ui.presentation.DetailScreen.ForgottenPrayersScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.MainScreen.route) {
        composable(route = Screens.MainScreen.route) {
            MainScreen(navController = navController)
        }
        composable(route = Screens.ForgottenPrayers.route) {
            ForgottenPrayersScreen()
        }
        composable(route = Screens.LatePrayerRecord.route) {
            LatePrayerRecordScreen()
        }
        composable(route = Screens.PrayerLog.route) {
            PrayerLogScreen()
        }
    }
}