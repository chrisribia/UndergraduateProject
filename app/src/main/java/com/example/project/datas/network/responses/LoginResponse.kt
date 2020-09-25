package com.example.project.datas.network.responses

import com.example.project.datas.db.entities.User


data class LoginResponse(
    val error : Boolean?,
    val message: String?,
    val user: List<User>
)