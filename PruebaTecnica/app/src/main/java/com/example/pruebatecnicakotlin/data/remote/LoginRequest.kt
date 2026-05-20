package com.example.pruebatecnicakotlin.data.remote

data class LoginRequest(

    val Mac: String = "",

    val NomAplicacion: String =
        "Controller APP",

    val Password: String,

    val Path: String = "",

    val Usuario: String
)