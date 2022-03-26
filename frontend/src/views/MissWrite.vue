<template>
  <div id="app">
    <!-- main-area -->
    <main>
      <!-- breadcrumb-area -->
      <section
        class="breadcrumb-area breadcrumb-bg"
        style="background-image: url('img/bg/banner6.jpg')"
      >
        <div class="container">
          <div class="row">
            <div class="col-12">
              <div class="breadcrumb-content">
                <h2 class="title">실종 동물 추가 페이지</h2>
                <nav aria-label="breadcrumb">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                      <router-link to="/">홈</router-link>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                      실종동물
                    </li>
                  </ol>
                </nav>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- breadcrumb-area-end -->

      <!-- shop-details-area -->
      <section class="shop-details-area pt-110 pb-50">
        <div class="container">
          <div class="shop-details-wrap">
            <div class="row">
              <div class="col-6">
                <div class="shop-details-img-wrap">
                  <div class="tab-content" id="myTabContent">
                    <div
                      class="tab-pane show active"
                      id="item-one"
                      role="tabpanel"
                      aria-labelledby="item-one-tab"
                    >
                      <div class="shop-details-img">
                        <label v-if="!miss.profile" for="file"
                          ><img
                            src="../assets/img/image.png"
                            alt=""
                            id="default-img"
                            style="
                              background-color: #bcbcbc;
                              width: 616px;
                              height: 568px;
                              border: 2px solid black;
                            "
                        /></label>
                        <label v-else for="file"
                          ><img
                            :src="miss.profile"
                            alt=""
                            id="default-img"
                            style="
                              background-color: gray;
                              width: 616px;
                              height: 568px;
                              border: 2px solid black;
                            "
                        /></label>
                        <input
                          style="display: none"
                          type="file"
                          id="file"
                          accept="image/*"
                          @change="imgUpload"
                          ref="animalImg"
                        />
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-6">
                <div
                  id="test"
                  style="
                    border: 2px solid black;
                    padding: 10px;
                    width: 586px;
                    height: 568px;
                    overflow: auto;
                  "
                >
                  <div class="shop-details-price">
                    <h2 class="price">사람 정보</h2>
                    <h5 class="stock-status">- Person</h5>
                  </div>
                  <div class="shop-details-dimension">
                    <label for="personName">이름</label>
                    <input
                      id="personName"
                      type="text"
                      v-model="miss.author"
                      class="form-control"
                      placeholder="이름을 입력해주세요."
                    />
                    <label for="personTel">전화번호</label>
                    <input
                      id="personTel"
                      type="tel"
                      v-model="miss.careTel"
                      class="form-control"
                      placeholder="전화번호을 입력해주세요."
                    />
                  </div>
                  <div class="shop-details-price">
                    <h2 class="price">동물 정보</h2>
                    <h5 class="stock-status">- Animal</h5>
                  </div>
                  <div class="shop-details-dimension">
                    <label for="animalName">이름</label>
                    <input
                      id="animalName"
                      type="text"
                      v-model="miss.name"
                      class="form-control"
                      placeholder="이름을 입력해주세요."
                    />
                    <label for="animalKind">품종</label>
                    <input
                      id="animalKind"
                      type="text"
                      v-model="miss.kindCd"
                      class="form-control"
                      placeholder="품종을 입력해주세요."
                    />
                    <label for="animalColor">색상</label>
                    <input
                      id="animalColor"
                      type="text"
                      v-model="miss.colorCd"
                      class="form-control"
                      placeholder="색상을 입력해주세요.(흰,검정,갈색,베이지 ...)"
                    />
                    <label for="animalAge">나이</label>
                    <input
                      id="animalAge"
                      type="text"
                      v-model="miss.age"
                      class="form-control"
                      placeholder="나이를 입력해주세요."
                    />
                    <label for="animalSex">성별</label>
                    <input
                      id="animalSex"
                      type="text"
                      v-model="miss.sexCd"
                      class="form-control"
                      placeholder="성별을 입력해주세요.(F/M)"
                    />
                    <label for="animalneuter">중성화</label>
                    <input
                      id="animalneuter"
                      type="text"
                      v-model="miss.neuterYn"
                      class="form-control"
                      placeholder="중성화 여부를 입력해주세요.(Y/N)"
                    />
                    <!-- <br>
                    <label for="animalneuterY">Y</label>
                    <input type="radio" name="neuter" id="animalneuterY" value="Y" v-model="miss.neuterYn">
                    <label for="animalneuterN">N</label>
                    <input type="radio" name="neuter" id="animalneuterN" value="N" v-model="miss.neuterYn">
                    <br> -->
                    <label for="animalHappenDay">실종날짜</label>
                    <input
                      id="animalHappenDay"
                      type="date"
                      v-model="miss.happenDt"
                      class="form-control"
                      placeholder="실종날짜를 입력해주세요."
                    />
                    <label for="animalHappenPlace">실종장소</label>
                    <div>
                        <select
                          style="width : 180px; float: left"
                          v-model="miss.happenGugun"
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
                        <input style="width:365px"
                          id="animalHappenPlace"
                          type="text"
                          v-model="miss.happenPlace"
                          class="form-control"
                          placeholder="실종장소를 입력해주세요."
                        />
                    </div>
                    <label for="animalDesc">특이사항</label>
                    <textarea
                      id="animalDesc"
                      type="text"
                      v-model="miss.descr"
                      class="form-control"
                      placeholder="특이사항을 입력해주세요."
                    />
                  </div>
                </div>
                <div class="d-md-flex justify-content-md-end">
                  <span>
                    <li class="header-btn" style="margin: 1px" @click="reset">
                      <p class="btn">
                        취소
                        <img src="img/icon/w_pawprint.png" alt="" />
                      </p>
                      
                    </li>
                  </span>
                  <span>
                    <li class="header-btn" style="margin: 1px;" @click="test">
                      <p class="btn">
                        작성
                        <img src="img/icon/w_pawprint.png" alt="" />
                      </p>
                    </li>
                  </span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- shop-details-area-end -->
    </main>
    <!-- main-area-end -->
  </div>
