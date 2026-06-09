from pydantic import BaseModel

class LoginRequest(BaseModel):
    usuario: str
    identificacion: str
    idUsuario: str
    idCentroServicio: str
    nombreCentroServicio: str