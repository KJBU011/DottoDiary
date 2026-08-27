import { createWebHistory, createRouter } from 'vue-router'; // npm i vue-router@next

// import Vue
import Home from '../components/home/home.vue';
import Home2 from '../components/home/home2.vue';
import regi from '@/components/Users/regi.vue';
import login from '@/components/Users/login.vue';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home
    },

    {
      path: '/regi',
      name: 'regi',
      component: regi
    },

    {
      path: '/login',
      name: 'login',
      component: login
    },
  ]
});
export default router;