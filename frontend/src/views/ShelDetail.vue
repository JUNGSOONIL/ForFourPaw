<template>
  <div id="app">
    <!-- main-area -->
    <main>
      <!-- breadcrumb-area -->
      <section
        class="breadcrumb-area breadcrumb-bg"
        style="background-image: url('/img/bg/drinking_dog.jpg')"
      >
        <div class="container">
          <div class="row">
            <div class="col-12">
              <div class="breadcrumb-content">
                <h2 class="title">유기 동물</h2>
                <nav
                  style="
                    background-color: #f5f2eb;
                    width: 270px;
                    border-radius: 15px 15px 40px 15px;
                  "
                  aria-label="breadcrumb"
                >
                  <ol style="margin-left: 20px" class="breadcrumb">
                    <li class="breadcrumb-item" aria-current="page">
                      <router-link style="color: gray" to="/shelList"
                        >유기 동물 공고</router-link
                      >
                    </li>
                    <li class="breadcrumb-item" aria-current="page">
                      <router-link to="/shelDetail">유기 동물 상세</router-link>
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
      <section class="shop-details-area pt-30 pb-60">
        <div class="container">
          <div class="shop-details-wrap">
            <div class="row">
              <h4 style="margin-left: 12px; width: 100%" class="title">
                유기 동물 상세
              </h4>
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
                        <img
                          v-if="!miss.popfile"
                          src="../assets/img/image.png"
                          alt=""
                          style="
                            background-color: #bcbcbc;
                            width: 616px;
                            height: 568px;
                            border-radius: 10px
                            border: 2px solid #f5f2eb;
                          "
                        />
                        <img
                          v-else
                          :src="miss.popfile"
                          alt=""
                          style="
                            background-color: #f5f2eb;
                            width: 616px;
                            height: 568px;
                             border-radius: 10px
                             border: 2px solid #f5f2eb;
                          "
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
                    border-radius: 10px;
                    background-color: #f5f2eb;
                    padding: 10px;
                    width: 586px;
                    height: 568px;
                    overflow: auto;
                  "
                >
                  <div class="shop-details-price">
                    <h2 class="price">동물 정보</h2>
                    <h5 class="stock-status">- Animal</h5>
                  </div>
                  <div class="shop-details-dimension">
                    <label for="processState">상태</label>
                    <input
                      id="processState"
                      type="text"
                      v-model="miss.processState"
                      class="form-control"
                      style="background-color: white"
                      disabled
                    />
                    <label for="animalKind">품종</label>
                    <input
                      id="animalKind"
                      type="text"
                      v-model="miss.kindCd"
                      class="form-control"
                      style="background-color: white"
                      disabled
                    />
                    <label for="animalColor">색상</label>
                    <input
                      id="animalColor"
                      type="text"
                      v-model="miss.colorCd"
                      class="form-control"
                      style="background-color: white"
                      disabled
                    />
                    <label for="animalAge">나이</label>
                    <input
                      id="animalAge"
                      type="text"
                      v-model="miss.age"
                      class="form-control"
                      style="background-color: white"
                      disabled
                    />
                    <label for="animalSex">성별</label>
                    <input
                      id="animalSex"
                      type="text"
                      v-model="miss.sexCd"
                      class="form-control"
                      style="background-color: white"
                      disabled
                    />
                    <label for="animalneuter">중성화</label>
                    <input
                      id="animalneuter"
                      type="text"
                      v-model="miss.neuterYn"
                      class="form-control"
                      style="background-color: white"
                      disabled
                    />
                    <label for="animalDesc">특이사항</label>
                    <textarea
                      id="animalDesc"
                      type="text"
                      v-model="miss.specialMark"
                      class="form-control"
                      style="background-color: white"
                      disabled
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
                      style="background-color: white"
                      disabled
                    />
                    <label for="animalHappenPlace">발생장소</label>
                    <div>
                      <input
                        id="animalHappenPlace"
                        type="text"
                        v-model="miss.happenPlace"
                        class="form-control"
                        style="background-color: white"
                        disabled
                      />
                    </div>
                    <label for="animalnoticeSdt">공고기간</label>
                    <div>
                      <input
                        id="animalnoticeSdt"
                        type="text"
                        v-model="noticedt"
                        class="form-control"
                        style="background-color: white"
                        disabled
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
                      style="background-color: white"
                      disabled
                    />
                    <label for="animalHappenPlace">보호소 위치</label>
                    <div>
                      <input
                        id="animalHappenPlace"
                        type="text"
                        v-model="miss.careAddr"
                        class="form-control"
                        style="background-color: white"
                        disabled
                      />
                    </div>
                    <label for="animalnoticeSdt">보호소 전화번호</label>
                    <div>
                      <input
                        id="animalnoticeSdt"
                        type="text"
                        v-model="miss.careTel"
                        class="form-control"
                        style="background-color: white"
                        disabled
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
                      style="background-color: white"
                      disabled
                    />
                    <label for="animalHappenPlace">담당자</label>
                    <!-- {{miss.chargeNm}} <br> -->
                    <div>
                      <input
                        id="animalHappenPlace"
                        type="text"
                        v-model="miss.chargeNm"
                        class="form-control"
                        style="background-color: white"
                        disabled
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
                        style="background-color: white"
                        disabled
                      />
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-12">
              <div class="product-desc-wrap" style="padding-top: 15px">
                <ul class="nav nav-tabs" id="myTabTwo" role="tablist">
                  <li class="nav-item">
                    <a
                      class="nav-link active"
                      id="review-tab"
                      data-toggle="tab"
                      href="#review"
                      role="tab"
                      aria-controls="review"
                      aria-selected="false"
                      >약관</a
                    >
                  </li>
                </ul>

                <div class="tab-content" id="myTabContentTwo">
                  <div
                    class="tab-pane fade show active"
                    id="review"
                    role="tabpanel"
                    aria-labelledby="details-tab"
                  >
                    <div class="product-desc-content">
                      <p>
                        「동물보호법」 제17조, 시행령7조 및 동법 시행규칙
                        제20조에 따라 유기·유실동물을 보호하고 있는 경우에는
                        소유자 등이 보호조치 사실을 알 수 있도록 7일 동안
                        공고하여야 합니다. 공고 중인 동물 소유자는 해당 시군구
                        및 동물보호센터에 문의하시어 동물을 찾아가시기 바랍니다.
                        다만, 「동물보호법」 제19조 및 동법 시행규칙 제21조에
                        따라 소유자에게 보호비용이 청구될 수 있습니다.
                        <br />또한 「동물보호법」 제17조에 따른 공고가 있는
                        날부터 10일이 경과하여도 소유자 등을 알 수 없는 경우에는
                        「유실물법」 제12조 및 「민법」 제253조의 규정에도
                        불구하고 해당 시·도지사 또는 시장·군수·구청장이 그
                        동물의 소유권을 취득하게 됩니다.
                      </p>
                    </div>
                  </div>
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
import axios from "axios";
const session = window.sessionStorage;

