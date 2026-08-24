import { createWebHistory, createRouter } from 'vue-router'; // npm i vue-router@next

// import Vue
import Home from '../components/home/home.vue';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    }
  ]
});
export default router;