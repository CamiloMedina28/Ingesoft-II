package com.example.pruebatecnicakotlin.data.repository

import com.example.pruebatecnicakotlin.data.remote.ApiClient
import com.example.pruebatecnicakotlin.data.remote.TablaResponse

class TablasRepository {

    suspend fun getTablas():
            Result<List<TablaResponse>> {

        return try {

            val response =
                ApiClient.apiService.getTablas()

            if (response.isSuccessful) {

                val body = response.body()

                if (body != null) {

                    Result.success(body)

                } else {

                    Result.failure(
                        Exception("Respuesta vacía")
                    )
                }

            } else {

                Result.failure(
                    Exception(
                        when(response.code()) {

                            401 ->
                                "Error HTTP 401 - No autorizado"

                            else ->
                                "Error HTTP ${response.code()}"
                        }
                    )
                )
            }

        } catch (e: Exception) {

            Result.failure(e)
        }
    }
}