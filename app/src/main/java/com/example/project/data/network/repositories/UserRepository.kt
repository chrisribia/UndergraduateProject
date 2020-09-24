package com.example.project.data.network.repositories

import com.example.project.data.network.db.AppDatabase
import com.example.project.data.network.db.entities.User
import com.example.project.data.network.network.MyApi
import com.example.project.data.network.network.SafeApiRequest
import com.example.project.data.network.network.responses.AuthResponse
import com.example.project.data.network.network.responses.LoginResponse

class UserRepository( private val api: MyApi,
                      private val db: AppDatabase
): SafeApiRequest() {


    suspend fun userSignup(
        email: String,
        username: String,
        password: String
    ) : AuthResponse {
        return apiRequest{ api.userSignup(email, username, password)}
    }


    suspend fun userLogin(username: String, password: String): LoginResponse {
        return apiRequest { api.userLogin(username, password) }
    }

    suspend fun saveUser(user: List<User>) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getuser()
}