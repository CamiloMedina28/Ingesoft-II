package com.example.pruebatecnicakotlin.data.repository

import android.content.Context
import com.example.pruebatecnicakotlin.data.local.AppDatabase
import com.example.pruebatecnicakotlin.data.local.UsuarioEntity
import com.example.pruebatecnicakotlin.data.remote.ApiClient
import com.example.pruebatecnicakotlin.data.remote.LoginRequest
import com.example.pruebatecnicakotlin.data.remote.LoginResponse

class LoginRepository(
    private val context: Context
) {

    suspend fun login():
            Result<LoginResponse> {

        return try {

            val request = LoginRequest(
                Password = "SW50ZXIyMDIx\n",
                Usuario = "cGFtLm1lcmVkeTIx\n"
            )

            val response =
                ApiClient.apiService.login(

                    usuarioHeader = "pam.meredy21",

                    identificacion = "987204545",

                    idUsuario = "pam.meredy21",

                    idCentroServicio = "1295",

                    nombreCentroServicio =
                        "PTO/BOGOTA/CUND/COL/OF PRINCIPAL - CRA 30 # 7-45",

                    idAplicativoOrigen = "9",

                    request = request
                )

            if (response.isSuccessful) {

                val body = response.body()

                if (body != null) {

                    val usuario =
                        UsuarioEntity(

                            usuario =
                                body.Usuario,

                            identificacion =
                                body.Identificacion,

                            nombre =
                                body.Nombre
                        )

                    AppDatabase
                        .getDatabase(context)
                        .usuarioDao()
                        .insertUsuario(usuario)

                    Result.success(body)

                } else {

                    Result.failure(
                        Exception(
                            "Respuesta vacía"
                        )
                    )
                }

            } else {

                Result.failure(
                    Exception(
                        "Error HTTP ${response.code()}"
                    )
                )
            }

        } catch (e: Exception) {

            Result.failure(e)
        }
    }
}