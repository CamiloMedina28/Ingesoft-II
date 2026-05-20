package com.example.pruebatecnicakotlin.data.repository

import android.content.Context
import com.example.pruebatecnicakotlin.data.local.AppDatabase

class HomeRepository(
    private val context: Context
) {

    suspend fun getUsuario() =

        AppDatabase
            .getDatabase(context)
            .usuarioDao()
            .getLastUsuario()
}