package com.example.pruebatecnicakotlin.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UsuarioDao {

    @Insert(
        onConflict =
            OnConflictStrategy.REPLACE
    )
    suspend fun insertUsuario(
        usuario: UsuarioEntity
    )

    @Query(
        "SELECT * FROM usuarios LIMIT 1"
    )
    suspend fun getUsuario():
            UsuarioEntity?

    @Query(
        "SELECT * FROM usuarios ORDER BY id DESC LIMIT 1"
    )
    suspend fun getLastUsuario():
            UsuarioEntity?
}