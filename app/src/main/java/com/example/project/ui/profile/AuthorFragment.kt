package com.example.project.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.project.R
import com.example.project.databinding.AuthorFragmentBinding
import org.kodein.di.android.x.kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class AuthorFragment : Fragment(), KodeinAware {

    override val kodein by kodein()

    companion object {
        fun newInstance() = AuthorFragment()
    }

    private lateinit var viewModel: AuthorViewModel
    private val factory: AuthorViewModelFactory by instance()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: AuthorFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.author_fragment, container, false)
        viewModel = ViewModelProvider(this, factory).get(AuthorViewModel::class.java)
        return binding.root
    }



}