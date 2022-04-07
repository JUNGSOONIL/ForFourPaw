<template>
  <div>
  </div>
</template>

<script>
import axios from "axios";

const session = window.sessionStorage;


export default {
  name: "KaKaoLogin",
  data: function () {
    return {
      credentials: {
        email: null,
        pw: null,
      },
      googleUser: null,
      kakaoOauthUrl: null,
    };
  },
  methods: {
    kakaoValidate() {
      const code = this.$route.query.code;
      axios({
        method: "post",
        url: "/api/login/oauth/kakao",
        data: code,
      })
        .then((res) => {
          // storage 설정
          session.setItem(
            "at-jwt-access-token",
            res.headers["at-jwt-access-token"]
          );
          session.setItem(
            "at-jwt-refresh-token",
            res.headers["at-jwt-refresh-token"]
          );

          this.$store.dispatch("login/allTokenRefresh", res);
          this.$store.commit("login/SET_LOGIN");
          this.sendToken();
          const info = this.$store.getters["login/userInfo"];
          if (info.addrs === null) {
            this.$router.push("/moreInfo");
          } else {
            // this.$store.commit("loginConfirmModalActivate");
            this.$router.push("/");
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },

    sendToken() {

    },
  },
  created: function () {
    this.kakaoValidate();
  },
};
</script>
