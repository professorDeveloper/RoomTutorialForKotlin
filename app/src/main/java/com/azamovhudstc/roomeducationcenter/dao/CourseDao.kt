package com.azamovhudstc.roomeducationcenter.dao

import androidx.room.*
import com.azamovhudstc.roomeducationcenter.entity.CourseEntity

@Dao
interface CourseDao {
    @Insert
    fun addCourse(courseEntity: CourseEntity)

    @Delete
    fun deleteCourse(courseEntity: CourseEntity)

    @Update
    fun editRoom(courseEntity: CourseEntity)


    @Query("select * from CourseEntity")
    fun getAllCourse():List<CourseEntity>
}