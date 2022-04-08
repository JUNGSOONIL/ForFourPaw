<template>
  <div id="app">
    <!-- main-area -->
    <main>
      <!-- slider-area -->
      <section class="slider-area">
        <div class="slider-active">
          <div
            class="single-slider slider-bg d-flex align-items-center"
            style="background-image: url('/img/slider/hifive.jpg')"
          >
            <div class="container custom-container">
              <div class="row">
                <div class="col-xl-5 col-lg-7 col-md-10">
                  <div class="slider-content">
                    <div class="slider-title">
                      <h2
                        class="title"
                        style="font-size:80px"
                        data-animation="fadeInUpBig"
                        data-delay=".2s"
                        data-duration="1.2s"
                      >
                        <!-- For<span>with</span><br />Four<br />Paw -->
                        For<br />Four<br />Paw
                      </h2>
                    </div>
                    <div class="slider-desc">
                      <p
                        class="desc"
                        data-animation="fadeInUpBig"
                        data-delay=".4s"
                        data-duration="1.2s"
                      ></p>
                        <h1 style="font-family:SLE;color:#d30000; text-shadow: -1px 0 white, 0 1px white, 1px 0 white, 0 -1px white; font-size:30px"> For Four Paw 는 <br/> 유기동물 빅데이터를 활용한 <br/> 매칭 사이트 입니다 </h1>
                      
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="slider-shape">
          <img src="/img/slider/slider_shape01.png" alt="" />
        </div>
        <div class="slider-shape shape-two">
          <img src="/img/slider/slider_shape02.png" alt="" />
        </div>
      </section>
     
      <section
        class="counter-area counter-bg"
        style="background-image: url('/img/bg/counter_bg.jpg')"
      >
        <div v-if="maincnt.protect != 0" class="container">
          <div class="row justify-content-center">
            <div class="col-lg-3 col-md-4 col-sm-6">
              <div class="counter-item">
                <h2 class="count">
                  <span class="odometer">{{ maincnt.today }}</span>
                </h2>
                <p>오늘 추가된 유기 동물</p>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6">
              <div class="counter-item">
                <h2 class="count">
                  <span class="odometer">{{ maincnt.protect }}</span>
                </h2>
                <p>최근 한달 간 보호</p>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6">
              <div class="counter-item">
                <h2 class="count">
                  <span class="odometer">{{ maincnt.return }}</span>
                </h2>
                <p>최근 한달 간 반환</p>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6">
              <div class="counter-item">
                <h2 class="count">
                  <span class="odometer">{{ maincnt.death }}</span>
                </h2>
                <p>최근 한달 간 사망</p>
              </div>
            </div>
          </div>
        </div>
      </section>
    

      <!-- adoption-shop-area -->
      <section class="adoption-shop-area">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-xl-12 col-lg-9">
              <div class="section-title text-center mb-65">
                <div class="section-icon">
                  <img src="/img/icon/pawprint.png" alt="" />
                </div>
                <h5 class="sub-title">도와주세요</h5>
                <h2 class="title">
                  혼자 남은 아이들을 위해 <br />
                  함께 할 수 있는 가족이 되어주세요
                </h2>
              </div>
            </div>
          </div>
          <div class="row justify-content-center">
            <div
              class="col-lg-4 col-md-6"
              v-for="(shelnimal, index) in this.$store.state[`mainView`]
                .shelnimal.list"
              v-bind:key="index"
            >
              <div class="adoption-shop-item">
                <div class="adoption-shop-thumb">
                  <img
                    style="width: 380px; height: 381px"
                    :src="shelnimal.popfile"
                    alt=""
                  />
                  <router-link
                    :to="{
                      name: 'ShelDetail',
                      params: { no: shelnimal.desertionNo },
                    }"
                    class="btn"
                    >보러가기<img src="img/icon/w_pawprint.png" alt=""
                  /></router-link>
                </div>
                <div class="adoption-shop-content">
                  <h4 class="title"></h4>
                  <div class="adoption-meta">
                    <ul>
                      <li>
                        <i class="fa fa-hashtag"></i
                        > &nbsp; {{ shelnimal.kindCd }}
                      </li>
                      <li>
                        <i class="fa fa-align-justify"></i> &nbsp; {{ shelnimal.age }}
                      </li>
                    </ul>
                  </div>
                  <div class="adoption-rating">
                    <ul>
                      <li><i class="fa fa-asterisk"></i> &nbsp;  {{ shelnimal.specialMark }} </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- adoption-shop-area-end -->

      <!-- testimonial-area -->
      <section class="testimonial-area testimonial-bg">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-xl-7 col-lg-9">
              <div class="section-title text-center mb-65">
                <div class="section-icon">
                  <img src="/img/icon/pawprint.png" alt="" />
                </div>
                <h5 class="sub-title">준비해봤어요</h5>
                <h2 class="title">도움이 될만한 사이트를 <br />준비해봤어요</h2>
                <!-- <p>
                  The best overall dog DNA test is Embark Breed & Health Kit
                  (view at Chewy), which provides you with a breed brwn and
                  information Most dogs
                </p> -->
              </div>
            </div>
          </div>
          <div class="row testimonial-active">
            <div class="col-lg-6">
              <div class="testimonial-item">
                <div class="testi-avatar-thumb">
                  <img src="/img/logo/character.png" alt="" />
                </div>
                <div class="testi-content">
                  <div class="testi-avatar-info">
                    <h5 class="title">
                      <a href="http://www.animal.go.kr">동물보호관리시스템</a>
                    </h5>
                  </div>
                  <p>
                    농림축산식품부에서 운영하는 동물보호관리시스템 입니다.
                    동물을 잃어버린 경우, 동물의 입양을 희망하는 경우 이용을
                    추천드립니다.
                  </p>
                </div>
              </div>
            </div>
            <div class="col-lg-6">
              <div class="testimonial-item">
                <div class="testi-avatar-thumb">
                  <img src="/img/logo/character.png" alt="" />
                </div>
                <div class="testi-content">
                  <div class="testi-avatar-info">
                    <h5 class="title">
                      <a href="https://mypetlife.co.kr/">비마이펫 라이프</a>
                    </h5>
                  </div>
                  <p>
                    반려동물의 건강, 행동에서부터 생활 팁까지. 다양한 지식정보
                    콘텐츠를 전문가 및 출판사 등과 협력하여 발행하는 사이트
                    입니다
                  </p>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
   
      <!-- faq-area -->
      <section class="faq-area">
        <div class="container">
          <br />
          <br />
          <div class="row align-items-center">
            <div class="col-lg-12">
              <div class="faq-img-wrap">
                <table
                  align="center"
                  width="1162"
                  height="695"
                  background="img/images/faq_tv.png"
                  border="0"
                  cellspacing="0"
                  cellpadding="0"
                >
                  <tr>
                    <td height="180"></td>
                  </tr>
                  <tr>
                    <td height="225" align="center">
                      <video height="450" width="900" controls>
                        <source src="video/test.mp4" type="video/mp4" />
                        이 문장은 여러분의 브라우저가 video 태그를 지원하지 않을
                        때 화면에 표시됩니다!
                      </video>
                    </td>
                    <td width="100"></td>
                  </tr>
                  <tr>
                    <td height="35"></td>
                  </tr>
                </table>
              </div>
            </div>
          </div>
        </div>
        <br />
        <br />
      </section>
      <!-- faq-area-end -->
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
      maincnt: {
        today: 0,
        protect: 0,
        return: 0,
        death: 0,
      },
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
    };
  },
  created() {
    this.$store.commit("setHaderindex", 0);
    if (session.getItem("userInfo") == null) {
      this.shelimalList();
    } else {
      this.shelimalListLogin();
    }
    this.selectmaincnt();
  },
  mounted() {
    // window.addEventListener('beforeunload', this.clearStorage)
  },
  methods: {
    // clearStorage() {
    //   localStorage.removeItem('vuex');
    // },
    shelimalList() {
      this.$store.dispatch("mainView/mainShelnimalList");
    },
    shelimalListLogin() {
      this.$store.dispatch("mainView/mainShelnimalListLogin");
    },
    selectmaincnt() {
      this.$store.commit("loading/load", true);
      axios({
        method: "get",
        url: "/api/dataset/",
      })
        .then((res) => {
          this.maincnt = res.data;
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(
          () => this.$store.commit("loading/load", false),
        );
    },
  },
};
</script>

<style>

@font-face {
  font-family: "RFR";
  src: url("../assets/fonts/EliceDigitalRegular.ttf");
}

@font-face {
  font-family: "LeferiBaseBold";
  src: url("../assets/fonts/LeferiBaseBold.ttf");
}

@font-face {
  font-family: "SLE";
  src: url("../assets/fonts/SLEIGothicTTF.ttf");
}


</style>
