const state = {
    loading: false,
};

// getters
const getters = {
    isLoading: function (state) {
        return state.loading;
    },
};

// mutations
const mutations = {
    load(state, payload){
        state.loading = payload
    },
};

// actions
const actions = {
  
};

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions,
};
