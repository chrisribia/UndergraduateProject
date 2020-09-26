package com.example.project.ui.addDebtor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.project.R
import com.example.project.databinding.NewDebtorFragmentBinding
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class NewDebtorFragment : Fragment(),KodeinAware {
    override val kodein by kodein()


    private lateinit var viewModel: NewDebtorViewModel


    private val factory: NewDebtorViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : NewDebtorFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.new_debtor_fragment,container,false)
        viewModel = ViewModelProvider(this,factory).get(NewDebtorViewModel::class.java)
        binding.viewmodel = viewModel
        return binding.root
    }


}