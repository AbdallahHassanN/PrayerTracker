package com.example.prayertracker.repo


import com.example.prayertracker.common.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun deleteSalahCount(prayerId: Int)
            : Flow<Resource<Unit>>

    suspend fun updateSalahCount(prayerId: Int)
            : Flow<Resource<Unit>>

    suspend fun getPrayerCount(prayerId: Int)
            : Flow<Resource<Int>>
}