import requests

class LoginService:
    URL = (
        "https://apitesting.interrapidisimo.co/"
        "FtEntregaElectronica/MultiCanales/"
        "ApiSeguridadPruebas/api/Seguridad/"
        "AuthenticaUsuarioApp"
    )

    @staticmethod
    def login(data):
        headers = {
            "Usuario": data.usuario,
            "Identificacion": data.identificacion,
            "Accept": "text/json",
            "IdUsuario": data.idUsuario,
            "IdCentroServicio": data.idCentroServicio,
            "NombreCentroServicio": data.nombreCentroServicio,
            "IdAplicativoOrigen": "9",
            "Content-Type": "application/json"
        }

        payload = {
            "Mac": "",
            "NomAplicacion": "Controller APP",
            "Password": "SW50ZXIyMDIx\n",
            "Path": "",
            "Usuario": "cGFtLm1lcmVkeTIx\n"
        }

        response = requests.post(
            LoginService.URL,
            headers=headers,
            json=payload,
            timeout=30
        )

        codigo = response.status_code

        try:
            data = response.json()
            if codigo != 200:
                raise ValueError("Wrong status code")

            usuario = data['Usuario']
            jwt = data['TokenJWT']

            return {"codigo_estado": str(codigo),
                    "error": "",
                    "usuario": usuario,
                    "jwt": str(jwt) if jwt else ""}
        except ValueError:
            return {"codigo_estado": str(codigo),
                    "error": "Error de código HTTP"}
        except Exception as e:
            return {"codigo_estado": str(codigo),
                    "error": "Error inesperado"}