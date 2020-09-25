package com.example.project.datas.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Debtors (
    @PrimaryKey(autoGenerate = false)
    val id : Int,
    val debtor_name : String?,
    val amount : String?,
    val date_of_payment : String?
)
