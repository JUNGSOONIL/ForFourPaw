import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

import Main from "@/views/Main.vue";
import ShelList from "@/views/ShelList.vue";
import MissDetail from "@/views/MissDetail.vue";
import ShelDetail from "@/views/ShelDetail.vue";
import MissWrite from "@/views/MissWrite.vue";
import SocialLogin from "@/views/accounts/SocialLogin.vue";
import LogoutPage from "@/views/accounts/LogoutPage.vue";
import MoreInfo from "@/views/accounts/MoreInfo.vue";
import AnalysisView from "@/views/analysis/AnalysisView.vue";
import MissList from "@/views/MissList.vue";
import UserPage from "@/views/UserPage.vue";
import KaKaoLogin from "@/views/accounts/KaKaoLogin.vue";

export default new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/",
      component: Main,
    },

    {
      name: "ShelList",
      path: "/shelList",
      component: ShelList,
    },

    {
      name: "MissList",
      path: "/missList",
      component: MissList,
    },

    {
      name: "MissDetail",
      path: "/missDetail",
      component: MissDetail,
      props: true,
    },

    {
      name: "ShelDetail",
      path: "/shelDetail",
      component: ShelDetail,
      props: true,
    },

    {
      name: "MissWrite",
      path: "/missWrite",
      component: MissWrite,
      props: true,
    },

    {
      name: "UserPage",
      path: "/userPage",
      component: UserPage,
    },

    {
      name: "SocialLogin",
      path: "/socialLogin",
      component: SocialLogin,
    },

    {
      name: "KaKaoLogin",
      path: "/socialLogin/KaKaoLogin",
      component: KaKaoLogin,
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
      props: true,
    },

    {
      name: "MoreInfo",
      path: "/moreInfo",
      component: MoreInfo,
    },
    {
      name: "AnalysisView",
      path: "/AnalysisView",
      component: AnalysisView,
    },
  ],

  //페이지 이동시 유지되던 스크롤 위치를 맨위로 이동
  scrollBehavior() {
    return { x: 0, y: 0 };
  },
});
