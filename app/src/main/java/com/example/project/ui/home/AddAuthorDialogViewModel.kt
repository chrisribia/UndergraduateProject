package com.example.project.ui.home

import androidx.lifecycle.ViewModel
import com.example.project.datas.repositories.UserRepository

class AddAuthorDialogViewModel(private val repository: UserRepository) : ViewModel() {
    val user = repository.getUser()
}