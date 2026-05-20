package com.example.pruebatecnicakotlin.data.remote

data class LoginResponse(

    val Usuario: String? = null,

    val Identificacion: String? = null,

    val Nombre: String? = null,

    val Apellido1: String? = null,

    val Apellido2: String? = null,

    val Cargo: String? = null,

    val MensajeResultado: Int? = null,

    val TokenJWT: String? = null
)