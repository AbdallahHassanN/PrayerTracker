package com.example.slwat.db

import androidx.room.*
import com.example.prayertracker.model.Prayer

@Dao
interface PrayerDao {

   @Insert(onConflict = OnConflictStrategy.REPLACE)
   fun upsert(prayer: List<Prayer>)

   @Query("Update Prayer SET prayerCount = prayerCount + 1 Where prayerNo = :prayerNo")
   suspend fun updateSalahCount(prayerNo:Int)

   @Query("Update Prayer SET prayerCount = prayerCount - 1 Where prayerId = :prayerId AND prayerCount > 0")
   suspend fun deleteSalahCount(prayerId:Int)

   /*@Query("SELECT * FROM Salah where salahId = :salahId")
   fun getSalahCount(salahId: Int): LiveData<List<Salah>>*/

   /*@Query("SELECT * FROM Salah where salahNo = :salahNo")
   fun getSalahCount(salahNo:Int): LiveData<List<Salah>>*/

   @Query("SELECT prayerCount FROM Prayer where prayerNo = :prayerNo")
   suspend fun getSalahCount(prayerNo:Int): Int
}