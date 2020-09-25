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
    fun saveAllDebtors(weights : List<Debtors>)



    @Query("SELECT * FROM Debtors")
    fun getWeights() : LiveData<List<Debtors>>


}