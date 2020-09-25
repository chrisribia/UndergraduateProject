package com.example.project.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.project.R
import com.example.project.databinding.AddAuthorDialogFragmentBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class AddAuthorDialogFragment : Fragment(), KodeinAware {

    override val kodein by kodein()

    private lateinit var viewModel: AddAuthorDialogViewModel

    private val factory: AddAuthorDialogViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding : AddAuthorDialogFragmentBinding= DataBindingUtil.inflate(inflater,R.layout.add_author_dialog_fragment,container,false);
        viewModel = ViewModelProvider(this,factory).get(AddAuthorDialogViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }



}