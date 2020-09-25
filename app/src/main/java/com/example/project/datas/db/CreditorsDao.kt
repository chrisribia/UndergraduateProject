package com.example.project.datas.db


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.OnConflictStrategy.*
import androidx.room.Query
import com.example.project.datas.db.entities.CURRENT_USER_ID
import com.example.project.datas.db.entities.Creditors
import com.example.project.datas.db.entities.Debtors
import com.example.project.datas.db.entities.User

@Dao
interface CreditorsDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAllCreditors(creditors : List<Creditors>)



    @Query("SELECT * FROM Creditors")
    fun getCreditors() :  List<Creditors>

}