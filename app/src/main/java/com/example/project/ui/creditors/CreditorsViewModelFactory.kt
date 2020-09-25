package com.example.project.ui.creditors

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.project.DebtorsViewModel
import com.example.project.datas.repositories.AppRepository

class CreditorsViewModelFactory (private val repository: AppRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CreditorsViewModel(repository) as T
    }
}