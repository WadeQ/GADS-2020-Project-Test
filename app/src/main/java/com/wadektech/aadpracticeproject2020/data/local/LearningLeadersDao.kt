package com.wadektech.aadpracticeproject2020.data.local

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wadektech.aadpracticeproject2020.data.LearningLeadersItem

@Dao
interface LearningLeadersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllLearningLeaders(learningLeaders : List<LearningLeadersItem>)

    @Query("SELECT * FROM learning_leaders ORDER BY name ASC")
    fun getAllLearningLeaders() : DataSource.Factory<Int, LearningLeadersItem>
}