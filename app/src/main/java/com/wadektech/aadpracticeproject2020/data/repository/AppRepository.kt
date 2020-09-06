package com.wadektech.aadpracticeproject2020.data.repository

import androidx.paging.DataSource
import com.wadektech.aadpracticeproject2020.data.domainModels.LearningLeadersItem
import com.wadektech.aadpracticeproject2020.data.domainModels.SkillIqLeadersItem
import com.wadektech.aadpracticeproject2020.data.local.LearningLeadersDao
import com.wadektech.aadpracticeproject2020.data.local.SkillIqLeadersDao
import com.wadektech.aadpracticeproject2020.data.remote.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber


class AppRepository
constructor(
    private val learningLeadersDao: LearningLeadersDao,
    private val skillIqLeadersDao: SkillIqLeadersDao,
    private val apiService: ApiService,
)
{
    private var job = Job()
    private val _coroutineScope = CoroutineScope(job + Dispatchers.IO)

    suspend fun getAllSkillIqLeadersFromRemote(){
        _coroutineScope.launch {
            val skillIQLeaders = apiService.getAllSkillIqLeadersAsync()
            try {
                val skillsList = skillIQLeaders.await()
                skillIqLeadersDao.saveAllSkillIqLeaders(skillsList)
            } catch (t : Throwable){
                Timber.d("getAllSkillIqLeadersFromRemote: Failure due to ${t.message}")
            }
        }
    }

    suspend fun getAllLearningLeadersFromRemote(){
        _coroutineScope.launch {
            val learningLeaders = apiService.getAllLearningLeadersAsync()
            try {
                val learningList = learningLeaders.await()
                learningLeadersDao.saveAllLearningLeaders(learningList)
            } catch (t : Throwable){
                Timber.d("getAllLearningLeadersFromRemote: failure due to ${t.message}")
            }
        }
    }

    fun getAllLearningLeadersFromLocal() : DataSource.Factory<Int, LearningLeadersItem>{
        return learningLeadersDao.getAllLearningLeaders()
    }

    fun getAllSkillIqLeadersFromLocal() : DataSource.Factory<Int, SkillIqLeadersItem>{
        return skillIqLeadersDao.getAllSkillsByIq()
    }
}