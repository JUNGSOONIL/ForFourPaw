import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

import Main from "@/views/Main.vue";
import Shop from "@/views/Shop.vue";
import ShopDetail from "@/views/ShopDetail.vue";
import DogList from "@/views/DogList.vue";
import BlogDetail from "@/views/BlogDetail.vue";
import Blog from "@/views/Blog.vue";
import SocialLogin from "@/views/accounts/SocialLogin.vue";
import Analysis_Region from "@/views/analysis/Analysis_Region.vue";


export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: "/",
      component: Main,
     
    },

    {
      name: "Shop",
      path: "/shop",
      component: Shop,
    },

    {
      name: "ShopDetail",
      path: "/shopDetail",
      component: ShopDetail,
    },

    {
      name: "DogList",
      path: "/dogList",
      component: DogList,
      meta :{
        title : 'ForFourPaw'
      }
    },

    {
      name: "Blog",
      path: "/blog",
      component: Blog,
    },

    {
      name: "BlogDetail",
      path: "/blogDetail",
      component: BlogDetail,
    },

    {
      name: "SocialLogin",
      path: "/socialLogin",
      component: SocialLogin,
    },

    {
      name: 'KaKaoLogin',
      path: '/KaKaoLogin',
      component: () => import ('@/views/accounts/KaKaoLogin.vue'),
      meta: {
        loginRequired: false,
        testRequired: false,
        title: '카카오로 로그인하기'
      }
    },

    {
      name: "Analysis_Region",
      path: "/Analysis_Region",
      component: Analysis_Region,
    },


  ],
});
