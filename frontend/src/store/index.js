import Vue from "vue";
import Vuex from "vuex";
import login from "./modules/login";
import Main from "./modules/main";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

const createStore = () => {
  return new Vuex.Store({
    modules: {
      login,
      Main,
    },
    plugins: [
      createPersistedState({
        paths: ["login", "Main"],
      }),
    ],
  });
};

export default createStore;
// export default new Vuex.Store({
//   state: {},
//   mutations: {},
//   actions: {},
//   modules: {},
// });
