import Vue from "vue";
import Vuex from "vuex";
import login from "./modules/login";
import mainView from "./modules/mainView";
import loading from "./modules/loading";
import shelView from "./modules/ShelView";
import createPersistedState from "vuex-persistedstate";


Vue.use(Vuex);

const createStore = () => {
  return new Vuex.Store({
    modules: {
      login,
      mainView,
      loading,
      shelView,
    },
    plugins: [
      createPersistedState({
        paths: ["login", "mainView", "loading", "shelView"],
      }),
    ],
    state: {
      haderindex: 0,
    },
    mutations:{
      setHaderindex(state, payload){
        state.haderindex = payload
      },
    },
    getters: {
      getHaderindex: function (state) {
        return state.haderindex;
    },
    },
  });
};

export default createStore;
// export default new Vuex.Store({
//   state: {},
//   mutations: {},
//   actions: {},
//   modules: {},
// });
