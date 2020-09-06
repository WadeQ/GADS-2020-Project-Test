package com.wadektech.aadpracticeproject2020.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.wadektech.aadpracticeproject2020.data.SkillIqLeadersItem

@Dao
interface SkillIqLeadersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllSkillIqLeaders(skillIqLeadersItem: List<SkillIqLeadersItem>)
}