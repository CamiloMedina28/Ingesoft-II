from fastapi import APIRouter, HTTPException
from services.version_service import VersionService

router = APIRouter(
    prefix = "/version",
    tags=["Versiones"]
)

@router.get("/check")
def check_version():
    try:
        return VersionService.compare_versions()
    except Exception as e:
        raise HTTPException(
            status_code=500,
            detail=str(e)
        )
