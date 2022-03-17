import Vue from "vue";
import Vuex from "vuex";
import login from "./modules/login";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

const createStore = () => {
  return new Vuex.Store({
    modules: {
      login,
    },
    plugins: [
      createPersistedState({
        paths: ["login"],
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
