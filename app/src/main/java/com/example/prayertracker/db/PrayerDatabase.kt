package com.example.slwat.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.prayertracker.model.Prayer

@Database(
    entities = [Prayer::class],
    version = 4,
    exportSchema = false
)
abstract class PrayerDatabase : RoomDatabase() {
    abstract val prayerDao: PrayerDao

}


