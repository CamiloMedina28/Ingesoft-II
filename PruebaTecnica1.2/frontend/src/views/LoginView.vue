<script setup>
import { ref } from "vue";
import { FORM_CONFIG } from "@/config/appConfig";
import { login } from "@/services/authService";

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
    const response = await login(form.value);
    console.log(response);
  } catch (error) {
    console.error(error);
  }
};
</script>

<template>
  <div class="bg-blue-200 h-screen flex items-center justify-center">

    <div class="bg-white shadow-xl rounded-2xl p-8 w-full max-w-2xl">

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
