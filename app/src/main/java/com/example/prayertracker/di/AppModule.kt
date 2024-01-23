package com.example.prayertracker.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.prayertracker.BaseApplication
import com.example.prayertracker.model.Prayer
import com.example.slwat.db.PrayerDao
import com.example.slwat.db.PrayerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
        return app as BaseApplication
    }

    @Provides
    @Singleton
    fun provideSalahDatabase(@ApplicationContext context: Context): PrayerDatabase {
        val databaseBuilder = Room.databaseBuilder(
            context.applicationContext,
            PrayerDatabase::class.java,
            "prayer_db.db"
        ).fallbackToDestructiveMigration()

        val database = databaseBuilder.build()

        // Provide initial values
        Executors.newSingleThreadExecutor().execute {
            database.prayerDao.upsert(getInitialPrayerList())
        }
        return database
    }

    private fun getInitialPrayerList(): List<Prayer> {
        val fajr = Prayer(1, 1, "Fajr", 0)
        val dhuhr = Prayer(2, 2, "Dhuhr", 0)
        val asr = Prayer(3, 3, "Asr", 0)
        val maghrib = Prayer(4, 4, "Maghrib", 0)
        val isha = Prayer(5, 5, "Isha", 0)

        return listOf(fajr, dhuhr, asr, maghrib, isha)
    }

    @Provides
    @Singleton
    fun providesMovieDao(movieDatabase: PrayerDatabase): PrayerDao {
        return movieDatabase.prayerDao
    }
}