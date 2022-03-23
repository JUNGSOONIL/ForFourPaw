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
import LogoutPage from "@/views/accounts/LogoutPage.vue";
import MoreInfo from "@/views/accounts/MoreInfo.vue";
import Analysis_Region from "@/views/analysis/Analysis_Region.vue";

export default new VueRouter({
  mode: "history",
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
      meta: {
        title: "ForFourPaw",
      },
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
      name: "KaKaoLogin",
      path: "/socialLogin/KaKaoLogin",
      component: () => import("@/views/accounts/KaKaoLogin.vue"),
      meta: {
        loginRequired: false,
        testRequired: false,
        title: "카카오로 로그인하기",
      },
    },

    {
      name: "LogoutPage",
      path: "/logoutPage",
      component: LogoutPage,
    },

    {
      name: "MoreInfo",
      path: "/moreInfo",
      component: MoreInfo,
    },

    {
      name: "Analysis_Region",
      path: "/Analysis_Region",
      component: Analysis_Region,
    },
  ],

  //페이지 이동시 유지되던 스크롤 위치를 맨위로 이동
  scrollBehavior() {
    return { x: 0, y: 0 };
  },
});
