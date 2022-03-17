import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");


import GAuth from 'vue-google-oauth2'
const gauthOption = {
  clientId: '1025867136323-tork23go3enda1v8h1kjdavencc76rcd.apps.googleusercontent.com',
  scope: 'profile email',
  prompt: 'select_account'
}
Vue.use(GAuth, gauthOption)

window.Kakao.init('21efe188094b9106e28c58dbaac6fe81');