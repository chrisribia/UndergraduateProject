package com.example.project.datas.network.responses



data class AuthResponse(
    val error : Boolean?,
    val message: String?,
    val user: String?
)