export default {
  name: "App",
  props: {
    no: {
      type: String,
    },
  },
  components: {},
  data: function () {
    return {
      miss: {},
      noticedt: "",
    };
  },
  created() {
    this.$store.commit("setHaderindex", 1);
    this.selectShel();
  },

  mounted() {},

  methods: {
    userInfoNo() {
      if (session.getItem("userInfo") != null)
        return JSON.parse(session.getItem("userInfo")).no;
      return null;
    },
    changeDateString(date) {
      var year = date.substr(0, 4);
      var month = date.substr(4, 2);
      var day = date.substr(6, 2);
      return year + "-" + month + "-" + day;
    },
    selectShel() {
      axios({
        method: "get",
        url: "/api/shel/detail/" + this.no, // 여기 수정
      })
        .then((res) => {
          this.miss = res.data; // 여기 수정
          this.miss.happenDt = this.changeDateString(this.miss.happenDt);
          this.noticedt =
            this.changeDateString(this.miss.noticeSdt) +
            " ~ " +
            this.changeDateString(this.miss.noticeEdt);
          if (this.userInfoNo != null) {
            this.viewStore();
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },

    viewStore() {
      let data = {
        no: JSON.parse(session.getItem("userInfo")).no,
        desertionNo: this.miss.desertionNo,
      };

      axios({
        method: "post",
        url: "/api/shel/view/detail",
        data: data,
      }).catch((error) => {
        if (error.response.data.message != "중복") {
          console.log(error);
        }
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
  background-color: rgba(0, 0, 0, 0); /*스크롤바 트랙 색상*/
}
</style>
