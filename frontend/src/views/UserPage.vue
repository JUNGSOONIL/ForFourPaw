<template>
  <div id="app">
    <main>
      <section
        class="breadcrumb-area breadcrumb-bg"
        style="background-image: url('/img/bg/banner6.jpg')"
      >
        <div class="container">
          <div class="row">
            <div class="col-12">
              <div class="breadcrumb-content">
                <h2 class="title">마이 페이지</h2>
                <nav
                  style="
                    background-color: #f5f2eb;
                    width: 170px;
                    border-radius: 15px 15px 40px 15px;
                  "
                  aria-label="breadcrumb"
                >
                  <ol style="margin-left: 20px" class="breadcrumb">
                    <li class="breadcrumb-item">
                      <router-link style="color: gray" to="/">홈</router-link>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                      <router-link to="/userPage">마이 페이지</router-link>
                    </li>
                  </ol>
                </nav>
              </div>
            </div>
          </div>
        </div>
      </section>

      <section v-if="!check" class="contact-area">
        <div class="container">
          <div class="container-inner-wrap">
            <h3 class="title">프로필</h3>
            <div
              class="row justify-content-center justify-content-lg-between"
              style="border: 3px solid #f5f2eb; border-radius: 40px; padding: 15px"
            >
              <div class="col-lg-6 col-md-8 order-2 order-lg-0">
                <div class="contact-wrap-content">
                  <form action="#" class="contact-form">
                    <div class="form-grp" style="margin-bottom: 20px">
                      <label for="name">이름</label>
                      <input
                        type="text"
                        id="name"
                        v-model="userInfo.name"
                        disabled
                      />
                    </div>
                    <div class="form-grp" style="margin-bottom: 20px">
                      <label for="nickname">닉네임</label>
                      <input
                        type="text"
                        id="nickname"
                        v-model="userInfo.nickname"
                        disabled
                      />
                    </div>
                    <div class="form-grp" style="margin-bottom: 20px">
                      <label for="email">이메일</label>
                      <input
                        type="text"
                        id="email"
                        v-model="userInfo.email"
                        disabled
                      />
                    </div>
                    <div class="form-grp" style="margin-bottom: 20px">
                      <label for="addrs">거주지역 </label>
                      <input
                        type="text"
                        id="addrs"
                        v-model="userInfo.addrs"
                        disabled
                      />
                    </div>
                  </form>
                </div>
              </div>
              <div class="col-xl-5 col-lg-6 col-md-8">
                <label style="color: #0a303a">프로필 이미지 </label>
                <div class="contact-info-wrap" style="padding: 38px">
                  <div>
                    <img
                      :src="userInfo.profileImg"
                      style="
                        width: 326px;
                        height: 297px;
                        border: 1px solid gray;
                        border-radius: 50%;
                      "
                      alt=""
                    />
                  </div>
                </div>
              </div>
            </div>
            <div class="d-md-flex justify-content-md-end">
              <span style="margin-top: 10px">
                <li class="header-btn" @click="check = !check">
                  <p
                    class="btn"
                    style="
                      width: 85px;
                      height: 10px;
                      font-size: 17px;
                      padding: 19px 15px;
                    "
                  >
                    편집
                    <img src="/img/icon/w_pawprint.png" alt="" />
                  </p>
                </li>
              </span>
            </div>
          </div>
        </div>
      </section>

      <section v-if="check" class="contact-area">
        <div class="container">
          <div class="container-inner-wrap">
            <h3 class="title">프로필</h3>
            <div
              class="row justify-content-center justify-content-lg-between"
              style="border: 3px solid #f5f2eb; border-radius: 40px; padding: 15px"
            >
              <div class="col-lg-6 col-md-8 order-2 order-lg-0">
                <div class="contact-wrap-content">
                  <form action="#" class="contact-form">
                    <div class="mb-35">
                      <label for="name">이름</label>
                      <input
                        id="name"
                        type="text"
                        v-model="userInfo.name"
                        class="form-control"
                        @input="koreanickname"
                        :class="{
                          'is-valid':
                            userInfo.name != null && userInfo.name.length >= 3,
                          'is-invalid':
                            userInfo.name == null || userInfo.name.length < 3,
                        }"
                      />
                      <div class="invalid-feedback">
                        이름을 똑바로 입력하세요.
                      </div>
                    </div>

                    <div class="mb-35">
                      <label for="nickname">닉네임</label>
                      <input
                        id="nickname"
                        type="text"
                        v-model="userInfo.nickname"
                        class="form-control"
                        @input="validateDBNickName"
                        :class="{
                          'is-valid':
                            userInfo.nickname != null &&
                            userInfo.nickname.length >= 3 &&
                            nicknamecheck,
                          'is-invalid':
                            userInfo.nickname == null ||
                            userInfo.nickname.length < 3 ||
                            !nicknamecheck,
                        }"
                      />
                      <div class="invalid-feedback">
                        닉네임이 이미 사용중이거나 3글자 이상 입력하세요
                      </div>
                    </div>

                    <div class="mb-35">
                      <label for="email">이메일</label>
                      <input
                        id="email"
                        type="text"
                        v-model="userInfo.email"
                        class="form-control"
                        readonly
                      />
                    </div>

                    <div class="mb-35">
                      <label for="addrs">거주지역</label>
                      <select
                        v-model="userInfo.addrs"
                        class="form-control"
                        name="addrs"
                        :class="{
                          'is-valid':
                            userInfo.addrs != null &&
                            userInfo.addrs.length != 0,
                          'is-invalid':
                            userInfo.addrs == null ||
                            userInfo.addrs.length == 0,
                        }"
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
                      <div class="invalid-feedback">
                        거주지역을 선택해주세요
                      </div>
                    </div>
                  </form>
                </div>
              </div>
              <div class="col-xl-5 col-lg-6 col-md-8">
                <label>프로필 이미지 </label>
                <div class="contact-info-wrap" style="padding: 38px">
                  <div>
                    <label for="file"
                      ><img
                        :src="userInfo.profileImg"
                        alt=""
                        id="default-img"
                        style="
                          width: 326px;
                          height: 297px;
                          border: 1px solid gray;
                          border-radius: 50%;
                        "
                    /></label>
                    <input
                      style="display: none"
                      type="file"
                      id="file"
                      accept="image/*"
                      @change="imgUpload"
                      ref="userimg"
                    />
                  </div>
                </div>
              </div>
            </div>
            <div class="d-md-flex justify-content-md-end">
              <span style="margin-top: 10px; margin-right: 10px">
                <li class="header-btn" @click="toggle">
                  <p
                    class="btn"
                    style="
                      width: 85px;
                      height: 10px;
                      font-size: 17px;
                      padding: 19px 15px;
                    "
                  >
                    취소
                    <img src="/img/icon/w_pawprint.png" alt="" />
                  </p>
                </li>
              </span>
              <span style="margin-top: 10px; margin-right: 10px">
                <li class="header-btn" @click="updateuser">
                  <p
                    class="btn"
                    style="
                      width: 85px;
                      height: 10px;
                      font-size: 17px;
                      padding: 19px 15px;
                    "
                  >
                    수정
                    <img src="/img/icon/w_pawprint.png" alt="" />
                  </p>
                </li>
              </span>
              <span style="margin-top: 10px">
                <li class="header-btn" @click="deleteuser">
                  <p
                    class="btn"
                    style="
                      width: 85px;
                      height: 10px;
                      font-size: 17px;
                      padding: 19px 15px;
                    "
                  >
                    탈퇴
                    <img src="/img/icon/w_pawprint.png" alt="" />
                  </p>
                </li>
              </span>
            </div>
          </div>
        </div>
      </section>

      <section class="contact-area pt-10 pb-20">
        <div v-if="boardlist.length != 0" class="container">
          <div class="container-inner-wrap">
            <h3 class="title">내가 작성한 글</h3>
            <div
            id="test"
              class="row"
              style="border: 3px solid #f5f2eb; border-radius: 40px; padding: 15px; height:448px; overflow:auto;"
            >
              <table class="table align-items-center mb-0 table-hover">
                <thead>
                  <tr>
                    <th class="text-center" width="150">#</th>
                    <th class="text-center">내용</th>
                    <th class="text-center" width="250">작성일시</th>
                  </tr>
                </thead>
                <tbody>
                  <tr
                    style="cursor: pointer"
                    v-for="(board, index) in boardlist"
                    v-bind:key="index"
                    @click="pagemove(board.no)"
                    class="text-center text-secondary font-weight-bold"
                  >
                    <td>{{ board.no }}</td>
                    <td>
                      이름 : {{ board.name }} ({{ board.kindCd }}) - 실종장소 :
                      {{ board.happenPlace }}
                    </td>
                    <td>{{ board.writeTime.substring(0, 10) }}</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </section>
    </main>
  </div>
