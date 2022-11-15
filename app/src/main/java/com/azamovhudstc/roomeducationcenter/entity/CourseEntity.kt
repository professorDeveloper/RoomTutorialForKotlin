package com.azamovhudstc.roomeducationcenter.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
data class CourseEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id:Int=0,
    @NonNull
    val name:String,


    )