package com.example.project.ui.debtors

import androidx.lifecycle.ViewModel
import com.example.project.data.network.repositories.UserRepository

class AddAuthorDialogViewModel(private val repository: UserRepository) : ViewModel() {
    val user = repository.getUser()
}