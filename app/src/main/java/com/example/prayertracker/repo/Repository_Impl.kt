package com.example.prayertracker.repo

import android.content.Context
import android.util.Log
import com.example.prayertracker.common.Constants.TAG
import com.example.prayertracker.common.Resource
import com.example.slwat.db.PrayerDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Repository_Impl(
    private val prayerDao: PrayerDao,
    private val appContext: Context
) : Repository {
    override suspend fun deleteSalahCount(prayerId: Int)
            : Flow<Resource<Unit>> = flow {
        emit(Resource.Loading(true))
        try {
            emit(Resource.Loading(false))
            val prayerCount = prayerDao.deletePrayerCount(prayerId)
            emit(
                Resource.Success(
                    data = prayerCount
                )
            )
        } catch (e: Exception) {
            emit(Resource.Error("Error"))
            Log.d(TAG, "Error when getting count $e")
        }
    }

    override suspend fun updateSalahCount(prayerId: Int)
            : Flow<Resource<Unit>> = flow {
        emit(Resource.Loading(true))
        try {
            emit(Resource.Loading(false))
            val prayerCount = prayerDao.updatePrayerCount(prayerId)
            emit(
                Resource.Success(
                    data = prayerCount
                )
            )
        } catch (e: Exception) {
            emit(Resource.Error("Error"))
            Log.d(TAG, "Error when getting count $e")
        }
    }

    override suspend fun getPrayerCount(prayerId: Int)
            : Flow<Resource<Int>> = flow {
        emit(Resource.Loading(true))
        try {
            emit(Resource.Loading(false))
            val prayers = prayerDao.getPrayerCount(prayerId)
            emit(
                Resource.Success(
                    data = prayers
                )
            )
            Log.d(TAG, "RepoImpl $prayers")
        } catch (e: Exception) {
            emit(Resource.Error("Error"))
            Log.d(TAG, "Error when getting count $e")
        }
    }
}
