package com.example.slwat.db

import androidx.room.*
import com.example.prayertracker.model.Prayer

@Dao
interface PrayerDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   fun upsert(prayer: List<Prayer>)

   @Query("SELECT prayerCount FROM prayer")
   suspend fun getInitialValues(): Int
   @Query("Update Prayer SET prayerCount = prayerCount + 1 Where prayerId = :prayerId")
   suspend fun updatePrayerCount(prayerId:Int)

   @Query("Update Prayer SET prayerCount = prayerCount - 1 Where prayerId = :prayerId AND prayerCount > 0")
   suspend fun deletePrayerCount(prayerId:Int)

   @Query("SELECT prayerCount FROM Prayer where prayerId = :prayerId")
   suspend fun getPrayerCount(prayerId:Int): Int
}