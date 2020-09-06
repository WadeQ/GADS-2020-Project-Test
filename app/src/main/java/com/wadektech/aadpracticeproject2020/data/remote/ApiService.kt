package com.wadektech.aadpracticeproject2020.data.remote

import com.wadektech.aadpracticeproject2020.data.LearningLeadersItem
import com.wadektech.aadpracticeproject2020.data.SkillIqLeadersItem
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {

    @GET("/api/hours")
    fun getAllLearningLeadersAsync() : Deferred<List<LearningLeadersItem>>

    @GET("/api/skilliq")
    fun getAllSkillIqLeadersAsync() : Deferred<List<SkillIqLeadersItem>>
}