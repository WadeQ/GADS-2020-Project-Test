package com.wadektech.aadpracticeproject2020.data.domainModels


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "learning_leaders")
data class LearningLeaders(
    @Json(name = "badgeUrl")
    val badgeUrl: String,
    @Json(name = "country")
    val country: String,
    @PrimaryKey(autoGenerate = false)
    @Json(name = "hours")
    val hours: Int,
    @Json(name = "name")
    val name: String
)