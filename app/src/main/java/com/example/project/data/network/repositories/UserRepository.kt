package com.example.project.data.network.repositories

import com.example.project.data.network.MyApi
import com.example.project.data.network.SafeApiRequest
import com.example.project.data.network.responses.AuthResponse

class UserRepository( private val api: MyApi): SafeApiRequest() {


    suspend fun userSignup(
        email: String,
        username: String,
        password: String
    ) : AuthResponse {
        return apiRequest{ api.userSignup(email, username, password)}
    }
}