package com.wadektech.aadpracticeproject2020.data.domainModels


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "skill_iq")
data class SkillIqLeaders(
    @PrimaryKey(autoGenerate = true)
    val id : Int,
    @Json(name = "badgeUrl")
    val badgeUrl: String,
    @Json(name = "country")
    val country: String,
    @PrimaryKey
    @Json(name = "name")
    val name: String,
    @Json(name = "score")
    val score: Int
)