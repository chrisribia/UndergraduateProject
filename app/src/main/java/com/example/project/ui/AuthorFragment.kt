package com.example.project.ui

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.project.R
import com.example.project.ui.Auth.LoginActivity
import com.example.project.ui.Auth.RegistrationActivity
import kotlinx.android.synthetic.main.author_fragment.*

class AuthorFragment : Fragment() {

    companion object {
        fun newInstance() = AuthorFragment()
    }

    private lateinit var viewModel: AuthorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        return inflater.inflate(R.layout.author_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AuthorViewModel::class.java)

    }




}