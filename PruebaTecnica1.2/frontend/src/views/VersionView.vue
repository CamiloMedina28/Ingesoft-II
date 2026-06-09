<script setup>
import { ref, onMounted } from "vue";
import { checkVersion } from "@/services/versionService";
import { useRouter } from "vue-router";

const router = useRouter();

const message = ref("");
const localVersion = ref("");
const remoteVersion = ref("");

const messages = {
  UPDATE_REQUIRED: "Existe una nueva versión disponible",
  UP_TO_DATE: "La aplicación está actualizada",
  LOCAL_VERSION_HIGHER: "La versión local es superior"
};
const color = {
  UPDATE_REQUIRED: "bg-red-100 text-red-800 border-red-300",
  UP_TO_DATE: "bg-green-100 text-green-800 border-green-300",
  LOCAL_VERSION_HIGHER: "bg-blue-100 text-blue-800 border-blue-300"
};

const redirectLogin = () => {
    router.push("/login")
};

onMounted(async () => {
  try {
    const response = await checkVersion();

    message.value = response.message;
    localVersion.value = response.localVersion;
    remoteVersion.value = response.remoteVersion;

  } catch (error) {
    console.log(error);
    message.value = "Error consultando la versión";
  }
});
</script>


<template>
<div class="py-50 bg-blue-200 min-h-screen flex flex-col items-center justify-center gap-3">
    <div class="bg-white shadow-lg rounded-xl p-6" flex flex-col>

        <h1 class="text-xl font-bold mb-4">
            <span class="text-transparent bg-clip-text bg-gradient-to-r to-emerald-600 from-sky-400">Control de Versiones</span>
            🚀
        </h1>

        <div class="p-4 mb-4 text-sm rounded-lg border" :class="color[message]" role="alert">
            <span class="font-medium">
                {{ message }}
            </span>

            {{ messages[message] }}
        </div>


      <div class=" flex flex-row justify-around">
        <div class="flex flex-col items-center">
            <h4 class="text-2xl font-bold text-heading">Local</h4>
            <p>{{ localVersion }}</p>
        </div>

        <div class="flex flex-col items-center">
            <h4 class="text-2xl font-bold text-heading">Servidor</h4>
            <p> {{ remoteVersion }}</p>
        </div>
      </div>

      



    </div>
    <button type="button" v-on:click="redirectLogin" class="text-white rounded-md bg-gradient-to-r from-cyan-500 to-blue-500 hover:bg-gradient-to-bl focus:ring-4 focus:outline-none focus:ring-cyan-300 dark:focus:ring-cyan-800 font-medium rounded-base text-sm px-4 py-2.5 text-center leading-5">Iniciar sesión</button>

</div>
</template>