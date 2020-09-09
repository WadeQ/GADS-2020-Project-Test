package com.wadektech.aadpracticeproject2020.data.remote

import com.wadektech.aadpracticeproject2020.data.domainModels.LearningLeaders
import com.wadektech.aadpracticeproject2020.data.domainModels.Response
import com.wadektech.aadpracticeproject2020.data.domainModels.SkillIqLeaders
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("/api/hours")
    fun getAllLearningLeadersAsync() : Deferred<List<LearningLeaders>>

    @GET("/api/skilliq")
    fun getAllSkillIqLeadersAsync() : Deferred<List<SkillIqLeaders>>

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun postProjectToGoogleForm(
        @Field("entry.1824927963") email : String,
        @Field("entry.1877115667") firstName : String,
        @Field("entry.2006916086") lastName : String,
        @Field("entry.284483984") link : String
    ) : Call<Response>

}