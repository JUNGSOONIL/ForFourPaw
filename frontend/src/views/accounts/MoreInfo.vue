<template>
   <div class="section-title text-center" style="display: flex; justify-content: center; align-items:center; min-height: 100vh;">
    <div style="margin-top:0px; width:600px; height:500px;" class="comment-reply-box">
                <h3 class="text-left">
                  멍멍! 야옹! <br />
                  포포포(For Four Paw)에서
                  사용할<br> 당신의 정보를 입력하세요!🐾
                </h3>
                <form action="#" class="comment-reply-form">
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-grp">
                        <label style="float:left" class="input-non-point " for="Name">이름:</label>
                        <input
                          type="text"
                          v-model="name"
                          class="form-control"
                          placeholder="이름을 입력해주세요."
                        />
                      </div>
                    </div>
                    <div class="col-md-12">
                      <div class="form-grp">
                        <label style="float:left" class="input-non-point" for="Nickname"
                          >닉네임:</label
                        >
                        <input
                          v-model="nickname"
                          class="form-control"
                          type="text"
                          placeholder="닉네임을 입력해주세요.(최소 3글자)"
                          :class="{
                            'is-valid': isNickNameFocusAndValid,
                            'is-invalid': isNickNameFocusAndInvalid,
                          }"
                          @input="validateNickName"
                          @focus="isNickNameFocus = true"
                          @blur="validateDBNickName"
                        />
                      </div>
                    </div>
                    <div class="col-md-12">
                      <div class="form-grp">
                        <label style="float:left" class="input-non-point" for="address"
                          >거주지역:</label
                        >
                        <select
                          v-model="addrs"
                          class="form-control"
                          name="거주지역"
                        >
                          <option value="서울특별시">서울특별시</option>
                          <option value="부산광역시">부산광역시</option>
                          <option value="대구광역시">대구광역시</option>
                          <option value="인천광역시">인천광역시</option>
                          <option value="광주광역시">광주광역시</option>
                          <option value="대전광역시">대전광역시</option>
                          <option value="울산광역시">울산광역시</option>
                          <option value="세종특별자치시">세종특별자치시</option>
                          <option value="경기도">경기도</option>
                          <option value="강원도">강원도</option>
                          <option value="충청북도">충청북도</option>
                          <option value="충청남도">충청남도</option>
                          <option value="전라북도">전라북도</option>
                          <option value="전라남도">전라남도</option>
                          <option value="경상북도">경상북도</option>
                          <option value="경상남도">경상남도</option>
                          <option value="제주특별자치도">제주특별자치도</option>
                        </select>
                      </div>
                    </div>
                  </div>
                </form>
                <div class="col-md-12 text-center">
                  <button style="height:40px" id="moreinfobtn" class="btn" @click="signUp">
                    수정
                  </button>
                </div>
              </div>
  </div>
</template>

<script>
import axios from "axios";
import Vue from "vue";
import VueAlertify from "vue-alertify";
Vue.use(VueAlertify);
const session = window.sessionStorage;

export default {
  data() {
    return {
      name: "",
      nickname: "",
      addrs: "",
      selected: "",
      //
      isUserNameValid: false,
      isNickNameFocus: false,
      isNickNameValid: false,
      isNickNameDBValid: false,
    };
  },
  computed: {
    isNickNameFocusAndValid() {
      return (
        this.isNickNameFocus && this.isNickNameValid && this.isNickNameDBValid
      );
    },
    isNickNameFocusAndInvalid() {
      return (
        this.isNickNameFocus && !this.isNickNameValid && !this.isNickNameDBValid
      );
    },
  },
  methods: {
    validateName() {
      this.isUserNameValid = this.name.length > 1 ? true : false;
    },
    validateNickName() {
      this.isNickNameValid = this.nickname.length >= 3 ? true : false;
    },
    validateDBNickName() {
      if (this.nickname.length >= 3) {
        let headers = {
          "at-jwt-access-token": session.getItem("at-jwt-access-token"),
          "at-jwt-refresh-token": session.getItem("at-jwt-refresh-token"),
        };
        axios({
          method: "get",
          url: `/api/users/checkByNickname/${this.nickname}`,
          headers: headers, // 넣는거 까먹지 마세요
        })
          .then((res) => {
            this.$store.dispatch("login/accessTokenRefresh", res); // store아닌곳에서
            this.$alertify.success("아이디를 사용할 수 있습니다.");
            this.isNickNameDBValid = true;
          })
          .catch((error) => {
            console.log(error);
            this.$alertify.error("아이디가 중복됩니다.");
            this.isNickNameDBValid = false;
          });
      }
    },
    signUp() {
      //validation이 통과 됬을때만 버튼이 클릭되게 해야함
      const formData = new FormData();
      let headers = {
        "at-jwt-access-token": session.getItem("at-jwt-access-token"),
        "at-jwt-refresh-token": session.getItem("at-jwt-refresh-token"),
      };
      const info = {
        no: this.$store.getters["login/userInfo"].no,
        name: this.name,
        nickname: this.nickname,
        addrs: this.addrs,
      };
       formData.append(
        "userInfo",
        new Blob([JSON.stringify(info)], { type: "application/json" })
      );
      if (this.isNickNameValid && this.isNickNameDBValid && this.addrs != "") {
        axios({
          method: "put",
          url: `/api/users`,
          data: formData,
          headers: headers, // 넣는거 까먹지 마세요
        })
          .then((res) => {
            this.$store.dispatch("login/accessTokenRefreshOnUserInfo", res);
            this.$router.push("/");
          })
          .catch((error) => {
            console.log(error);
          });
      } else {
        this.$alertify.error("정보를 수정할 수 없습니다");
      }
    },
  },
};
</script>
<style scoped>
#LoginLogo {
  height: 300px;
}

/* 추가정보 */
.input-non-point {
  cursor: default;
  font-size: 15px;
  font-weight: 700;
  color: #0a303a;
  font-family: "Poppins", sans-serif;
}
</style>
