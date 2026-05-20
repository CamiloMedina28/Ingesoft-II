package com.example.pruebatecnicakotlin.data.repository

import com.example.pruebatecnicakotlin.data.remote.ApiClient

class VersionRepository {

    suspend fun getVersion():
            Result<String> {

        return try {

            val response =
                ApiClient.apiService.getVersion()

            if (response.isSuccessful) {

                val body = response.body()

                if (body != null) {

                    Result.success(body)

                } else {

                    Result.failure(
                        Exception("Body vacío")
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