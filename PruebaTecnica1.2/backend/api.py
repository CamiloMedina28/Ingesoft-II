from fastapi import FastAPI
from routers.version_router import router as version_router

app = FastAPI()

app.include_router(version_router)