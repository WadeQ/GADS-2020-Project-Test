package com.wadektech.aadpracticeproject2020.data.local

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wadektech.aadpracticeproject2020.data.domainModels.SkillIqLeadersItem

@Dao
interface SkillIqLeadersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllSkillIqLeaders(skillIqLeadersItem: List<SkillIqLeadersItem>)

    @Query("SELECT * FROM skill_iq ORDER BY score ASC")
    fun getAllSkillsByIq() : DataSource.Factory<Int, SkillIqLeadersItem>
}