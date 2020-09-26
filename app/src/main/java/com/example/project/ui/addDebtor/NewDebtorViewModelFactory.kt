package com.example.project.ui.addDebtor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.project.datas.repositories.AppRepository
import com.example.project.ui.creditors.CreditorsViewModel

class NewDebtorViewModelFactory (private val repository: AppRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return NewDebtorViewModel(repository) as T
    }
}