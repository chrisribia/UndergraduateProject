package com.example.project

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.example.project.datas.db.entities.Debtors
import com.example.project.datas.repositories.AppRepository
import com.example.project.datas.repositories.UserRepository
import com.example.project.ui.Debtors.DebtorsFragmentDirections
import com.example.project.utils.Coroutines
import kotlinx.coroutines.Job

class DebtorsViewModel(private val repository: AppRepository) : ViewModel() {

    private lateinit var job: Job
    private val _debtor = MutableLiveData<List<Debtors>>()
    val Debtor : LiveData<List<Debtors>>
        get() = _debtor
    fun fetch() {
        Coroutines.io {
            repository.fetchDebtors()

        }
    }


    fun fetchDebtors() {
        job = Coroutines.ioThenMain(
            { repository.getDebtors() }, {
                _debtor.value = it
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
    fun onClickToAddDebtorFragment(view: View) {
        val action =  DebtorsFragmentDirections.actionDebtorsFragmentToNewDebtorFragment()
        Navigation.findNavController(view).navigate(action)

    }




}