package com.azamovhudstc.roomeducationcenter.dao

import androidx.room.*
import com.azamovhudstc.roomeducationcenter.entity.CourseEntity
import com.azamovhudstc.roomeducationcenter.entity.GroupEntity
import com.azamovhudstc.roomeducationcenter.entity.StudentEntity

@Dao
interface StudentDao {
    @Insert
    fun addStudent(groupEntity: StudentEntity)

    @Delete
    fun deleteGroup(groupEntity: StudentEntity)

    @Update
    fun editGroup(groupEntity: StudentEntity)


    @Query("select * from StudentEntity where byGroupId=  (:groupsId)")
    fun getAllStudentById(groupsId: Int):List<StudentEntity>
}