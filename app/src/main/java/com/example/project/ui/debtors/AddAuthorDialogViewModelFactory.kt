package com.example.project.ui.debtors

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.project.data.network.repositories.UserRepository

class AddAuthorDialogViewModelFactory(
    private val repository: UserRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddAuthorDialogViewModel(repository ) as T
    }
}