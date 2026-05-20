package com.example.pruebatecnicakotlin.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebatecnicakotlin.data.repository.LoginRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    application: Application
) : AndroidViewModel(application) {

    private val repository =
        LoginRepository(application)

    private val _uiState =
        MutableStateFlow(LoginUiState())

    val uiState: StateFlow<LoginUiState>
            = _uiState

    fun login() {

        viewModelScope.launch {

            _uiState.value =
                _uiState.value.copy(
                    isLoading = true
                )

            val result =
                repository.login()

            result.onSuccess {

                _uiState.value =
                    LoginUiState(
                        isLoading = false,
                        message =
                            "Login exitoso y guardado"
                    )

            }.onFailure {

                _uiState.value =
                    LoginUiState(
                        isLoading = false,
                        message =
                            it.message
                                ?: "Error desconocido"
                    )
            }
        }
    }
}