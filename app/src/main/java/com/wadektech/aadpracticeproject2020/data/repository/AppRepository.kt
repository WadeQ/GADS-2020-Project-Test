package com.wadektech.aadpracticeproject2020.data.repository

import com.wadektech.aadpracticeproject2020.data.local.LearningLeadersDao
import com.wadektech.aadpracticeproject2020.data.local.SkillIqLeadersDao
import com.wadektech.aadpracticeproject2020.data.remote.ApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

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

            }
        }
    }

    suspend fun getAllLearningLeadersFromRemote(){
        _coroutineScope.launch {
            val learninLeaders = apiService.getAllLearningLeadersAsync()
            try {
                val learningList = learninLeaders.await()
                learningLeadersDao.saveAllLearningLeaders(learningList)
            } catch (t : Throwable){

            }
        }
    }
}