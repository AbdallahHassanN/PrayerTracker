package com.example.prayertracker.di


import android.content.Context
import com.example.prayertracker.repo.Repository
import com.example.prayertracker.repo.Repository_Impl
import com.example.slwat.db.PrayerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(
        prayerDao: PrayerDao,
        @ApplicationContext appContext: Context // Use @ApplicationContext to get the application context
    ): Repository {
        return Repository_Impl(prayerDao,appContext)
    }
}