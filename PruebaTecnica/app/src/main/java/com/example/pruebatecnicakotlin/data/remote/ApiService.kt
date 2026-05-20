package com.example.pruebatecnicakotlin.data.remote
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST(
        "FtEntregaElectronica/MultiCanales/" +
                "ApiSeguridadPruebas/api/Seguridad/" +
                "AuthenticaUsuarioApp"
    )
    suspend fun login(

        @Header("Usuario")
        usuarioHeader: String,

        @Header("Identificacion")
        identificacion: String,

        @Header("Accept")
        accept: String = "text/json",

        @Header("IdUsuario")
        idUsuario: String,

        @Header("IdCentroServicio")
        idCentroServicio: String,

        @Header("NombreCentroServicio")
        nombreCentroServicio: String,

        @Header("IdAplicativoOrigen")
        idAplicativoOrigen: String,

        @Header("Content-Type")
        contentType: String = "application/json",

        @Body
        request: LoginRequest

    ): Response<LoginResponse>

    @GET(
        "apicontrollerpruebas/api/" +
                "ParametrosFramework/" +
                "ConsultarParametrosFramework/" +
                "VPStoreAppControl"
    )
    suspend fun getVersion():
            Response<String>

    @GET(
        "apicontrollerpruebas/api/" +
                "SincronizadorDatos/" +
                "ObtenerEsquema/true"
    )
    suspend fun getTablas():
            Response<List<TablaResponse>>

    @GET(
        "apicontrollerpruebas/api/" +
                "ParametrosFramework/" +
                "ObtenerLocalidadesRecogidas"
    )
    suspend fun getLocalidades():
            Response<List<LocalidadResponse>>
}