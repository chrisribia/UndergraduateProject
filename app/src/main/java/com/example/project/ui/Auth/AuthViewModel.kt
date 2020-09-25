package com.example.project.ui.Auth

import androidx.lifecycle.ViewModel
import com.example.project.datas.db.entities.User
import com.example.project.datas.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthViewModel(  private val repository: UserRepository) : ViewModel() {


    suspend fun userSignup(
        username: String,
        email: String,
        password: String
    ) = withContext(Dispatchers.IO) { repository.userSignup(email, username, password) }
    fun getLoggedInUser() = repository.getUser()

    suspend fun userLogin(
        username: String,
        password: String
    ) = withContext(Dispatchers.IO) { repository.userLogin(username, password) }

    suspend fun saveLoggedInUser(user: List<User>) = repository.saveUser(user)
}
