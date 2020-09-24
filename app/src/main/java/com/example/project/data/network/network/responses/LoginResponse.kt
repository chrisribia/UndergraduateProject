package com.example.project.data.network.network.responses

import com.example.project.data.network.db.entities.User


data class LoginResponse(
    val error : Boolean?,
    val message: String?,
    val user: List<User>
)