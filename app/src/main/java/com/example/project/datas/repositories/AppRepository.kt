package com.example.project.datas.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.project.datas.db.AppDatabase
import com.example.project.datas.db.entities.Creditors
import com.example.project.datas.db.entities.Debtors
import com.example.project.datas.network.MyApi
import com.example.project.datas.network.SafeApiRequest
import com.example.project.datas.network.responses.AddCreditorRespose
import com.example.project.datas.network.responses.AddDebtorRespose
import com.example.project.datas.network.responses.AuthResponse
import com.example.project.utils.Coroutines

class AppRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {


    private val debtor = MutableLiveData<List<Debtors>>()
    private val creditor = MutableLiveData<List<Creditors>>()

    init {
        debtor.observeForever {
            saveDebtors(it)

        }
        creditor.observeForever {
            savecreditors(it)

        }
    }


    suspend fun fetchCreditors() {
        try {
            val response = apiRequest { api.getCreditors() }
            creditor.postValue(response.creditors)

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    suspend fun fetchDebtors() {
        try {
            val response = apiRequest { api.getDebtors() }
            debtor.postValue(response.debtors)

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun savecreditors(creditors: List<Creditors>) {
        try {
            Coroutines.io {
                db.getCreditorssDao().saveAllCreditors(creditors)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    private fun saveDebtors(debtorslist: List<Debtors>) {
        try {
            Coroutines.io {
                db.getDebtorsDao().saveAllDebtors(debtorslist)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


    fun getDebtors() = db.getDebtorsDao().getDebtors()
    fun getCreditors() = db.getCreditorssDao().getCreditors()

    suspend fun addCreditor1(
        name: String,
        tel: String,
        amount: String,
        date: String
    ): AddCreditorRespose {
        return apiRequest { api.addCreditor(name, tel, amount, date) }
    }

    suspend fun addDebtor1(
        name: String,
        tel: String,
        amount: String,
        date: String
    ): AddDebtorRespose {
        return apiRequest { api.addDebtor(name, tel, amount, date) }
    }


    fun logout() = db.getUserDao().deleteUser()
}