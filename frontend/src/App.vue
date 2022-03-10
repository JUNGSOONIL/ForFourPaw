<template>
  <div id="app">
    <header-bar id="headerbar"></header-bar>
    <router-view></router-view>
    <footer-bar id="footerbar"></footer-bar>
  </div>
</template>

<script>
import HeaderBar from "./views/HeaderBar.vue";
import FooterBar from "./views/FooterBar.vue";

export default {
  name: "App",
  components: {
    HeaderBar,
    FooterBar,
  },
};
</script>


<style>

</style>
