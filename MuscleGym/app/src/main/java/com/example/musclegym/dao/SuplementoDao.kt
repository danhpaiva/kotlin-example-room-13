package com.example.musclegym.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.musclegym.model.Suplemento

@Dao
interface SuplementoDao {
    @Insert
    fun insertSuplemento(suplemento: Suplemento) : Long

    @Update
    fun updateSuplemento(suplemento: Suplemento): Int

    @Delete
    fun deleteSuplemento(suplemento: Suplemento): Int

    @Query("SELECT * FROM tb_suplementos WHERE id = :id")
    fun get(id: Int): Suplemento

    @Query("SELECT * FROM tb_suplementos")
    fun getAll(): List<Suplemento>
}