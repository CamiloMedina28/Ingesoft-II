package com.example.pruebatecnicakotlin.presentation.localidades

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicakotlin.data.remote.LocalidadResponse
import com.example.pruebatecnicakotlin.data.repository.LocalidadesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocalidadesViewModel : ViewModel() {

    private val repository =
        LocalidadesRepository()

    private val _localidades =
        MutableStateFlow<List<LocalidadResponse>>(
            emptyList()
        )

    val localidades:
            StateFlow<List<LocalidadResponse>>
            = _localidades

    fun cargarLocalidades() {

        viewModelScope.launch {

            val result =
                repository.getLocalidades()

            result.onSuccess {

                _localidades.value = it

            }.onFailure {

                _localidades.value = emptyList()
            }
        }
    }
}