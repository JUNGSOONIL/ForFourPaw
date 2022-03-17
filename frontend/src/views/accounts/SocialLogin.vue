<template>
  <div>
    <!-- adoption-shop-area -->
    <section class="adoption-shop-area">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-xl-7 col-lg-9">
            <div class="section-title text-center mb-65">
              <div class="">
                <img src="img/logo/paw_logo_3line.png" alt="" id="LoginLogo" />
              </div>
              <!-- <h5 class="sub-title">Welcome</h5>
              <h2 class="title">Puppies Waiting for Adoption</h2>
              <p>
                The best overall dog DNA test is Embark Breed & Health Kit (view
                at Chewy), which provides you with a breed brwn and information
                Most dogs
              </p> -->
              <div class="comment-reply-box">
                <h5 class="title">For Four Paw에 오신 걸 환영합니다.</h5>

                <!-- OAuth 로그인 양식 맞춰서 만들기 빡세누.... -->
                <!-- <div class="g-signin2">로그인</div> -->
                <div>
                  <button type="button" class="btn btn-outline-primary" @click="handleClickSignIn">
                    구글
                  </button>
                </div>
                <div>
                  <button type="button" class="btn btn-outline-primary" @click="handleClickKaKaoSignin">
                    카카오
                  </button>
                </div>

                <!-- <form action="#" class="comment-reply-form">
                  <div class="row">
                    <div class="col-md-6">
                      <div class="form-grp">
                        <input type="text" placeholder="Author *" />
                      </div>
                    </div>
                    <div class="col-md-6">
                      <div class="form-grp">
                        <input type="email" placeholder="Your Email *" />
                      </div>
                    </div>
                  </div>
                  <div class="form-grp">
                    <textarea
                      name="message"
                      placeholder="Type Comment Here..."
                    ></textarea>
                  </div>
                  <div class="form-grp checkbox-grp">
                    <input type="checkbox" id="checkbox" />
                    <label for="checkbox">Don’t show your email address</label>
                  </div>
                  <button type="submit" class="btn">Submit now</button>
                </form> -->
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'SocialLogin',
  data: function () {
    return {
      credentials: {
        email: null, 
        pw: null,
      },
      googleUser: null,
      kakaoOauthUrl: null,
    }
  },
  methods: {
    //OAUTH-google
    async handleClickSignIn() {
      try {
        const googleUser = await this.$gAuth.signIn();
        if (!googleUser) {
          return null;
        }
        console.log("googleUser", googleUser);
        console.log("getId", googleUser.getId());
        console.log("getBasicProfile", googleUser.getBasicProfile());
        console.log("getAuthResponse", googleUser.getAuthResponse());
        console.log(
          "getAuthResponse",
          this.$gAuth.GoogleAuth.currentUser.get().getAuthResponse()
        );
        this.isSignIn = this.$gAuth.isAuthorized;
        this.onSuccess(googleUser)
      } catch (error) {
        //on fail do something
        this.onFailure(error)
      }
    },
    onSuccess(googleUser) {
      // eslint-disable-next-line
      console.log(googleUser);
      this.googleUser = googleUser;
      this.tokenVerify()
    },
    onFailure(error) {
      // eslint-disable-next-line
      console.log(error);
    },
    tokenVerify() {
      const url = 'http://localhost:8080/api/login/oauth/google';
      const params = new URLSearchParams();
      params.append('idToken', this.googleUser.wc.id_token);
      console.log('idtoken : ' + this.googleUser.wc.id_token)
      axios.post(url, params).then((res) => {
        // alert("로그인 성공")
        console.log(res.headers);
        // this.$store.dispatch('allTokenRefresh', res)
        //console.log(this.$store.state.userInfo.email)
        this.sendToken();
        // if (this.$store.state.userInfo.tel === null) {
        //   this.$router.push('/moreInfo')
        // }
        // else{
        //   //this.$store.commit('loginConfirmModalActivate')
        //   // this.$router.push('EmotionTest')
        //}
      }).catch((error) => {
        console.log(error);
        // this.$store.commit('loginFailModalActivate')
      })
    },
    
     handleClickKaKaoSignin() {
      const params = {
          //redirectUri: "https://i6e203.p.ssafy.io/login/KaKaoLogin",
          redirectUri: "http://localhost:5500/socialLogin/KaKaoLogin",
      };
      window.Kakao.Auth.authorize(params);
    },

  }


};
</script>

<style scoped>
#LoginLogo {
  height: 300px;
}
</style>
