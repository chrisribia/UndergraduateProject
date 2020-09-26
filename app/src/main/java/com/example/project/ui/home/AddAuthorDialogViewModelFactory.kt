package com.example.project.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.project.datas.repositories.AppRepository
import com.example.project.datas.repositories.UserRepository

class AddAuthorDialogViewModelFactory(
    private val repository: UserRepository,private val repository1: AppRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AddAuthorDialogViewModel(repository,repository1 ) as T
    }
}