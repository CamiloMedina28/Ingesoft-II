package com.example.pruebatecnicakotlin.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicakotlin.data.repository.TablasRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TablasViewModel : ViewModel() {

    private val repository =
        TablasRepository()

    private val _message =
        MutableStateFlow("")

    val message: StateFlow<String>
            = _message

    fun cargarTablas() {

        viewModelScope.launch {

            val result =
                repository.getTablas()

            result.onSuccess {

                _message.value =
                    "Tablas obtenidas correctamente"

            }.onFailure {

                _message.value =
                    it.message
                        ?: "Error desconocido"
            }
        }
    }
}