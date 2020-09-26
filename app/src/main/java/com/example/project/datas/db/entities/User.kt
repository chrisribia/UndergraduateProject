package com.example.project.datas.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


const val CURRENT_USER_ID = 0
@Entity
data class User (
    var id: Int? = null,
    var email: String? = null,
    var username: String? = null
){
    @PrimaryKey(autoGenerate = false)
    var uid: Int = CURRENT_USER_ID
}