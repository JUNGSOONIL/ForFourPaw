<template>
  <div id="app">
    <!-- main-area -->
    <main>
      <!-- breadcrumb-area -->
      <section
        class="breadcrumb-area breadcrumb-bg"
        style="background-image: url('/img/bg/banner3.jpg')"
      >
        <div class="container">
          <div class="row">
            <div class="col-12">
              <div class="breadcrumb-content">
                <h2 class="title">유기 동물 상세 페이지</h2>
                <nav aria-label="breadcrumb">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                      <router-link to="/">홈</router-link>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                      유기 동물
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
                        <img v-if="!miss.popfile" src="../assets/img/image.png" alt="" style="
                              background-color: #bcbcbc;
                              width: 616px;
                              height: 568px;
                              border: 2px solid black;
                        "/>
                        <img v-else :src="miss.popfile" alt="" style="
                              width: 616px;
                              height: 568px;
                              border: 2px solid black;
                        "/>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-6">
                <div id="test"
                  style="
                    border: 2px solid black;
                    padding: 10px;
                    width: 586px;
                    height: 568px;
                    overflow: auto;
                  ">
                  <div class="shop-details-price">
                    <h2 class="price">동물 정보</h2>
                    <h5 class="stock-status">- Animal</h5>
                  </div>
                  <div class="shop-details-dimension">
                    <label for="animalKind">품종</label>
                    <input
                      id="animalKind"
                      type="text"
                      v-model="miss.kindCd"
                      class="form-control"
                      readonly
                    />
                    <label for="animalColor">색상</label>
                    <input
                      id="animalColor"
                      type="text"
                      v-model="miss.colorCd"
                      class="form-control"
                      readonly
                    />
                    <label for="animalAge">나이</label>
                    <input
                      id="animalAge"
                      type="text"
                      v-model="miss.age"
                      class="form-control"
                      readonly
                    />
                    <label for="animalSex">성별</label>
                    <input
                      id="animalSex"
                      type="text"
                      v-model="miss.sexCd"
                      class="form-control"
                      readonly
                    />
                    <label for="animalneuter">중성화</label>
                    <input
                      id="animalneuter"
                      type="text"
                      v-model="miss.neuterYn"
                      class="form-control"
                      readonly
                    />
                    <label for="animalDesc">특이사항</label>
                    <textarea
                      id="animalDesc"
                      type="text"
                      v-model="miss.specialMark"
                      class="form-control"
                      readonly
                    />
                  </div>
                   <div class="shop-details-price">
                    <h2 class="price">구조 정보</h2>
                    <h5 class="stock-status">- Rescue</h5>
                  </div>
                  <div class="shop-details-dimension">
                    <label for="animalHappenDay">접수일시</label>
                    <input
                      id="animalHappenDay"
                      type="text"
                      v-model="miss.happenDt"
                      class="form-control"
                      readonly
                    />
                    <label for="animalHappenPlace">발생장소</label>
                    <div>
                        <input
                          id="animalHappenPlace"
                          type="text"
                          v-model="miss.happenPlace"
                          class="form-control"
                          readonly
                        />
                    </div>
                    <label for="animalnoticeSdt">공고기간</label>
                    <div>
                        <input
                          id="animalnoticeSdt"
                          type="text"
                          v-model="noticedt"
                          class="form-control"
                          readonly
                        />
                    </div>
                  </div>
                   <div class="shop-details-price">
                    <h2 class="price">보호소 정보</h2>
                    <h5 class="stock-status">- Shelter</h5>
                  </div>
                  <div class="shop-details-dimension">
                    <label for="animalHappenDay">보호소</label>
                    <input
                      id="animalHappenDay"
                      type="text"
                      v-model="miss.careNm"
                      class="form-control"
                      readonly
                    />
                    <label for="animalHappenPlace">보호소 위치</label>
                    <div>
                        <input
                          id="animalHappenPlace"
                          type="text"
                          v-model="miss.careAddr"
                          class="form-control"
                          readonly
                        />
                    </div>
                    <label for="animalnoticeSdt">보호소 전화번호</label>
                    <div>
                        <input
                          id="animalnoticeSdt"
                          type="text"
                          v-model="miss.careTel"
                          class="form-control"
                          readonly
                        />
                    </div>
                  </div>
                   <div class="shop-details-price">
                    <h2 class="price">관할기관 정보</h2>
                    <h5 class="stock-status">- Jurisdiction</h5>
                  </div>
                  <div class="shop-details-dimension">
                    <label for="animalHappenDay">관할기관</label>
                    <!-- {{miss.orgNm}} <br> -->
                    <input
                      id="animalHappenDay"
                      type="text"
                      v-model="miss.orgNm"
                      class="form-control"
                      readonly
                    />
                    <label for="animalHappenPlace">담당자</label>
                     <!-- {{miss.chargeNm}} <br> -->
                    <div>
                        <input
                          id="animalHappenPlace"
                          type="text"
                          v-model="miss.chargeNm"
                          class="form-control"
                          readonly
                        />
                    </div>
                    <label for="animalnoticeSdt">전화번호</label>
                     <!-- {{miss.officeTel}} <br> -->
                    <div>
                        <input
                          id="animalnoticeSdt"
                          type="text"
                          v-model="miss.officeTel"
                          class="form-control"
                          readonly
                        />
                    </div>
                  </div>
                  


                </div>
              </div>
            </div>
          </div>
          <!-- <div class="related-products-wrap">
            
          </div> -->
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
  props:{
    no:{
      type:Number,
    },
  },
  components: {},
  data: function(){
     return {
       miss: {}, 
       noticedt: "",
     }
  },
  created() {
    this.selectShel();
  },
  
  methods:{
    selectShel(){
      let headers = {
        'at-jwt-access-token': session.getItem('at-jwt-access-token'),
        'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
    };
    axios({
        method: 'get',
        url: '/api/shel/detail/' + this.no, // 여기 수정
        headers: headers, 
      }).then((res) => {
        this.$store.dispatch('login/accessTokenRefresh', res) 
        console.log(res);
        this.miss = res.data; // 여기 수정
        this.noticedt = this.miss.noticeSdt +" ~ " + this.miss.noticeEdt;
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
#app{

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
