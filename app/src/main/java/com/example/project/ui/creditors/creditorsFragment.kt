package com.example.project.ui.creditors

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.R
import com.example.project.databinding.CreditorsFragmentBinding
import com.example.project.datas.db.entities.Creditors
import com.example.project.utils.RecyclerViewClickListenerCreditors
import kotlinx.android.synthetic.main.creditors_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class creditorsFragment : Fragment(), KodeinAware, RecyclerViewClickListenerCreditors {
    override val kodein by kodein()


    private lateinit var viewModel: CreditorsViewModel

    private val factory: CreditorsViewModelFactory by instance()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: CreditorsFragmentBinding =
            DataBindingUtil.inflate(inflater, R.layout.creditors_fragment, container, false)
        viewModel = ViewModelProvider(this, factory).get(CreditorsViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.fetch()
        viewModel.fetchCreditors()
        viewModel.Creditor.observe(viewLifecycleOwner, Observer { subAlt ->
            rec_list_creditors.also {
                it.layoutManager = LinearLayoutManager(requireContext())
                it.setHasFixedSize(true)
                it.adapter = creditorsItem(subAlt, this)
            }

        })


        return binding.root
    }

    override fun onRecyclerViewItemClick(view: View, creditors: Creditors) {

    }


}