package com.example.project.utils

import android.view.View
import com.example.project.datas.db.entities.Debtors

interface RecyclerViewClickListener {
    fun onRecyclerViewItemClick(view: View, debtors: Debtors)
}
