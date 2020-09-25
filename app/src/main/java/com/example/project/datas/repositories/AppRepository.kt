package com.example.project.datas.repositories

import com.example.project.datas.db.AppDatabase
import com.example.project.datas.network.MyApi
import com.example.project.datas.network.SafeApiRequest

class AppRepository(private val api: MyApi,
                    private val db: AppDatabase
) : SafeApiRequest(){
}