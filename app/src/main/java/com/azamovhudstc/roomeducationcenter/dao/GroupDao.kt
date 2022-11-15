package com.azamovhudstc.roomeducationcenter.dao

import androidx.room.*
import com.azamovhudstc.roomeducationcenter.entity.CourseEntity
import com.azamovhudstc.roomeducationcenter.entity.GroupEntity

@Dao
interface GroupDao {
    @Insert
    fun addGroup(groupEntity: GroupEntity)

    @Delete
    fun deleteGroup(groupEntity: GroupEntity)

    @Update
    fun editGroup(groupEntity: GroupEntity)


    @Query("select * from GroupEntity where byCourseId=  (:courseId)")
    fun getAllCourseById(courseId: Int):List<GroupEntity>
}