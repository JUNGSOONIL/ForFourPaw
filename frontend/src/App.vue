<template>
  <div id="app">
    <loading v-if="isLoadingGetters" />
    <header-bar
      v-if="
        !(
          $route.name === 'SocialLogin' ||
          $route.name === 'LogoutPage' ||
          $route.name === 'MoreInfo' ||
          $route.name === 'KaKaoLogin' 
        )
      "
      id="headerbar"
    ></header-bar>
    <router-view></router-view>
    <footer-bar
      v-if="
        !(
          $route.name === 'SocialLogin' ||
          $route.name === 'LogoutPage' ||
          $route.name === 'MoreInfo' ||
          $route.name === 'KaKaoLogin'
        )
      "
      id="footerbar"
    ></footer-bar>
  </div>
</template>

<script>
import HeaderBar from "./views/HeaderBar.vue";
import FooterBar from "./views/FooterBar.vue";
import Loading from "./views/Loading.vue";
const session = window.sessionStorage;
export default {
  name: "App",
  components: {
    HeaderBar,
    FooterBar,
    Loading,
  },
  computed: {
    isLoadingGetters() {
      return this.$store.getters["loading/isLoading"];
    },
  },
  methods: {
    isSession() {
      return session.getItem("userInfo");
    },
  },
};
</script>

<style>
#app {
    font-family: 'RFR', sans-serif !important;
}
@font-face {
  font-family: "RFR";
  src: url("assets/fonts/EliceDigitalRegular.ttf");
}
</style>
