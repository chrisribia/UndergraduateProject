package com.example.project.ui.Debtors

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R
import com.example.project.databinding.DebtorslistBinding
import com.example.project.datas.db.entities.Debtors
import com.example.project.utils.RecyclerViewClickListener

class debtorItem(private val mDebtor : List<Debtors>,
                 private val listener: RecyclerViewClickListener):
        RecyclerView.Adapter<debtorItem.DebtorItemViewHolder>(){


    override fun getItemCount() = mDebtor.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DebtorItemViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.debtorslist,
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: DebtorItemViewHolder, position: Int) {
        holder.debtorslistBinding.mdebtor = mDebtor[position]

    }


    inner class DebtorItemViewHolder(
        val debtorslistBinding: DebtorslistBinding )
        :RecyclerView.ViewHolder(debtorslistBinding.root)

}