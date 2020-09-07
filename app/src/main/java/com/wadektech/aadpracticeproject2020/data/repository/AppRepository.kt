package com.wadektech.aadpracticeproject2020.data.repository

import androidx.paging.DataSource
import com.wadektech.aadpracticeproject2020.data.domainModels.LearningLeaders
import com.wadektech.aadpracticeproject2020.data.domainModels.SkillIqLeaders
import com.wadektech.aadpracticeproject2020.data.local.LearningLeadersDao
import com.wadektech.aadpracticeproject2020.data.local.SkillIqLeadersDao
import com.wadektech.aadpracticeproject2020.data.remote.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber


class AppRepository(
    private val skillIqLeadersDao: SkillIqLeadersDao,
    private val leadersDao: LearningLeadersDao,
    private val apiService: ApiService
)
{
    private var job = Job()
    private val _coroutineScope = CoroutineScope(job + Dispatchers.IO)

    suspend fun getAllSkillIqLeadersFromRemote(){
        _coroutineScope.launch {
            val skillIQLeaders = apiService.getAllSkillIqLeadersAsync()
            try {
                val skillsList = skillIQLeaders.await()
                Timber.d("getAllSkillIqLeadersFromRemote: success skills list size ${skillsList.size}")
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
                Timber.d("getAllSkillIqLeadersFromRemote: success learning list size ${learningList.size}")
                leadersDao.saveAllLearningLeaders(learningList)
            } catch (t : Throwable){
                Timber.d("getAllLearningLeadersFromRemote: failure due to ${t.message}")
            }
        }
    }

    fun getAllLearningLeadersFromLocal() : DataSource.Factory<Int, LearningLeaders>{
        return leadersDao.getAllLearningLeaders()
    }

    fun getAllSkillIqLeadersFromLocal() : DataSource.Factory<Int, SkillIqLeaders>{
        return skillIqLeadersDao.getAllSkillsByIq()
    }
}