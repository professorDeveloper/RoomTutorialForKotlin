package com.azamovhudstc.roomeducationcenter.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.azamovhudstc.roomeducationcenter.dao.CourseDao
import com.azamovhudstc.roomeducationcenter.dao.GroupDao
import com.azamovhudstc.roomeducationcenter.dao.StudentDao
import com.azamovhudstc.roomeducationcenter.entity.CourseEntity
import com.azamovhudstc.roomeducationcenter.entity.GroupEntity
import com.azamovhudstc.roomeducationcenter.entity.StudentEntity

@Database(entities = [CourseEntity::class,GroupEntity::class,StudentEntity::class], version = 1)
abstract class AppDataBase(): RoomDatabase() {
    abstract fun getCourseDao():CourseDao
    abstract fun getGroupDao():GroupDao
    abstract fun getStudentDao():StudentDao
    companion object
    {
        private var instance:AppDataBase?=null
        fun getInstance():AppDataBase{
            return  instance!!
        }

        fun init(context: Context):AppDataBase{
            return instance?:Room.databaseBuilder(context,AppDataBase::class.java,"course.db")
                .allowMainThreadQueries()
                .build().also {
                    instance=it
                }
        }

    }
}