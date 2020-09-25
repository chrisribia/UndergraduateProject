package com.example.project.datas.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.project.datas.db.entities.Debtors

@Dao
interface   DebtorsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllDebtors(debtors : List<Debtors>)



    @Query("SELECT * FROM Debtors")
    fun getDebtors() :  List<Debtors>

//    @Query("SELECT * FROM SubAlt WHERE importance = 1 and project=:project and alt=:alt")
//    fun subCritriaGen(project: String, alt: String): LiveData<List<SubAlt>>


}