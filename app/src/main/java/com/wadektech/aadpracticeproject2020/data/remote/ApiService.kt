package com.wadektech.aadpracticeproject2020.data.remote

import com.wadektech.aadpracticeproject2020.data.domainModels.LearningLeaders
import com.wadektech.aadpracticeproject2020.data.domainModels.SkillIqLeaders
import com.wadektech.aadpracticeproject2020.data.domainModels.Submit
import kotlinx.coroutines.Deferred
import okhttp3.Call
import retrofit2.http.*

interface ApiService {

    @GET("/api/hours")
    fun getAllLearningLeadersAsync() : Deferred<List<LearningLeaders>>

    @GET("/api/skilliq")
    fun getAllSkillIqLeadersAsync() : Deferred<List<SkillIqLeaders>>

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun postProjectToGoogleForm(
        @Body submit: Submit
    )

}