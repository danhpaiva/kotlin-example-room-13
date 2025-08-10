package com.example.musclegym.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TB_SUPLEMENTOS")
class Suplemento {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long = 0

    @ColumnInfo(name = "nome")
    var nome: String = ""

    @ColumnInfo(name = "descricao")
    var descricao: String = ""

    @ColumnInfo(name = "preco")
    var preco: String = ""
}