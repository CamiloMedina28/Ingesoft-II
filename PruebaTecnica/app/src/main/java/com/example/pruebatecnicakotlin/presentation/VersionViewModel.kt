package com.example.pruebatecnicakotlin.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicakotlin.data.repository.VersionRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class VersionViewModel : ViewModel() {

    private val repository =
        VersionRepository()

    private val _message =
        MutableStateFlow("")

    val message: StateFlow<String>
            = _message

    fun validateVersion(
        localVersion: String
    ) {

        viewModelScope.launch {

            val result =
                repository.getVersion()

            result.onSuccess { remoteVersion ->

                _message.value =
                    compareVersions(
                        localVersion,
                        remoteVersion
                    )

            }.onFailure {

                _message.value =
                    it.message ?: "Error desconocido"
            }
        }
    }

    private fun compareVersions(
        local: String,
        remote: String
    ): String {

        return when {

            local < remote ->
                "La aplicación está desactualizada"

            local > remote ->
                "La versión local es superior"

            else ->
                "La aplicación está actualizada"
        }
    }
}