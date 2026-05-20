package com.example.pruebatecnicakotlin.presentation.localidades

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LocalidadesScreen() {

    val viewModel:
            LocalidadesViewModel = viewModel()

    val localidades by
    viewModel.localidades.collectAsState()

    LaunchedEffect(Unit) {

        viewModel.cargarLocalidades()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement =
            Arrangement.Top
    ) {

        Text(
            text = "LOCALIDADES",
            style =
                MaterialTheme.typography.headlineMedium
        )

        LazyColumn {

            items(localidades) { localidad ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                ) {

                    Column(
                        modifier =
                            Modifier.padding(16.dp)
                    ) {

                        Text(
                            text =
                                "Abreviación: ${
                                    localidad.AbreviacionCiudad
                                }"
                        )

                        Text(
                            text =
                                "Ciudad: ${
                                    localidad.NombreCorto
                                }"
                        )

                        Text(
                            text =
                                "Nombre completo: ${
                                    localidad.NombreCompleto
                                }"
                        )
                    }
                }
            }
        }
    }
}