</template>

<script type="text/Javascript" charset="UTF-8">
import axios from 'axios'
const session = window.sessionStorage;
export default {
  name: "App",
  components: {},
  data: function(){
     return {
       check : false,
       nicknamecheck : true,
       userInfo:{
         no : "",
         name : "",
         nickname : "",
         email : "",
         addrs : "",
         profileImg : "",
       },
       boardlist:{ }
     }
  },
  created() {
    this.userInfo = JSON.parse(session.getItem('userInfo'))
    this.selectmyboard()
  },
  methods:{
    selectmyboard(){
      let headers = {
        'at-jwt-access-token': session.getItem('at-jwt-access-token'),
        'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
      };
      axios({
        method: 'get',
        url: '/api/users/miss/' + this.userInfo.no, // 이부분 수정해야함
        headers: headers,
      }).then((res) => {
        this.$store.dispatch('login/accessTokenRefresh', res)
        this.boardlist = res.data
      }).catch((error) => {
        console.log(error);
      }).then(() => {
      });
    },
    pagemove(el){
      this.$router.push({ name: 'MissDetail', params: { no: el }})
    },
    toggle(){
      this.check = !this.check
      this.userInfo = JSON.parse(session.getItem('userInfo'))
    },
    updatecheck(){
        if(this.userInfo.no == "" || this.userInfo.name == "" || this.userInfo.nickname == "" ||  this.userInfo.addrs == "" ||
        this.userInfo.no.length == 0 || this.userInfo.name.length == 0 || this.userInfo.nickname.length == 0 || this.userInfo.addrs.length == 0){
          return true
        }
    },
    imgUpload() {
      this.userInfo.profileImg = null;
      this.userInfo.profileImg = URL.createObjectURL(this.$refs.userimg.files[0]);
    },
    koreanickname(el){
      this.userInfo.name = el.target.value
    },
    validateDBNickName(el) {
      this.userInfo.nickname = el.target.value
      if(this.userInfo.nickname == JSON.parse(session.getItem('userInfo')).nickname){
        this.nicknamecheck = true;
        return
      }
      if (this.userInfo.nickname.length >= 3 ) {
        let headers = {
          "at-jwt-access-token": session.getItem("at-jwt-access-token"),
          "at-jwt-refresh-token": session.getItem("at-jwt-refresh-token"),
        };
        axios({
          method: "get",
          url: '/api/users/checkByNickname/'+this.userInfo.nickname,
          headers: headers,
        })
          .then((res) => {
            this.$store.dispatch("login/accessTokenRefresh", res);
            this.nicknamecheck = true;
          })
          .catch((error) => {
            console.log(error);
            this.nicknamecheck = false;
          });
      }
    },
    updateuser(){
      if(this.updatecheck() === true){
        this.$alertify.error("똑바로 입력하세요");
        return
      }
      let headers = {
        'Content-Type': 'multipart/form-data',
        'at-jwt-access-token': session.getItem('at-jwt-access-token'),
        'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
      };

      const formData = new FormData();
      formData.append("multipartFile", this.$refs.userimg.files[0]);

      let data = { // 데이터 다전송?
         no : this.userInfo.no,
         name : this.userInfo.name,
         nickname : this.userInfo.nickname,
         email : this.userInfo.email,
         addrs : this.userInfo.addrs,
      };
      formData.append(
        "userInfo",
        new Blob([JSON.stringify(data)], { type: "application/json" })
      );
      axios({
        method: 'put',
        url: '/api/users',
        data: formData,
        headers: headers,
      }).then((res) => {
        this.$store.dispatch('login/accessTokenRefreshOnUserInfo', res) // 이거도 이거 아닐듯
        this.$alertify.success("수정 완료했습니다.");
        this.$router.push("/");
      }).catch((error) => {
        console.log(error);
      })
    },

    alertifyDelete(){
      
      let headers = {
        'at-jwt-access-token': session.getItem('at-jwt-access-token'),
        'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
      };
      axios({
        method: 'delete',
        url: '/api/users/' + this.userInfo.no,
        headers: headers,
      }).then((res) => {
        this.$store.dispatch('login/accessTokenRefresh', res) // 이거는?
        this.$alertify.success("탈퇴 완료했습니다.");
        this.$store.commit("login/SET_LOGOUT");
        session.clear();
        // this.$router.push("/")
        this.$router.push({ name: "LogoutPage", params: { msg: "회원탈퇴"}});
      }).catch((error) => {
        console.log(error);
      })
    },

    deleteuser(){
      this.$alertify.confirm(
        '탈퇴하시겠습니까?',
        () => this.alertifyDelete(),
        () => this.$alertify.error('cancel')
      );
    },
  },
};
</script>

<style scoped>
#app {
}
#test::-webkit-scrollbar {
  width: 15px; /*스크롤바의 너비*/
}

#test::-webkit-scrollbar-thumb {
  background-color: red; /*스크롤바의 색상*/
  background-clip: padding-box;
  border: 2px solid transparent;
  height: 17%;
  border-radius: 100px;
}
#test::-webkit-scrollbar-track {
  background-color: rgba(0,0,0,0); /*스크롤바 트랙 색상*/
}
</style>
