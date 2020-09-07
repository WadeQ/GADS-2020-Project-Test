package com.wadektech.aadpracticeproject2020.data.local

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.wadektech.aadpracticeproject2020.data.domainModels.LearningLeaders

@Dao
interface LearningLeadersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllLearningLeaders(learningLeaders : List<LearningLeaders>)

    @Query("SELECT * FROM learning_leaders ORDER BY hours DESC")
    fun getAllLearningLeaders() : DataSource.Factory<Int, LearningLeaders>
}