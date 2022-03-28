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
                    <div>
                    <label for="personName">이름</label>
                    <input
                      id="personName"
                      type="text"
                      v-model="miss.author"
                      class="form-control"
                      placeholder="이름을 입력해주세요."
                      @input="validate.author = miss.author.length >= 3 ? true : false"
                      @focus="focusdate.author = true"
                      :class="{
                            'is-valid': validate.author,
                            'is-invalid': (!validate.author&&focusdate.author),
                      }"
                    />
                    <!-- <div class="valid-feedback">사용 가능 합니다.</div> -->
                    <div class="invalid-feedback">이름을 똑바로 입력하세요.</div>
                    </div>
                    <div>
                      <label for="personTel">전화번호</label>
                    <input
                      id="personTel"
                      type="text"
                      v-model="miss.careTel"
                      class="form-control"
                      placeholder="전화번호을 입력해주세요."
                      @input="validTel"
                      @focus="focusdate.careTel = true"
                      :class="{
                            'is-valid': validate.careTel,
                            'is-invalid': (!validate.careTel&&focusdate.careTel),
                      }"
                    />
                    <!-- <div class="valid-feedback">사용 가능 합니다.</div> -->
                    <div class="invalid-feedback">전화번호를 똑바로 입력하세요.</div>
                    </div>
                  </div>
                  <div class="shop-details-price">
                    <h2 class="price">동물 정보</h2>
                    <h5 class="stock-status">- Animal</h5>
                  </div>
                  <div class="shop-details-dimension">
                    <div>
                                          <label for="animalName">이름</label>
                    <input
                      id="animalName"
                      type="text"
                      v-model="miss.name"
                      class="form-control"
                      placeholder="이름을 입력해주세요."
                      @input="validate.name = miss.name.length > 0 ? true : false"
                      @focus="focusdate.name = true"
                      :class="{
                            'is-valid': validate.name,
                            'is-invalid': (!validate.name&&focusdate.name),
                      }"
                    />
                    <!-- <div class="valid-feedback">사용 가능 합니다.</div> -->
                    <div class="invalid-feedback">이름을 똑바로 입력하세요.</div>
                    </div>

                    <div>
                      <label for="animalKind">품종</label>
                    <input
                      id="animalKind"
                      type="text"
                      v-model="miss.kindCd"
                      class="form-control"
                      placeholder="품종을 입력해주세요."
                       @input="validate.kindCd = miss.kindCd.length > 0 ? true : false"
                      @focus="focusdate.kindCd = true"
                      :class="{
                            'is-valid': validate.kindCd,
                            'is-invalid': (!validate.kindCd&&focusdate.kindCd),
                      }"
                    />
                    <!-- <div class="valid-feedback">사용 가능 합니다.</div> -->
                    <div class="invalid-feedback">품종을 똑바로 입력하세요.</div>
                    </div>

                    <div>
                      <label for="animalColor">색상</label>
                    <input
                      id="animalColor"
                      type="text"
                      v-model="miss.colorCd"
                      class="form-control"
                      placeholder="색상을 입력해주세요.(흰,검정,갈색,베이지 ...)"
                      @input="validate.colorCd = miss.colorCd.length > 0 ? true : false"
                      @focus="focusdate.colorCd = true"
                      :class="{
                            'is-valid': validate.colorCd,
                            'is-invalid': (!validate.colorCd&&focusdate.colorCd),
                      }"
                    />
                    <!-- <div class="valid-feedback">사용 가능 합니다.</div> -->
                    <div class="invalid-feedback">색상을 똑바로 입력하세요.</div>
                    </div>
                    
                    <div>
                    <label for="animalAge">나이</label>
                    <input
                      id="animalAge"
                      type="text"
                      v-model="miss.age"
                      class="form-control"
                      placeholder="나이를 입력해주세요."
                      @input="validate.age = miss.age.length > 0 ? true : false"
                      @focus="focusdate.age = true"
                      :class="{
                            'is-valid': validate.age,
                            'is-invalid': (!validate.age&&focusdate.age),
                      }"
                    />
                    <!-- <div class="valid-feedback">사용 가능 합니다.</div> -->
                    <div class="invalid-feedback">나이를 똑바로 입력하세요.</div>
                    </div>

                    <div>
                    <label for="animalSex">성별</label>
                    <input
                      id="animalSex"
                      type="text"
                      v-model="miss.sexCd"
                      class="form-control"
                      placeholder="성별을 입력해주세요.(F/M)"
                      @input="validSex"
                      @focus="focusdate.sexCd = true"
                      :class="{
                            'is-valid': validate.sexCd,
                            'is-invalid': (!validate.sexCd&&focusdate.sexCd),
                      }"
                    />
                    <!-- <div class="valid-feedback">사용 가능 합니다.</div> -->
                    <div class="invalid-feedback">성별을 똑바로 입력하세요.</div>
                    </div>

                    <div>
                    <label for="animalneuter">중성화</label>
                    <input
                      id="animalneuter"
                      type="text"
                      v-model="miss.neuterYn"
                      class="form-control"
                      placeholder="중성화 여부를 입력해주세요.(Y/N)"
                     @input="validNeuter"
                      @focus="focusdate.neuterYn = true"
                      :class="{
                            'is-valid': validate.neuterYn,
                            'is-invalid': (!validate.neuterYn&&focusdate.neuterYn),
                      }"
                    />
                    <!-- <div class="valid-feedback">사용 가능 합니다.</div> -->
                    <div class="invalid-feedback">성별을 똑바로 입력하세요.</div>
                    </div>
 
                    <div>
                    <label for="animalHappenDay">실종날짜</label>
                    <input
                      id="animalHappenDay"
                      type="date"
                      v-model="miss.happenDt"
                      class="form-control"
                      placeholder="실종날짜를 입력해주세요."
                      @input="validate.happenDt = miss.happenDt.length > 0 ? true : false"
                      @focus="focusdate.happenDt = true"
                      :class="{
                            'is-valid': validate.happenDt,
                            'is-invalid': (!validate.happenDt&&focusdate.happenDt),
                      }"
                    />
                    <!-- <div class="valid-feedback">사용 가능 합니다.</div> -->
                    <div class="invalid-feedback">실종날짜를 똑바로 입력하세요.</div>
                    </div>

                    <label for="animalHappenPlace">실종장소</label>
                    <div>
                        <select
                          style="width : 180px; float: left"
                          v-model="miss.happenGugun"
                          class="form-control"
                          name="거주지역"
                          @change="validate.happenGugun = true, validate.happenPlace = (miss.happenPlace.length >0 && miss.happenGugun.length > 0) ? true : false"
                          @focus="focusdate.happenGugun = true"
                          :class="{
                            'is-valid': validate.happenGugun,
                            'is-invalid': (!validate.happenGugun&&focusdate.happenGugun),
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
                          <!-- <option :value="18" selected>선택</option> -->
                        </select>
                        <input style="width:365px"
                          id="animalHappenPlace"
                          type="text"
                          v-model="miss.happenPlace"
                          class="form-control"
                          placeholder="실종장소를 입력해주세요."
                          @input="validate.happenPlace = (miss.happenPlace.length >0 && miss.happenGugun.length > 0) ? true : false"
                          @focus="focusdate.happenPlace = true"
                      :class="{
                            'is-valid': validate.happenPlace,
                            'is-invalid': (!validate.happenPlace&&focusdate.happenPlace),
                      }"
                    />
                    <!-- <div class="valid-feedback">사용 가능 합니다.</div> -->
                    <div class="invalid-feedback">실종장소를 똑바로 입력하세요.</div>
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
                  <span v-if="no == null">
                    <li class="header-btn" style="margin: 1px;" @click="insertMiss">
                      <p class="btn">
                        작성
                        <img src="img/icon/w_pawprint.png" alt="" />
                      </p>
                    </li>
                  </span>
                  <span v-else>
                    <li class="header-btn" style="margin: 1px;" @click="insertMiss">
                      <p class="btn">
                        수정
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
  props:{
    no:{
      type:Number,
    },
  },
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
       focusdate:{
        name : false,
        kindCd : false,
        colorCd: false,
        age: false,
        sexCd: false,
        neuterYn: false,
        author: false,
        careTel: false,
        happenDt: false,
        happenGugun: false,
        happenPlace: false,
       },
       validate:{
        name : false,
        kindCd : false,
        colorCd: false,
        age: false,
        sexCd: false,
        neuterYn: false,
        author: false,
        careTel: false,
        happenDt: false,
        happenGugun: false,
        happenPlace: false,
       }
     }
  },
  created() {
    if(this.no != null){
      this.selectMiss();
    }
  },
  methods:{
    selectMiss(){
      let headers = {
        'at-jwt-access-token': session.getItem('at-jwt-access-token'),
        'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
      };
      axios({
        method: 'get',
        url: '/api/qss/list' + this.no, // 이부분 수정해야함
        headers: headers,
      }).then((res) => {
        this.$store.dispatch('login/accessTokenRefresh', res)
        this.miss = res // 이부분도 수정
        // 여기서 벨류 체크 부분도 수정될듯?
      }).catch((error) => {
        console.log(error);
      }).then(() => {
        console.log('getQSSList End!!');
      });
    },
    check(){
      if (!this.validate.name|| !this.validate.kindCd|| !this.validate.colorCd || !this.validate.age || !this.validate.sexCd || this.miss.profile == "" ||
        !this.validate.happenGugun|| !this.validate.neuterYn|| !this.validate.author || !this.validate.careTel ||  !this.validate.happenPlace){
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
        this.focusdate.name = this.validate.name = false
        this.focusdate.kindCd = this.validate.kindCd = false
        this.focusdate.colorCd = this.validate.colorCd = false
        this.focusdate.age = this.validate.age = false
        this.focusdate.sexCd = this.validate.sexCd = false
        this.focusdate.neuterYn = this.validate.neuterYn = false
        this.focusdate.author = this.validate.author = false
        this.focusdate.careTel = this.validate.careTel = false
        this.focusdate.happenDt = this.validate.happenDt = false
        this.focusdate.happenGugun = this.validate.happenGugun = false
        this.focusdate.happenPlace = this.validate.happenPlace = false
    },
    imgUpload() {
      this.miss.profile = null;
      this.miss.profile = URL.createObjectURL(this.$refs.animalImg.files[0]);
      console.log(this.miss.profile)
    },
    insertMiss(){
      if(this.check() === true){
        this.$alertify.error("똑바로 입력하세요");
        return
      }
      console.log(this.miss)
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
        this.$alertify.success("작성 완료했습니다.");
      }).catch((error) => {
        console.log(error);
      }).then(() => {
        console.log('getQSSList End!!');
      });
    },
    validTel(){
      const nums = this.miss.careTel.length
      const n = this.miss.careTel.charCodeAt(nums-1)
      const poss = ['010', '011', '012', '013', '014','015', '016', '017', '018', '019']
      if (n > 47 && n < 58){
        if (nums == 3 || nums == 8){
          this.miss.careTel += '-'
        }
      }
      else {
       this.miss.careTel = this.miss.careTel.slice(0, nums - 1)
      }
      if (nums == 13 && poss.indexOf(this.miss.careTel.slice(0,3)) > -1){
        this.validate.careTel = true
      }
      else {
        this.validate.careTel = false
      }
    },
    validSex(){
      if(this.miss.sexCd.length ===1 && (this.miss.sexCd === 'F' || this.miss.sexCd ==='M')){
        this.validate.sexCd = true
      }else{
        this.validate.sexCd = false
      }
    },
    validNeuter(){
      if(this.miss.neuterYn.length ===1 && (this.miss.neuterYn === 'Y' || this.miss.neuterYn ==='N')){
        this.validate.neuterYn = true
      }else{
        this.validate.neuterYn = false
      }
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
