package com.example.project.datas.network.responses

import com.example.project.datas.db.entities.Debtors

data class DebtorsResponse (
    val error : Boolean?,
    val debtors: List<Debtors>
)