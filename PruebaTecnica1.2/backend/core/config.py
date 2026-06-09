from pydantic_settings import BaseSettings

class Settings(BaseSettings):
    APP_VERSION: str

    class Config:
        env_file = ".env"

settings = Settings()