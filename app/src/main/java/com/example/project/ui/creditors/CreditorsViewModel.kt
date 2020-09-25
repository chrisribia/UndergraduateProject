package com.example.project.ui.creditors

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.project.datas.db.entities.Creditors
import com.example.project.datas.repositories.AppRepository
import com.example.project.utils.Coroutines
import kotlinx.coroutines.Job

class CreditorsViewModel(private val repository: AppRepository) : ViewModel() {

    private lateinit var job: Job
    private val _creditor = MutableLiveData<List<Creditors>>()
    val Creditor: LiveData<List<Creditors>>
        get() = _creditor

    fun fetch() {
        Coroutines.io {
            repository.fetchCreditors()

        }
    }


    fun fetchCreditors() {
        job = Coroutines.ioThenMain(
            { repository.getCreditors() }, {
                _creditor.value = it
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }


}