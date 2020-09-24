package com.example.project.ui.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.project.data.network.repositories.UserRepository
import com.example.project.ui.Auth.AuthViewModel

class AuthorViewModelFactory(
    private val repository: UserRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AuthorViewModel(repository ) as T
    }
}