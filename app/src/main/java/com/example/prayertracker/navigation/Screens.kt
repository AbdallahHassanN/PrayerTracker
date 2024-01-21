package com.example.navapp

sealed class Screens(val route:String) {
    object MainScreen : Screens("mainScreen")
    object ForgottenPrayers : Screens("forgottenPrayers")
    object LatePrayerRecord : Screens("latePrayerRecord")
    object PrayerLog : Screens("prayerLog")
}