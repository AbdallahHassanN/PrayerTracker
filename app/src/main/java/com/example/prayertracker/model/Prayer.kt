package com.example.prayertracker.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "Prayer"
)
data class Prayer(
    @PrimaryKey(autoGenerate = true)
    val salahId: Int?=null,
    val salahNo:Int?= null,
    val salahName: String,
    val salahCount: Int,
)