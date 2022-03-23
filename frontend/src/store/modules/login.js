const state = {
  isLogin: false,
};

// getters
const getters = {
  isLogin: function (state) {
    return state.isLogin;
  },
};

// mutations
const mutations = {
  SET_LOGIN: (state) => {
    state.isLogin = true;
    console.log("setlogin, isLogin : " + state.isLogin);
  },
  SET_LOGOUT: (state) => {
    state.isLogin = false;
    console.log("setlogout, isLogin : " + state.isLogin);
  },
};

// actions
const actions = {};

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions,
};
