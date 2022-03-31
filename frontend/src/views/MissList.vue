<template>
  <div id="app">
    <!-- main-area -->
    <main>
      <!-- newsletter-area -->
      <div class="newsletter-area pb-50">
        <div class="container">
          <div class="row">
            <div class="col-12">
              <div class="newsletter-wrap">
                <form action="#">
                  <div class="col-md-3 form-grp">
                    <label class="select-label input-non-point">조건</label>
                    <select
                      @change="change"
                      v-model="addrs"
                      class="form-control"
                      name="조건1"
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
                  <div class="col-md-3 form-grp">
                    <label class="input-non-point">조건</label>
                    <select
                      @change="change"
                      v-model="addrs"
                      class="form-control"
                      name="조건1"
                    >
                      <option value="서울특별시">서울특별시</option>
                    </select>
                  </div>
                  <div class="col-md-3 form-grp">
                    <label class="input-non-point">조건</label>
                    <select
                      @change="change"
                      v-model="addrs"
                      class="form-control"
                      name="조건1"
                    >
                      <option value="서울특별시">서울특별시</option>
                    </select>
                  </div>
                  <div class="col-md-3 form-grp">
                    <button
                      id="searchBtn"
                      type="button"
                      class="btn"
                      @click="handleClickKaKaoSignin"
                    >
                      검색
                    </button>
                  </div>
                </form>
                <div class="newsletter-shape">
                  <img src="/img/images/newsletter_shape01.png" alt="" />
                </div>
                <div class="newsletter-shape shape-two">
                  <img src="/img/images/newsletter_shape02.png" alt="" />
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- newsletter-area-end -->

      <!-- carousel-area-start -->
      <section class="adoption-area-two pt-110 pb-110">
        <div class="container custom-container">
          <div class="adopt-active">
            <Slick ref="slick" :options="slickOptions">
              <!-- v-for 형태 -->
              <div
                v-for="animal in list"
                :key="animal.no"
                class="adoption-item"
              >
                <div class="adopt-thumb">
                  <router-link to="/">
                    <img src="/img/images/adop_img01.png" alt="" />
                  </router-link>
                </div>
                <div class="adopt-content">
                  <h3 class="title">
                    {{ animal.name }}
                  </h3>
                  <p>
                    품종 : {{ animal.kind }}<br />
                    실종지역 : {{ animal.miss_addr }}
                  </p>
                </div>
              </div>
            </Slick>
          </div>
        </div>
      </section>
      <!-- carousel-area-end -->
    </main>
    <!-- main-area-end -->
  </div>
</template>

<script>
import axios from "axios";
import Slick from "vue-slick";
const session = window.sessionStorage;

export default {
  name: "DogList",
  components: {
    Slick,
  },
  data() {
    return {
      slickOptions: {
        dots: false,
        infinite: true,
        speed: 1000,
        autoplay: false,
        arrows: true,
        autoplaySpeed: 3000,
        prevArrow:
          '<button type="button" class="slick-prev"><img src="/img/icon/arrow.png" /></button>',
        nextArrow:
          '<button type="button" class="slick-next"><img src="/img/icon/arrow.png" /></button>',
        slidesToShow: 4,
        slidesToScroll: 1,
        responsive: [
          {
            breakpoint: 1200,
            settings: {
              slidesToShow: 3,
              slidesToScroll: 1,
              infinite: true,
            },
          },
          {
            breakpoint: 992,
            settings: {
              slidesToShow: 2,
              slidesToScroll: 1,
              speed: 1000,
            },
          },
          {
            breakpoint: 767,
            settings: {
              slidesToShow: 2,
              slidesToScroll: 1,
              arrows: false,
              speed: 1000,
            },
          },
          {
            breakpoint: 575,
            settings: {
              slidesToShow: 1,
              slidesToScroll: 1,
              arrows: false,
              speed: 1000,
            },
          },
        ],
      },
      list: [
        {
          no: 1,
          name: "이름1",
          kind: "종1",
          miss_addr: "지역1",
        },
        {
          no: 2,
          name: "이름2",
          kind: "종2",
          miss_addr: "지역2",
        },
        {
          no: 3,
          name: "이름3",
          kind: "종3",
          miss_addr: "지역3",
        },
        {
          no: 4,
          name: "이름4",
          kind: "종4",
          miss_addr: "지역4",
        },
        {
          no: 5,
          name: "이름5",
          kind: "종5",
          miss_addr: "지역5",
        },
      ],
    };
  },
  methods: {
    GetAnimalstest() {
      let headers = {
        "at-jwt-access-token": session.getItem("at-jwt-access-token"),
        "at-jwt-refresh-token": session.getItem("at-jwt-refresh-token"),
      };
      let data = {
        name: "",
        type: "",
      };

      axios({
        method: "get",
        url: "/api/qss/list",
        data: data, // post 나 put에 데이터 넣어 줄때
        headers: headers, // 넣는거 까먹지 마세요
      })
        .then((res) => {
          this.$store.dispatch("login/accessTokenRefresh", res); // store아닌곳에서
          this.dispatch("accessTokenRefresh", res); // store에서
        })
        .catch((error) => {
          console.log(error);
        })
        .then(() => {
          console.log("getQSSList End!!");
        });
    },
  },
};
</script>

<style scoped>
#searchBtn {
  width: 100%;
  padding-left: 40%;
  border: solid;
  border-color: #0a303a;
}
.input-non-point {
  cursor: default;
  font-size: 17px;
  font-weight: 700;
  color: #0a303a;
  font-family: "Poppins", sans-serif;
}
.newsletter-wrap {
  display: block;
  padding-right: 60px;
}
.form-grp {
  display: inline-block;
}
</style>
