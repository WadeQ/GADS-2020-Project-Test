package com.wadektech.aadpracticeproject2020.data.remote

import com.wadektech.aadpracticeproject2020.data.domainModels.LearningLeaders
import com.wadektech.aadpracticeproject2020.data.domainModels.SkillIqLeaders
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {

    @GET("/api/hours")
    fun getAllLearningLeadersAsync() : Deferred<List<LearningLeaders>>

    @GET("/api/skilliq")
    fun getAllSkillIqLeadersAsync() : Deferred<List<SkillIqLeaders>>
}