import { createWebHistory, createRouter } from 'vue-router'; // npm i vue-router@next

// import Vue

import home from '../components/home/home.vue';
import growingcomment from '../components/growing/growingcomment.vue';
import grouphome from '@/components/grouphome/grouphome.vue';
import regi from '@/components/Users/regi.vue';
import login from '@/components/Users/login.vue';
import diarieslist from '../components/DiariesList/DiariesList.vue';


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
    {
      path: '/diaries',
      name:'diaries',
      component: diarieslist
    }
  ]
});
export default router;