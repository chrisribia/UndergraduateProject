package com.example.project.ui.addCreditors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.project.R
import com.example.project.databinding.NewCreditorFragmentBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class NewCreditorFragment : Fragment() ,KodeinAware{
    override val kodein by kodein()


    private lateinit var viewModel: NewCreditorViewModel


    private val factory: NewCreditorViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : NewCreditorFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.new_creditor_fragment,container,false)
        viewModel = ViewModelProvider(this,factory).get(NewCreditorViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }



}