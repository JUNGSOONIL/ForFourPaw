<template>
  <div>
    <h1>카카오 리다이렉트 페이지</h1>
  </div>
</template>

<script>
import axios from 'axios'

const session = window.sessionStorage;
import VueJwtDecode from 'vue-jwt-decode'


export default {
  name: 'KaKaoLogin',
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

    kakaoValidate() {
        const code = this.$route.query.code
        console.log("카카오로그인 시작")
        axios({
            method: 'post',
            url: '/api/login/oauth/kakao',
            data: code
        }).then((res) => {
            console.log('카카오 데이터 받아오기 : ' + res.data.email)
            console.log(res.headers);
            // storage 설정
            session.setItem('at-jwt-access-token', res.headers['at-jwt-access-token']);
            session.setItem('at-jwt-refresh-token', res.headers['at-jwt-refresh-token']);

            this.$store.dispatch('login/allTokenRefresh', res)

            this.sendToken();

            // if (this.$store.state.userInfo.tel === null) {
            //     this.$router.push('/moreInfo')
            // }
            // else{
            //     this.$store.commit('loginConfirmModalActivate')
            // }
            //dad
        }).catch((error) => {
            console.log(error);
        }).then(() => {
            console.log('getQSSList End!!');
        });
    },

    sendToken() {
        console.log('나는 sendToken!')
        const decodeAccessToken = VueJwtDecode.decode(session.getItem('at-jwt-access-token'));
        let headers = null;
        if(decodeAccessToken.exp < Date.now()/1000 + 60){
        console.log('만료됨!!');
        headers = {
            'at-jwt-access-token': session.getItem('at-jwt-access-token'),
            'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
        }
        console.log('headers : ', headers);
        }else{
        console.log('만료되지않음!!');
        headers = {
            'at-jwt-access-token': session.getItem('at-jwt-access-token'),
            'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
        }
        console.log('headers : ', headers);
        }
    }

  },
  created: function() {
    this.kakaoValidate()
  }
  
}

</script>