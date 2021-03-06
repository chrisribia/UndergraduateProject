package com.example.project.datas.db


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.*
import androidx.room.Query
import com.example.project.datas.db.entities.CURRENT_USER_ID
import com.example.project.datas.db.entities.User

@Dao
interface UserDao{
    @Insert(onConflict = REPLACE)
    suspend fun upsert(user: List<User>)

    @Query("SELECT * FROM user WHERE uid = $CURRENT_USER_ID")
    fun getuser() : LiveData<User>


    @Query("DELETE FROM user")
    fun deleteUser()


    @Query("SELECT * FROM user WHERE id = 0")
    fun getCurrentUser(): LiveData<User>

}