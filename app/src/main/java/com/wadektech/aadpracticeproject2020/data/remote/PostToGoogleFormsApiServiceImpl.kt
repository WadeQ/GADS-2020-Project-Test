package com.wadektech.aadpracticeproject2020.data.remote

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private val gson = GsonBuilder()
    .setLenient()
    .create()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create(gson))
    .baseUrl("https://docs.google.com/forms/d/e/")
    .build()

object PostToGoogleFormsApiServiceImpl {
    val apiService : ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}