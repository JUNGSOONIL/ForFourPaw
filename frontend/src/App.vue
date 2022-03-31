<template>
  <div id="app">
    <loading v-if="isLoadingGetters"/>
    <header-bar id="headerbar"></header-bar>
    <router-view></router-view>
    <footer-bar id="footerbar"></footer-bar>
  </div>
</template>

<script>
import HeaderBar from "./views/HeaderBar.vue";
import FooterBar from "./views/FooterBar.vue";
import Loading from "./views/Loading.vue";

export default {
  name: "App",
  components: {
    HeaderBar,
    FooterBar,
    Loading,
  },
  computed: {
    isLoadingGetters(){
      return this.$store.getters["loading/isLoading"]
    }
  }
};
</script>

<style></style>
