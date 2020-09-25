package com.example.project

import android.app.Application
import com.example.project.datas.db.AppDatabase
import com.example.project.datas.network.MyApi
import com.example.project.datas.repositories.UserRepository
import com.example.project.datas.network.NetworkConnectionInterceptor
import com.example.project.datas.repositories.AppRepository
import com.example.project.ui.Auth.AuthViewModelFactory
import com.example.project.ui.Debtors.DebtorsViewModelFactory
import com.example.project.ui.home.AddAuthorDialogViewModelFactory
import com.example.project.ui.profile.AuthorViewModelFactory
import org.kodein.di.Kodein

import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepository(instance(),instance()) }
        bind() from singleton { AppRepository(instance(),instance()) }
        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { AuthorViewModelFactory(instance()) }
        bind() from provider { AddAuthorDialogViewModelFactory(instance()) }
        bind() from provider { DebtorsViewModelFactory(instance()) }


    }

}