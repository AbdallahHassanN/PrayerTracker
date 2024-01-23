package com.example.prayertracker.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Prayer"
)
data class Prayer(
    @PrimaryKey(autoGenerate = true)
    var prayerId: Int?=null,
    val prayerNo:Int?= null,
    val prayerName: String,
    var prayerCount: Int,
)