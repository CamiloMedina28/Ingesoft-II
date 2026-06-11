<script setup>
import { ref } from "vue";
import { FORM_CONFIG } from "@/config/appConfig";
import { login } from "@/services/authService";

const estado = ref(false);
const response = ref(null);

const form = ref({
    usuario: "",
    identificacion: "",
    idUsuario: "",
    nombreCentroServicio: "",
    idCentroServicio: ""
});

const autocompletar = () => {
     console.log(FORM_CONFIG);
  form.value = {
    usuario: FORM_CONFIG.usuario,
    identificacion: FORM_CONFIG.identificacion,
    idUsuario: FORM_CONFIG.idUsuario,
    nombreCentroServicio: FORM_CONFIG.nombreCentroServicio,
    idCentroServicio: FORM_CONFIG.idCentroServicio,
  };
};

const submitLogin = async () => {
  if (
      !form.value.usuario ||
      !form.value.identificacion ||
      !form.value.idUsuario ||
      !form.value.idCentroServicio ||
      !form.value.nombreCentroServicio
    ) {
      alert("Todos los campos son obligatorios");
      return;
    }

  try {
    response.value = await login(form.value);
    console.log(response);
    estado.value = true;
  } catch (error) {
    console.error(error);
  }

  const redirectTables = () => {
    router.push("/")
  };

};
</script>

<template>
  <div class="bg-blue-200 h-screen flex flex-col items-center justify-center">

  <div v-if="estado" class="w-full max-w-2xl mb-4">
    <div class="bg-blue-50 border border-blue-200 text-slate-800 rounded-xl p-4 dark:bg-blue-900/20 dark:border-blue-800" role="alert">
      <div class="flex items-start gap-x-3">
        <div class="shrink-0 text-blue-600 mt-0.5">
          <svg class="size-5" xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
            <circle cx="12" cy="12" r="10"/>
            <path d="M12 16v-4"/>
            <path d="M12 8h.01"/>
          </svg>
        </div>
        
        <div class="flex-1">
          <h3 class="font-semibold text-base text-slate-900">
            Inicio de sesión exitoso
          </h3>
          <p class="mt-1 text-sm text-slate-600">
            El código de estado fue: {{ response.codigo_estado }}
          </p>
          <p class="mt-1 text-sm text-slate-600">
            El usuario fue: {{ response.usuario }}
          </p>
          <p class="mt-1 text-sm text-slate-600">
            El jwt fue: {{ response.jwt }}
          </p>
          
          <div class="mt-3 flex gap-x-4">
<button 
    type="button" 
    v-on:click=""
    class="inline-flex items-center justify-center text-sm font-semibold rounded-lg border border-transparent text-blue-600 hover:text-blue-700 transition-colors focus:outline-none focus:text-blue-700 disabled:opacity-50 disabled:pointer-events-none"
  >
    Continuar
  </button>
          </div>
        </div>
      </div>
    </div>
  </div>

    <div v-else class="bg-white shadow-xl rounded-2xl p-8 w-full max-w-2xl">

      <h2 class="text-center text-3xl font-bold mb-8">
        Inicio de sesión
      </h2>

      <form @submit.prevent="submitLogin" class="space-y-5">

        <div>
          <label class="block text-sm font-medium mb-2">
            Usuario
          </label>

          <input
            v-model="form.usuario"
            type="text"
            class="w-full rounded-lg border border-gray-300 px-4 py-2 focus:ring-2 focus:ring-indigo-500 focus:outline-none"
          />
        </div>

        <div>
          <label class="block text-sm font-medium mb-2">
            Identificación
          </label>

          <input
            v-model="form.identificacion"
            type="text"
            class="w-full rounded-lg border border-gray-300 px-4 py-2 focus:ring-2 focus:ring-indigo-500 focus:outline-none"
          />
        </div>

        <div class="grid grid-cols-2 gap-4">

          <div>
            <label class="block text-sm font-medium mb-2">
              Id Usuario
            </label>

            <input
                v-model="form.idUsuario"
              type="text"
              class="w-full rounded-lg border border-gray-300 px-4 py-2 focus:ring-2 focus:ring-indigo-500 focus:outline-none"
            />
          </div>

          <div>
            <label class="block text-sm font-medium mb-2">
              Id Centro Servicio
            </label>

            <input
                v-model="form.idCentroServicio"
              type="text"
              class="w-full rounded-lg border border-gray-300 px-4 py-2 focus:ring-2 focus:ring-indigo-500 focus:outline-none"
            />
          </div>

        </div>

        <div>
          <label class="block text-sm font-medium mb-2">
            Nombre Centro Servicio
          </label>

          <input
            v-model="form.nombreCentroServicio"
            type="text"
            class="w-full rounded-lg border border-gray-300 px-4 py-2 focus:ring-2 focus:ring-indigo-500 focus:outline-none"
          />
        </div>

        <button
          type="submit"
          class="w-full bg-indigo-600 hover:bg-indigo-700 text-white font-medium py-3 rounded-lg transition">
          Iniciar sesión
        </button>

      </form>

      <button
        v-on:click="autocompletar"
        type="button"
        class="mt-4 w-full bg-gradient-to-r from-purple-600 to-blue-500 text-white py-3 rounded-lg">
        Autocompletar
      </button>

    </div>

  </div>
</template>
