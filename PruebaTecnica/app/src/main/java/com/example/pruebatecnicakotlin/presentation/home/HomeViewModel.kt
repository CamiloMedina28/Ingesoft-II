package com.example.pruebatecnicakotlin.presentation.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicakotlin.data.repository.HomeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository =
        HomeRepository(application)

    private val _uiState =
        MutableStateFlow(HomeUiState())

    val uiState: StateFlow<HomeUiState>
            = _uiState

    fun cargarUsuario() {

        viewModelScope.launch {

            val usuario =
                repository.getUsuario()

            if (usuario != null) {

                _uiState.value =
                    HomeUiState(

                        usuario =
                            usuario.usuario ?: "",

                        identificacion =
                            usuario.identificacion
                                ?: "Sin identificación",

                        nombre =
                            usuario.nombre
                                ?: "Sin nombre"
                    )
            }
        }
    }
}