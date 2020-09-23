package com.example.project.ui.Auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.project.R
import com.example.project.databinding.ActivityLoginBinding
import com.example.project.databinding.ActivityRegistrationBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class LoginActivity : AppCompatActivity() , KodeinAware {

    override val kodein by kodein()

    private lateinit var viewModel: AuthViewModel

    private lateinit var binding: ActivityLoginBinding

    private val factory: AuthViewModelFactory by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProvider(this,factory).get(AuthViewModel::class.java)
    }
}