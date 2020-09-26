package com.example.project.ui.addDebtor

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.project.datas.repositories.AppRepository
import com.example.project.utils.Coroutines
import com.example.project.utils.snackbar

class NewDebtorViewModel(private val repository: AppRepository): ViewModel() {
    var name : String? = null
    var tel : String? = null
    var amount : String? = null
    var date : String? = null
    fun saveDebtor(view : View){
        Coroutines.io {
            try {

                val response =  repository.addDebtor1(name!!,tel!!,amount!!,date!!)
                view.snackbar(response.message!!)

            }
            catch (e: Exception){
                view.snackbar(e.message!!)
            }
        }
    }
}