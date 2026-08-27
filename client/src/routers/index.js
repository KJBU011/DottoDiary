import { createWebHistory, createRouter } from 'vue-router'; // npm i vue-router@next

// import Vue

import home from '../components/home/home.vue';
import growingcomment from '../components/growing/growingcomment.vue';
import grouphome from '../components/grouphome/grouphome.vue';


const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      name: 'home',

      component: home
    },
    {
      path: '/growingcomment',
      name: 'growingcomment',
      component: growingcomment
    },
    {
      path:'/grouphome',
      name:'grouphome',
      component:grouphome
    }

  ]
});
export default router;