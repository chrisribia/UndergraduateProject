package com.example.project.ui.home

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.project.datas.repositories.AppRepository
import com.example.project.datas.repositories.UserRepository

class AddAuthorDialogViewModel(private val repository: UserRepository,private val repository1: AppRepository) : ViewModel() {
    val user = repository.getUser()

    fun  onCLickLogout(view : View){

        fun logout() = repository1.logout()
    }
}