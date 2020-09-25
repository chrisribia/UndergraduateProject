package com.example.project.ui.creditors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R
import com.example.project.databinding.CreditorsBinding
import com.example.project.databinding.DebtorslistBinding
import com.example.project.datas.db.entities.Creditors
import com.example.project.datas.db.entities.Debtors
import com.example.project.utils.RecyclerViewClickListener
import com.example.project.utils.RecyclerViewClickListenerCreditors

class creditorsItem(private val creditors : List<Creditors>,
                 private val listener: RecyclerViewClickListenerCreditors
):
    RecyclerView.Adapter<creditorsItem.DebtorItemViewHolder>(){


    override fun getItemCount() = creditors.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DebtorItemViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.creditors,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: DebtorItemViewHolder, position: Int) {
        holder.credorsBinding.mcreditor = creditors[position]

    }


    inner class DebtorItemViewHolder(
        val credorsBinding: CreditorsBinding
    )
        : RecyclerView.ViewHolder(credorsBinding.root)

}