package com.wadektech.aadpracticeproject2020.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wadektech.aadpracticeproject2020.data.domainModels.LearningLeaders
import com.wadektech.aadpracticeproject2020.data.domainModels.SkillIqLeaders


@Database(entities = [SkillIqLeaders::class, LearningLeaders::class], version = 6, exportSchema = false)
abstract class AppRoomDatabase : RoomDatabase(){
    abstract fun learningLeadersDao() : LearningLeadersDao
    abstract fun skillIqLeadersDao() : SkillIqLeadersDao

    companion object{
        const val DATABASE_NAME : String = "ROOM_DB"
    }
}