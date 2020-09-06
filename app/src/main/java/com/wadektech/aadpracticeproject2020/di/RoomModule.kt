package com.wadektech.aadpracticeproject2020.di

import android.content.Context
import androidx.room.Room
import com.wadektech.aadpracticeproject2020.data.local.LearningLeadersDao
import com.wadektech.aadpracticeproject2020.data.local.AppRoomDatabase
import com.wadektech.aadpracticeproject2020.data.local.SkillIqLeadersDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context) : AppRoomDatabase {
        return Room.databaseBuilder(
            context,
            AppRoomDatabase::class.java,
            AppRoomDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideLearningDao(appRoomDatabase: AppRoomDatabase) : LearningLeadersDao{
        return appRoomDatabase.learningLeadersDao()
    }

    @Singleton
    @Provides
    fun provideSkillIqDao(appRoomDatabase: AppRoomDatabase) : SkillIqLeadersDao{
        return appRoomDatabase.skillIqLeadersDao()
    }
}