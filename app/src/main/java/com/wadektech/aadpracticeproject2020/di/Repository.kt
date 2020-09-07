package com.wadektech.aadpracticeproject2020.di

import com.wadektech.aadpracticeproject2020.data.local.LearningLeadersDao
import com.wadektech.aadpracticeproject2020.data.local.SkillIqLeadersDao
import com.wadektech.aadpracticeproject2020.data.remote.ApiService
import com.wadektech.aadpracticeproject2020.data.repository.AppRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun providePostsRepository(
        skillIqLeadersDao: SkillIqLeadersDao,
        learningLeadersDao: LearningLeadersDao,
        apiService: ApiService
    ) : AppRepository {
        return AppRepository(skillIqLeadersDao,learningLeadersDao,apiService)
    }
}