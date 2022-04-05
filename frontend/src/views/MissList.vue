<template>
  <div id="app">
    <!-- main-area -->
    <main>
      <!-- breadcrumb-area -->
      <section
        class="breadcrumb-area breadcrumb-bg"
        style="background-image: url('/img/bg/banner2.jpg')"
      >
        <div class="container">
          <div class="row">
            <div class="col-12">
              <div class="breadcrumb-content">
                <h2 class="title">실종 동물</h2>
                <nav aria-label="breadcrumb">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                      <router-link to="/">홈</router-link>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                      실종 동물 목록
                    </li>
                  </ol>
                </nav>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- breadcrumb-area-end -->

      <!-- shop-area -->
      <div class="shop-area pt-110 pb-110">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-1"></div>
            <div class="col-lg-10">
              <div class="shop-wrap">
                <h4 class="title">실종 동물 목록 </h4>
                <li v-if="userInfoNo() != null" class="header-btn">
                        <router-link
                          to="/missWrite"
                          class="btn"
                          style="
                          float:right;
                            width: 110px;
                            height: 10px;
                            font-size: 17px;
                            padding: 19px 15px;
                          "
                          >글작성<img src="/img/icon/w_pawprint.png" alt=""
                  /></router-link>
                </li>
                <br>
                <br>
                <div
                  class="shop-page-meta"
                  style="display: block; height: 68px"
                >

                  <div class="shop-show-list"  style="float:left; margin-left:450px;">
                    <form action="#">
                      <label for="careAddr">지역</label>
                      <select id="careAddr" class="selected" v-model="search.happenPlace">
                        <option value="">전체</option>
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
                    </form>
                  </div>

                  <div
                    class="shop-show-list"
                    style="float: left; margin-left: 20px"
                  >
                    <form action="#">
                      <label for="kindCd">품종</label>
                      <input type="text" id="kindCd" class="selected" v-model="search.kindCd">
                    </form>
                  </div>

                  <div
                    class="shop-pagination"
                    style="
                      float: left;
                      margin-left: 10px;
                      margin-top: 2px;
                      cursor: pointer;
                    "
                  >
                    <ul @click="searchMissnimal">
                      <li class="active">
                        <a><i class="fas fa-search"></i></a>
                      </li>
                    </ul>
                  </div>
                </div>

                <div
                  class="row justify-content-center"
                  style="float: left; margin-top: 10px"
                  v-if="total != 0"
                >
                  <div
                    v-for="(miss, index) in missList"
                    v-bind:key="index"
                    style="width: 341px; height: 457px; padding: 10px;"
                  >
                    <div class="shop-item mb-55">
                      <div class="shop-thumb">
                        <router-link
                          :to="{ name: 'MissDetail', params: { no: miss.no } }"
                        >
                          <img
                            v-if="miss.profile"
                            :src="miss.profile"
                            style="width: 321px; height: 268px"
                            alt=""
                          />
                          <img
                            v-if="!miss.profile"
                            src="../assets/img/image.png"
                            style="background-color: #bcbcbc"
                            alt=""
                          />
                        </router-link>
                      </div>
                      <div class="shop-content">
                        <span>{{ miss.name }}</span>
                        <h4 class="title">
                          실종 날짜 : {{ miss.happenDt }}
                        </h4>
                        <div class="shop-content-bottom">
                            <span class="price">발생지역 : {{ miss.happenPlace }}</span>
                        </div>
                        <div class="shop-content-bottom">
                          <span class="price">특이사항 : {{ miss.descr }}</span>
                          <span class="add-cart">
                            <router-link
                              :to="{
                                name: 'MissDetail',
                                params: { no: miss.no },
                              }"
                            >
                              상세보기
                            </router-link>
                          </span>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>

                 <div v-if="total == 0" style="text-align: center; margin-top:20px">
                   <h3>조건에 맞는 검색 정보가 없습니다.</h3>
                    <h3>조건을 전체로 설정 후 한번 더 검색하시기 바랍니다.</h3>
                  <img src="/img/bg/logo5.png" alt="">
                </div>

                <div v-if="total != 0"
                  class="shop-page-meta"
                  style="
                    height: 60px;
                    width: 100%;
                    padding: 12px;
                    display: flex;
                    justify-content: center;
                  "
                >
                  <div class="shop-pagination" style="margin: 0px">
                    <ul>
                     <li>
                        <a v-show="pagegroup != 1" @click="pagegroup--"
                          ><i class="fas fa-angle-double-left"></i
                        ></a>
                      </li>
                      <li
                        @click="
                          searchMissnimalPage(index + 1 + (pagegroup - 1) * 10)
                        "
                        v-for="(shel, index) in pagegroup * 10 <= pagegroupmax
                          ? 10
                          : Math.ceil((total % 90)/9)"
                        v-bind:key="index"
                        :class="{
                          active: index + 1 + (pagegroup - 1) * 10 == page,
                        }"
                      >
                        <a>
                          {{ index + 1 + (pagegroup - 1) * 10 }}
                        </a>
                      </li>
                      <li>
                        <a
                          v-show="pagegroup * 10 < pagegroupmax"
                          @click="pagegroup++"
                          ><i class="fas fa-angle-double-right"></i
                        ></a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-1"></div>
          </div>
        </div>
      </div>
      <!-- shop-area-end -->
    </main>
    <!-- main-area-end -->
  </div>
