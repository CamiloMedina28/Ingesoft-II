package com.example.pruebatecnicakotlin

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pruebatecnicakotlin.presentation.VersionViewModel
import com.example.pruebatecnicakotlin.presentation.home.HomeScreen
import com.example.pruebatecnicakotlin.ui.theme.PruebaTecnicaKotlinTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            PruebaTecnicaKotlinTheme {

                val versionViewModel:
                        VersionViewModel = viewModel()

                val localVersion =
                    BuildConfig.VERSION_NAME

                LaunchedEffect(Unit) {

                    versionViewModel
                        .validateVersion(
                            localVersion
                        )

                    versionViewModel
                        .message
                        .collect {

                            if (it.isNotEmpty()) {

                                Toast.makeText(
                                    this@MainActivity,
                                    it,
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }
                }

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),

                    verticalArrangement =
                        Arrangement.Top
                ) {

                    HomeScreen()
                }
            }
        }
    }
}