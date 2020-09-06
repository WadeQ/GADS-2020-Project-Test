package com.wadektech.aadpracticeproject2020.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wadektech.aadpracticeproject2020.data.domainModels.LearningLeadersItem
import com.wadektech.aadpracticeproject2020.data.domainModels.SkillIqLeadersItem


@Database(entities = [SkillIqLeadersItem::class, LearningLeadersItem::class], version = 1, exportSchema = false)
abstract class AppRoomDatabase : RoomDatabase(){
    abstract fun learningLeadersDao() : LearningLeadersDao
    abstract fun skillIqLeadersDao() : SkillIqLeadersDao

    companion object{
        const val DATABASE_NAME : String = "ROOM_DB"
    }
}