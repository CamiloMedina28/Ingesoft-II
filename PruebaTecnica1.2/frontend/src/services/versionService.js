import api from "./api";
import { APP_CONFIG } from "@/config/appConfig";

export const checkVersion = async () => {
  const response = await api.get("/version/check", {
    params: {
      localVersion: APP_CONFIG.VERSION,
    },
  });

  return response.data;
};