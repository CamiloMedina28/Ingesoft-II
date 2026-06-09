import { createRouter, createWebHistory } from 'vue-router'
import VersionView from '@/views/VersionView.vue';
import LoginView from '@/views/LoginView.vue';

const routes = [
  {
    path: "/",
    component: VersionView
  },
  {
    path: "/login",
    component: LoginView
  },
];


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes
});

export default router
