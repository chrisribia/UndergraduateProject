package com.example.project.data.network.network.responses



data class AuthResponse(
    val error : Boolean?,
    val message: String?,
    val user: String?
)