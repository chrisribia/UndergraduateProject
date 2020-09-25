package com.example.project.ui.Debtors

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.project.DebtorsViewModel
import com.example.project.datas.repositories.AppRepository

class DebtorsViewModelFactory(private val repository: AppRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DebtorsViewModel(repository) as T
    }
}