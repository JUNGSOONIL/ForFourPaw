<template>
              <div class="section-title text-center" style="display: flex; justify-content: center; align-items:center; min-height: 100vh;">
                <div>
                  <div class="">
                    <img src="/img/logo/paw_logo_3line.png" alt="" id="LoginLogo" />
                  </div>
                  <div class="comment-reply-box" style="margin:0px; width:400px; height:360px; display: inline-block;">
                    <h3 style="margin:0px; margin-bottom:30px">For Four Paw에 <br>오신 걸 환영합니다.🐾</h3>

                    <div class="d-flex justify-content-center">
                      <div class="google-btn btn-block" @click="handleClickSignIn">
                        <div class="google-icon-wrapper btn-block">
                          <img
                            class="google-icon-svg"
                            src="https://upload.wikimedia.org/wikipedia/commons/5/53/Google_%22G%22_Logo.svg"
                          />
                        </div>
                        <p class="btn-text"><b>Sign in with Google</b></p>
                      </div>
                    </div>
                    <div>
                      <img
                        class="kakao-btn"
                        src="/img/kakao_login_medium_narrow.png"
                        @click="handleClickKaKaoSignin"
                      />
                    </div>
                  </div>
                </div>
            </div>
</template>

<script>
import axios from "axios";

const session = window.sessionStorage;

export default {
  name: "SocialLogin",
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
  computed: {
    isLoginGetters() {
      return session.getItem("userInfo");
      // return this.$store.getters["login/isLogin"];
    },
  },
  methods: {
    login: function () {
      this.$store.commit("login/SET_LOGIN");
    },
    //OAUTH-google
    async handleClickSignIn() {
      try {
        const googleUser = await this.$gAuth.signIn();
        if (!googleUser) {
          return null;
        }
        this.isSignIn = this.$gAuth.isAuthorized;
        this.onSuccess(googleUser);
        this.login();
      } catch (error) {
        //on fail do something
        this.onFailure(error);
      }
    },
    onSuccess(googleUser) {
      // eslint-disable-next-line
      this.googleUser = googleUser;
      this.tokenVerify();
    },
    onFailure(error) {
      // eslint-disable-next-line
      console.log(error);
    },
    tokenVerify() {
      const url = "/api/login/oauth/google";
      const params = new URLSearchParams();
      params.append("idToken", this.googleUser.wc.id_token);
      axios
        .post(url, params)
        .then((res) => {
          // alert("로그인 성공")
          this.$store.dispatch("login/allTokenRefresh", res);
          this.sendToken();
          const info = this.$store.getters["login/userInfo"];
          if (info.addrs === null) {
            this.$router.push("/moreInfo");
          } else {
            //로그인기능 수행 라우팅
            //this.$store.commit('loginConfirmModalActivate')
            this.$router.push("/");
          }
        })
        .catch((error) => {
          console.log(error);
          // this.$store.commit('loginFailModalActivate')
        });
    },

    handleClickKaKaoSignin() {
      const params = {
        redirectUri: "https://j6e105.p.ssafy.io/socialLogin/KaKaoLogin",
        //redirectUri: "http://localhost:5500/socialLogin/KaKaoLogin",
      };
      window.Kakao.Auth.authorize(params);
    },

    sendToken() {

    },
  },
};
</script>

<style scoped>
.kakao-btn {
  margin: 15px;
  width: 80%;
  min-width: 184px;
  max-width: 184px;
  border-radius: 2px;
  box-shadow: 0 3px 4px 0 rgba(0, 0, 0, 0.2);
  cursor: pointer;
  cursor: hand;
  align-self: center;
  user-select: none;
  transition: all 400ms ease 0s;
}

.kakao_btn:hover {
  box-shadow: 0 3px 8px rgba(117, 117, 117, 0.5);
  user-select: none;
}
.kakao-btn:active {
  box-shadow: 0 1px 1px #757575;
  background: #f8f8f8;
  color: #fff;
  user-select: none;
}
#LoginLogo {
  height: 300px;
}
</style>
