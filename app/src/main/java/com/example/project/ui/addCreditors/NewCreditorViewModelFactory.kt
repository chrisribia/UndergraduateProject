package com.example.project.ui.addCreditors

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.project.datas.repositories.AppRepository
import com.example.project.ui.creditors.CreditorsViewModel

class NewCreditorViewModelFactory (private val repository: AppRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewCreditorViewModel(repository) as T
    }
}