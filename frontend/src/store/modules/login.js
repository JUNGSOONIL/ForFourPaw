import jwt_decode from "jwt-decode";

const session = window.sessionStorage;

const state = {
  isLogin: false,

  // 내정보
  userInfo: null,
};

// getters
const getters = {
  isLogin: function (state) {
    return state.isLogin;
  },
  userInfo: function (state) {
    return state.userInfo;
  },
};

// mutations
const mutations = {
  SET_LOGIN: (state) => {
    state.isLogin = true;
  },
  SET_LOGOUT: (state) => {
    state.isLogin = false;
  },
  userUpdate(state, payload) {
    if (!session.getItem("userInfo")) {
      session.setItem("userInfo", JSON.stringify(payload.userInfo)); //토큰값으로 들어오면
    } else if (session.getItem("userInfo")) {

      session.setItem("userInfo", JSON.stringify(payload.userInfo));
    }

    state.userInfo = JSON.parse(session.getItem("userInfo"));
  },

  tokenTest() {

  },
};

// actions
const actions = {
  // 엑세스 토큰 갱신
  accessTokenRefresh({ commit }, res) {
    if (
      res.headers["at-jwt-access-token"] !=
      session.getItem("at-jwt-access-token")
    ) {
      session.setItem("at-jwt-access-token", "");
      session.setItem(
        "at-jwt-access-token",
        res.headers["at-jwt-access-token"]
      );
    }
    commit("tokenTest");
  },

  // 유저 정보, 엑세스 토큰 갱신
  accessTokenRefreshOnUserInfo({ commit }, res) {
    // 유저 정보 갱신할때 사용
    session.setItem("at-jwt-access-token", res.headers["at-jwt-access-token2"]);
    const decodeAccessToken = jwt_decode(
      res.headers["at-jwt-access-token2"]
    );
    commit("userUpdate", decodeAccessToken);
  },

  // 토큰 전체 갱신
  allTokenRefresh({ commit }, res) {
    session.setItem("at-jwt-access-token", res.headers["at-jwt-access-token"]);
    session.setItem(
      "at-jwt-refresh-token",
      res.headers["at-jwt-refresh-token"]
    );

    const decodeAccessToken = jwt_decode(
      res.headers["at-jwt-access-token"]
    );
    commit("userUpdate", decodeAccessToken);

    return new Promise((resolve) => {
      resolve(true);
    });
  },
};

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions,
};
