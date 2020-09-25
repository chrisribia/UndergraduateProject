package com.example.project.datas.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Creditors (
    @PrimaryKey(autoGenerate = false)
    val id : Int,
    val credotors_name : String?,
    val amount : String?,
    val date_of_payment : String?
)
