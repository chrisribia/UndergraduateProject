package com.example.project.ui.Auth

import androidx.lifecycle.ViewModel
import com.example.project.data.network.repositories.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthViewModel(  private val repository: UserRepository) : ViewModel() {


    suspend fun userSignup(
        username: String,
        email: String,
        password: String
    ) = withContext(Dispatchers.IO) { repository.userSignup(email, username, password) }

}