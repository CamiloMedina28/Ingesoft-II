package com.example.pruebatecnicakotlin.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pruebatecnicakotlin.presentation.TablasViewModel
import com.example.pruebatecnicakotlin.presentation.localidades.LocalidadesScreen

@Composable
fun HomeScreen() {

    val homeViewModel:
            HomeViewModel = viewModel()

    val tablasViewModel:
            TablasViewModel = viewModel()

    val uiState by
    homeViewModel.uiState.collectAsState()

    val tablasMessage by
    tablasViewModel.message.collectAsState()

    var mostrarLocalidades by remember {

        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {

        homeViewModel.cargarUsuario()
    }

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
            text = "HOME",
            style =
                MaterialTheme.typography.headlineMedium
        )

        Spacer(
            modifier =
                Modifier.height(24.dp)
        )

        Text(
            text =
                "Usuario: ${uiState.usuario}"
        )

        Text(
            text =
                "Identificación: ${uiState.identificacion}"
        )

        Text(
            text =
                "Nombre: ${uiState.nombre}"
        )

        Spacer(
            modifier =
                Modifier.height(24.dp)
        )

        Button(
            onClick = {

                tablasViewModel.cargarTablas()
            }
        ) {

            Text("TABLAS")
        }

        if (tablasMessage.isNotEmpty()) {

            Spacer(
                modifier =
                    Modifier.height(16.dp)
            )

            Text(
                text = tablasMessage
            )
        }

        Spacer(
            modifier =
                Modifier.height(24.dp)
        )

        Button(
            onClick = {

                mostrarLocalidades = true
            }
        ) {

            Text("LOCALIDADES")
        }

        if (mostrarLocalidades) {

            Spacer(
                modifier =
                    Modifier.height(24.dp)
            )

            LocalidadesScreen()
        }
    }
}