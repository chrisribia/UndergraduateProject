package com.example.project.ui.Debtors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.project.DebtorsViewModel
import com.example.project.R
import com.example.project.databinding.DebtorsFragmentBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class DebtorsFragment : Fragment(),KodeinAware {
    override val kodein by kodein()


    private lateinit var viewModel: DebtorsViewModel

    private val factory: DebtorsViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : DebtorsFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.debtors_fragment,container,false)
        viewModel = ViewModelProvider(this, factory).get(DebtorsViewModel::class.java)
        binding.viewmodel = viewModel
        return  binding.root
    }



}