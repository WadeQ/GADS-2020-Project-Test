package com.wadektech.aadpracticeproject2020.data.local

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wadektech.aadpracticeproject2020.data.domainModels.SkillIqLeaders

@Dao
interface SkillIqLeadersDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveAllSkillIqLeaders(skillIqLeadersItem: List<SkillIqLeaders>)

    @Query("SELECT * FROM skill_iq ORDER BY score DESC")
    fun getAllSkillsByIq() : DataSource.Factory<Int, SkillIqLeaders>
}