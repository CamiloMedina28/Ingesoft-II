from fastapi import APIRouter, HTTPException
from services.login_service import LoginService
from models.loginmodel import LoginRequest

router = APIRouter(
    prefix = "/auth",
    tags=["Autenticación"]
)

@router.post("/login")
def login_to_api(data: LoginRequest):
    response = LoginService.login(data)


    return response