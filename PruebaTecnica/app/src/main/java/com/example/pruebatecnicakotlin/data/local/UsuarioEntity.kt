package com.example.pruebatecnicakotlin.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuarios")
data class UsuarioEntity(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val usuario: String?,

    val identificacion: String?,

    val nombre: String?
)