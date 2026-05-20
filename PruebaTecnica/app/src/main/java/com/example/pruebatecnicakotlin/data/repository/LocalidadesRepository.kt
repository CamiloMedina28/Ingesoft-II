package com.example.pruebatecnicakotlin.data.repository

import com.example.pruebatecnicakotlin.data.remote.ApiClient
import com.example.pruebatecnicakotlin.data.remote.LocalidadResponse

class LocalidadesRepository {

    suspend fun getLocalidades():
            Result<List<LocalidadResponse>> {

        return try {

            val response =
                ApiClient.apiService
                    .getLocalidades()

            if (response.isSuccessful) {

                val body = response.body()

                if (body != null) {

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