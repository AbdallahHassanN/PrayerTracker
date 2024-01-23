package com.example.prayertracker.repo


import com.example.prayertracker.common.Resource
import com.example.prayertracker.model.Prayer
import kotlinx.coroutines.flow.Flow

interface Repository {
    /*suspend fun deleteSalahCount(prayerId: Int)
    : Flow<Resource<Prayer>>

    suspend fun updateSalahCount(prayerNo: Int)
    : Flow<Resource<Prayer>>*/

    suspend fun getSalahCount(prayerNo: Int)
    : Flow<Resource<Int>>
}