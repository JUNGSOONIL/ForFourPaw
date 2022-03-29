<template>
  <div>
    <!-- adoption-shop-area -->
    <section class="adoption-shop-area">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-xl-7 col-lg-9">
            <div class="section-title mb-65">
              <!-- 추가 정보 start -->
              <div class="comment-reply-box">
                <h5 class="title text-center">
                  멍멍! 야옹! <br />
                  포포포(For Four Paw)에서 <br />
                  사용할 당신의 정보를 입력하세요!
                </h5>
                <form action="#" class="comment-reply-form">
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-grp">
                        <label class="input-non-point" for="Name">이름:</label>
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
                        <label class="input-non-point" for="Nickname"
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
                        <label class="input-non-point" for="address"
                          >거주지역:</label
                        >
                        <select
                          @change="change"
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
                          <!-- <option :value="18" selected>선택</option> -->
                        </select>
                      </div>
                    </div>
                  </div>
                </form>
                <div class="col-md-12 text-center">
                  <button id="moreinfobtn" class="btn" @click="signUp">
                    수정
                  </button>
                </div>
              </div>
              <!-- 추가정보 End -->
            </div>
          </div>
        </div>
      </div>
    </section>
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
    change() {
      console.log(this.addrs);
    },
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
            console.log("success");
            this.$alertify.success("아이디를 사용할 수 있습니다.");
            this.isNickNameDBValid = true;
          })
          .catch((error) => {
            console.log(error);
            console.log("error");
            this.$alertify.error("아이디가 중복됩니다.");
            this.isNickNameDBValid = false;
          });
      }
    },
    signUp() {
      //validation이 통과 됬을때만 버튼이 클릭되게 해야함
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
      if (
        this.isNickNameValid &&
        this.isNickNameDBValid &&
        this.addrs != ""
      ) {
        console.log("send");
        axios({
          method: "put",
          url: `/api/users`,
          data: info,
          headers: headers, // 넣는거 까먹지 마세요
        })
          .then((res) => {
            this.$store.dispatch("login/accessTokenRefreshOnUserInfo", res);
            this.$route.push("/");
          })
          .catch((error) => {
            console.log(error);
          });
      } else {
        console.log(this.isNickNameValid)
        console.log(this.isNickNameDBValid)
        console.log(this.addrs)
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
