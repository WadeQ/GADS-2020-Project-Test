package com.wadektech.aadpracticeproject2020.data


import androidx.room.Entity
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "skill_iq")
data class SkillIqLeadersItem(
    @Json(name = "badgeUrl")
    val badgeUrl: String,
    @Json(name = "country")
    val country: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "score")
    val score: Int
)