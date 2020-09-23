package com.example.project.ui

import android.app.Application
import com.example.project.ui.Auth.AuthViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class ProjectApplication : Application(),KodeinAware {


    override val kodein = Kodein.lazy {
        import(androidXModule(this@ProjectApplication))
        bind()from singleton { AuthViewModelFactory(instance()) }
    }
}