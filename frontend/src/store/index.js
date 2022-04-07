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
      missSearch: {
        happenPlace: "",
        kindCd: "",
        page: "",
      },
      shelSearch: {
        noticeSdt: "",
        noticeEdt: "",
        upKindCd : "",
        kindCd: "",
        neuterYn: "",
        careAddr: "",
        processState: "",
        page: "",
      },
      missDetailNo:"",
    },
    mutations:{ // set
      setShelSearch(state, payload){
        state.shelSearch.noticeSdt = payload.noticeSdt
        state.shelSearch.noticeEdt = payload.noticeEdt
        state.shelSearch.upKindCd = payload.upKindCd
        state.shelSearch.kindCd = payload.kindCd
        state.shelSearch.neuterYn = payload.neuterYn
        state.shelSearch.careAddr = payload.careAddr
        state.shelSearch.processState = payload.processState
        state.shelSearch.page = payload.page
      },
      setShelSearchNull(state){
        state.shelSearch.noticeSdt = ""
        state.shelSearch.noticeEdt = ""
        state.shelSearch.upKindCd = ""
        state.shelSearch.kindCd = ""
        state.shelSearch.neuterYn = ""
        state.shelSearch.careAddr = ""
        state.shelSearch.processState = ""
        state.shelSearch.page = ""
      },
      setMissSearch(state, payload){
        state.missSearch.happenPlace = payload.happenPlace
        state.missSearch.kindCd = payload.kindCd
        state.missSearch.page = payload.page
      },
      setMissSearchNull(state){
        state.missSearch.happenPlace = ""
        state.missSearch.kindCd = ""
        state.missSearch.page = ""
      },


      setMissDetailNo(state, payload){
        state.missDetailNo = payload
      },
      setMissDetailNoNull(state){
        state.missDetailNo = ""
      },
      setHaderindex(state, payload){
        state.haderindex = payload
      },
    },
    getters: {
      getMissSearch(state){
        return state.missSearch
      },
      getShelSearch(state){
        return state.shelSearch
      },
      getMissDetailNo(state){
        return state.missDetailNo
      },
      getHaderindex: function (state) {
        return state.haderindex;
    },
    },
    actions:{
      reset(){
        this.commit("setMissSearchNull")
        this.commit("setShelSearchNull")
        this.commit("setMissDetailNoNull")
      },
    }
  });
};

export default createStore;
// export default new Vuex.Store({
//   state: {},
//   mutations: {},
//   actions: {},
//   modules: {},
// });