</template>

<script>
import axios from "axios";
const session = window.sessionStorage;
export default {
  name: "App",
  components: {},
  data() {
    return {
      search: {
        happenPlace: null,
        kindCd: null,
      },
      pagegroupmax: 0,
      pagegroup: 1,
      page: 1,
      total: 0,
      missList: [],
    };
  },
  created() {
    this.searchMissnimaldefualt();
    this.$store.commit('setHaderindex',2);
  },
  methods: {
     userInfoNo(){
      if(session.getItem('userInfo') != null)
        return JSON.parse(session.getItem('userInfo')).no
      return null
    },
  
    searchMissnimaldefualt() {
      this.$store.commit('loading/load', true);
      axios({
        method: "get",
        url: "/api/misses/1",
      })
        .then((res) => {
          console.log(res.data);
          this.missList = null
          this.missList = res.data.missnimalDtos;
          this.total = res.data.allCount;
          this.pagegroupmax = Math.ceil(this.total / 9 )
        })
        .catch((error) => {
          console.log(error);
        }).finally(() => this.$store.commit('loading/load', false),
        console.log('searchMissnimaldefualt End!!'),
        )
    },

    searchMissnimal() {
      this.$store.commit('loading/load', true);
      this.page = 1

      let data = {
        careAddr: this.search.happenPlace,
        kindCd: this.search.kindCd,
        offset: 1,
      };

      axios({
        method: "post",
        url: "/api/miss/search",
        data: data,
      })
        .then((res) => {
          this.missList = ""
          this.missList = res.data.missnimalDtos;
          this.total = res.data.allCount;
          this.pagegroup = 1
          this.pagegroupmax = Math.ceil(this.total / 9 )
          console.log(res)
        })
        .catch((error) => {
          console.log(error);
           this.missList = ""
           this.total = 0
           this.pagegroupmax = 0
        }).finally(() => this.$store.commit('loading/load', false),
        console.log('searchMissnimal End!!'),
)
    },

    searchMissnimalPage(el) {
      this.$store.commit('loading/load', true);
      this.page = el

      let data = {
        careAddr: this.search.happenPlace,
        kindCd: this.search.kindCd,
        offset: el,
      };

      axios({
        method: "post",
        url: "/api/miss/search",
        data: data,
      })
        .then((res) => {
          this.missList = ""
          this.missList = res.data.missnimalDtos;
          this.total = res.data.allCount;
          this.pagegroup = 1
          this.pagegroupmax = Math.ceil(this.total / 9 )
          console.log(res)
        })
        .catch((error) => {
          console.log(error);
           this.missList = ""
           this.total = 0
           this.pagegroupmax = 0
        }).finally(() => this.$store.commit('loading/load', false),
        console.log('searchMissnimalPage End!!'),
        window.scrollTo(0,380),
        )
    },
  },
};
</script>


<style>
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
