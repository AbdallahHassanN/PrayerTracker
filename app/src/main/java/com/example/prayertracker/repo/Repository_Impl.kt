package com.example.prayertracker.repo

import android.content.Context
import android.util.Log
import com.example.prayertracker.common.Constants.TAG
import com.example.prayertracker.common.Resource
import com.example.prayertracker.model.Prayer
import com.example.slwat.db.PrayerDao
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class Repository_Impl(
    private val prayerDao: PrayerDao,
    private val appContext: Context
) : Repository {
    /*override suspend fun deleteSalahCount(prayerId: Int)
            : Flow<Resource<Prayer>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateSalahCount(prayerNo: Int)
            : Flow<Resource<Prayer>> {
        TODO("Not yet implemented")
    }*/

    override suspend fun getSalahCount(prayerNo: Int)
            : Flow<Resource<Int>> = flow {
        emit(Resource.Loading(true))
        try {
            emit(Resource.Loading(false))
            val prayers = prayerDao.getSalahCount(prayerNo)
            emit(
                Resource.Success(
                    data = prayers
                )
            )
            Log.d(TAG,"RepoImpl $prayers")
        } catch (e: Exception) {
            emit(Resource.Error("Error"))
            Log.d(TAG, "Error when getting count $e")
        }
    }
}
