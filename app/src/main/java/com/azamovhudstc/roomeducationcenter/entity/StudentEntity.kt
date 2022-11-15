package com.azamovhudstc.roomeducationcenter.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StudentEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Int = 0,
    @NonNull
    var name: String,
    @NonNull
    val byGroupId: Int,
)