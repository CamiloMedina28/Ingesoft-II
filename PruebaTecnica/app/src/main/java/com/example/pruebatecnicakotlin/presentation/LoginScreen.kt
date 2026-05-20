package com.example.pruebatecnicakotlin.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginScreen() {

    val viewModel: LoginViewModel =
        viewModel()

    val uiState by
    viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),

        verticalArrangement =
            Arrangement.Top,

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Text(
            text = "Prueba Técnica",
            style =
                MaterialTheme.typography.headlineMedium
        )

        Text(
            text = "Interrapidísimo"
        )

        if (uiState.isLoading) {

            CircularProgressIndicator(
                modifier =
                    Modifier.padding(top = 24.dp)
            )

        } else {

            Button(
                modifier =
                    Modifier.padding(top = 24.dp),

                onClick = {

                    viewModel.login()
                }
            ) {

                Text("Iniciar sesión")
            }
        }

        if (uiState.message.isNotEmpty()) {

            Text(
                modifier =
                    Modifier.padding(top = 24.dp),

                text = uiState.message
            )
        }
    }
}