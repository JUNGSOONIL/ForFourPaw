import Vue from "vue";
import Vuex from "vuex";
import login from "./modules/login";
import mainView from "./modules/mainView";
import createPersistedState from "vuex-persistedstate";

Vue.use(Vuex);

const createStore = () => {
  return new Vuex.Store({
    modules: {
      login,
      mainView,
    },
    plugins: [
      createPersistedState({
        paths: ["login", "mainView"],
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
