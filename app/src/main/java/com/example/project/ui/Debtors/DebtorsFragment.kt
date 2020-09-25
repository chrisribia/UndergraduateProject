package com.example.project.ui.Debtors

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.DebtorsViewModel
import com.example.project.R
import com.example.project.databinding.DebtorsFragmentBinding
import com.example.project.datas.db.entities.Debtors
import com.example.project.utils.RecyclerViewClickListener
import kotlinx.android.synthetic.main.debtors_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class DebtorsFragment : Fragment(),KodeinAware, RecyclerViewClickListener {
    override val kodein by kodein()


    private lateinit var viewModel: DebtorsViewModel

    private val factory: DebtorsViewModelFactory by instance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : DebtorsFragmentBinding = DataBindingUtil.inflate(inflater,R.layout.debtors_fragment,
            container,false)
        viewModel = ViewModelProvider(this, factory).get(DebtorsViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.fetch()
        viewModel.fetchDebtors()
        viewModel.Debtor.observe(viewLifecycleOwner, Observer { subAlt ->
            rec_list_subCriteria.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = debtorItem(subAlt, this)
            }

        })



        return  binding.root
    }

    override fun onRecyclerViewItemClick(view: View, debtors: Debtors) {
        TODO("Not yet implemented")
    }


}