package com.example.project.datas.network.responses

import com.example.project.datas.db.entities.Creditors

data class CreditorsResponse (

    val error : Boolean?,
    val creditors: List<Creditors>
)