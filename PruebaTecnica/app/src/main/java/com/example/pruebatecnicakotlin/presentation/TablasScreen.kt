package com.example.pruebatecnicakotlin.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
fun TablasScreen() {

    val viewModel:
            TablasViewModel = viewModel()

    val message by
    viewModel.message.collectAsState()

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
            text = "Capa Datos",
            style =
                MaterialTheme.typography.headlineMedium
        )

        Button(
            modifier =
                Modifier.padding(top = 24.dp),

            onClick = {

                viewModel.cargarTablas()
            }
        ) {

            Text("Cargar tablas")
        }

        if (message.isNotEmpty()) {

            Text(
                modifier =
                    Modifier.padding(top = 24.dp),

                text = message
            )
        }
    }
}