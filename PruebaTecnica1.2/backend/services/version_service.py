import requests
from core.config import settings

class VersionService:

    VERSION_URL = (
        "https://apitesting.interrapidisimo.co/"
        "apicontrollerpruebas/api/ParametrosFramework/"
        "ConsultarParametrosFramework/VPStoreAppControl"
    )

    @staticmethod
    def compare_versions():
        try:
            response = requests.get(
                VersionService.VERSION_URL,
                timeout=15
            )
            response.raise_for_status()
            data = response.json()
            print(data)
            local_version = settings.APP_VERSION

            result = VersionService.evaluate_version(local_version, data)
            print(result)
            return result
        except requests.exceptions.Timeout:
            raise Exception(
                "Timeout al consultar servicio de versiones"
            )
        except requests.exceptions.ConnectionError:
            raise Exception(
                "No fue posible conectar con la API"
            )
        except Exception as e:
            raise Exception(str(e))


    @staticmethod
    def evaluate_version(local, remote):

        local_parts = list(map(int, local.split(".")))
        remote_parts = list(map(int, remote.split(".")))

        if local_parts < remote_parts:
            return "UPDATE_REQUIRED"

        if local_parts > remote_parts:
            return "LOCAL_VERSION_HIGHER"

        return "UP_TO_DATE"