</template>

<script>
import axios from 'axios'
const session = window.sessionStorage;

export default {
  name: "App",
  components: {},
  data: function(){
     return {
       miss: {
        name : "",
        kindCd : "",
        colorCd: "",
        age: "",
        sexCd: "",
        neuterYn: "",
        author: "",
        careTel: "",
        happenDt: "",
        happenGugun: "",
        happenPlace: "",
        descr: "",
        profile: "",
       },
     }
  },
  methods:{
    test(){
      if(this.check() == true){
        alert("똑바로 입력하세요!!")
        return;
      }
      console.log(this.miss)
    },
    check(){
      if (this.miss.name == "" || this.miss.kindCd == "" || this.miss.colorCd == ""|| this.miss.age == ""|| this.miss.sexCd == ""||
        this.miss.happenGugun == "" || this.miss.neuterYn== ""|| this.miss.author== ""|| this.miss.careTel== ""||  this.miss.happenPlace== ""|| this.miss.descr == ""){
          return true;
      }
    },
    reset(){
        this.miss.name = ""
        this.miss.kindCd = ""
        this.miss.colorCd= ""
        this.miss.age= ""
        this.miss.sexCd= ""
        this.miss.neuterYn= ""
        this.miss.author= ""
        this.miss.careTel= ""
        this.miss.happenDt= ""
        this.miss.happenGugun= ""
        this.miss.happenPlace= ""
        this.miss.descr= ""
        this.miss.profile= ""
    },
    imgUpload() {
      this.miss.profile = null;
      this.miss.profile = URL.createObjectURL(this.$refs.animalImg.files[0]);
      console.log(this.miss.profile)
    },
    insert_miss(){
      const formData = new FormData();
      formData.append("multipartFile", this.$refs.animalImg.files[0]);

      let headers = {
        'at-jwt-access-token': session.getItem('at-jwt-access-token'),
        'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
      };
      let data = {
        name : this.miss.name,
        kindCd : this.miss.kindCd,
        colorCd: this.miss.colorCd,
        age: this.miss.age,
        sexCd: this.miss.sexCd,
        neuterYn: this.miss.neuterYn,
        author: this.miss.author,
        careTel: this.miss.careTel,
        happenDt: this.miss.happenDt,
        happenPlace: this.miss.happenGugun+" "+this.miss.happenPlace,
        descr: this.miss.descr,
        profile: this.miss.profile,  // 이거 제거해야할수도있음 이미지에 따라
      };
      axios({
        method: 'post',
        url: '/api/qss/list', // 이부분 수정해야함
        data: data,
        headers: headers,
      }).then((res) => {

        this.$store.dispatch('login/accessTokenRefresh', res)
        console.log(res);
      }).catch((error) => {
        console.log(error);
      }).then(() => {
        console.log('getQSSList End!!');
      });
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
  border-radius: 100px;
}
#test::-webkit-scrollbar-track {
  background-color: white; /*스크롤바 트랙 색상*/
}
</style>
