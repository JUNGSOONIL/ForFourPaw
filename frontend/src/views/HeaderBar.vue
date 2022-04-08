<template>
  <div id="app">
    <!-- Preloader -->
    <!-- <div id="preloader">
      <img src="/img/preloader.gif" alt="" />
    </div> -->
    <!-- Preloader-end -->

    <!-- Scroll-top -->
    <button style="margin-right:60px" class="scroll-top scroll-to-target" @click="$router.go(-1)">
      <i class="fas fa-angle-left"></i>
    </button>
    <button class="scroll-top scroll-to-target" onclick="window.scrollTo(0,0);">
      <i class="fas fa-angle-up"></i>
    </button>
    <!-- Scroll-top-end-->

    <!-- header-area -->
    <header>
      <div id="sticky-header" class="menu-area">
        <div class="container custom-container">
          <div class="row">
            <div class="col-12">
              <div class="mobile-nav-toggler"><i class="fas fa-bars"></i></div>
              <div class="menu-wrap">
                <nav class="menu-nav show">
                  <div class="logo">
                    <router-link to="/"
                      ><img
                        src="/img/logo/paw_logo_2line.png"
                        alt=""
                        onclick="window.scrollTo(0,0);"
                    /></router-link>
                  </div>
                  <div class="navbar-wrap main-menu d-none d-lg-flex">
                    <ul class="navigation">
                      <li
                        class="menu-item-has-children"
                        :class="{
                          active: this.$store.getters.getHaderindex == 0,
                        }"
                      >
                        <router-link to="/" style="font-family:RFR; font-size:20px"> 홈</router-link>
                      </li>
                      <!-- 헤더-유기동물 -->
                      <li
                        class="menu-item-has-children"
                        :class="{
                          active: this.$store.getters.getHaderindex == 1,
                        }"
                      >
                        <router-link to="/shelList" style="font-family:RFR; font-size:20px"> 유기동물</router-link>
                      </li>
                      <!-- 헤더-실종동물 -->
                      <li
                        class="menu-item-has-children"
                        :class="{
                          active: this.$store.getters.getHaderindex == 2,
                        }"
                      >
                        <router-link to="/missList" style="font-family:RFR; font-size:20px"> 실종동물</router-link>
                      </li>
                      <li
                        class="menu-item-has-children"
                        :class="{
                          active: this.$store.getters.getHaderindex == 3,
                        }"
                      >
                        <router-link to="/analysisview" style="font-family:RFR; font-size:20px">  데이터 분석</router-link
                        >
                      </li>
                    </ul>
                  </div>
                  <div class="header-action d-none d-md-block">
                    <ul>
                      <li
                        class="header-btn"
                        style="margin: 1px"
                        v-if="isLoginGetters"
                      >
                        <router-link
                          to="/userPage"
                          class="btn"
                          style="
                            width: 100%;
                            height: 10px;
                            font-size: 17px;
                            padding: 19px 15px;
                            font-family:RFR; 
                            font-size:20px;
                          "
                        >
                          내정보<img src="/img/icon/w_pawprint.png" alt=""
                        /></router-link>
                      </li>
                      <li class="header-btn" v-if="!isLoginGetters">
                        <router-link
                          to="/socialLogin"
                          class="btn"
                          style="
                            width: 100%;
                            height: 10px;
                            font-size: 17px;
                            padding: 19px 15px;
                            font-family:RFR; 
                            font-size:20px;
                          "
                          >로그인<img src="/img/icon/w_pawprint.png" alt=""
                        /></router-link>
                      </li>
                      <li class="header-btn" v-if="activeMoreInfo">
                        <router-link
                          to="/moreInfo"
                          class="btn"
                          style="
                            width: 100%;
                            height: 10px;
                            font-size: 17px;
                            padding: 19px 15px;
                            font-family:RFR; 
                            font-size:20px;
                          "
                          >추가정보<img src="/img/icon/w_pawprint.png" alt=""
                        /></router-link>
                      </li>
                      <li class="header-btn" v-if="isLoginGetters">
                        <router-link
                          style="
                            width: 100%;
                            height: 10px;
                            font-size: 17px;
                            padding: 19px 15px;
                            font-family:RFR; 
                            font-size:20px;
                          "
                          :to="{
                            name: `LogoutPage`,
                            params: { msg: `로그아웃` },
                          }"
                          class="btn"
                          @click.native="logout"
                          >로그아웃<img src="/img/icon/w_pawprint.png" alt=""
                        /></router-link>
                      </li>
                    </ul>
                  </div>
                </nav>
              </div>
              <!-- Mobile Menu  -->
              <div class="mobile-menu">
                <nav class="menu-box">
                  <div class="close-btn"><i class="fas fa-times"></i></div>
                  <div class="nav-logo">
                    <a href="index.html"
                      ><img src="/img/logo/logo.png" alt="" title=""
                    /></a>
                  </div>
                  <div class="menu-outer">
                    <!--Here Menu Will Come Automatically Via Javascript / Same Menu as in Header-->
                  </div>
                  <div class="social-links">
                    <ul class="clearfix">
                      <li>
                        <a href="#"><span class="fab fa-twitter"></span></a>
                      </li>
                      <li>
                        <a href="#"
                          ><span class="fab fa-facebook-square"></span
                        ></a>
                      </li>
                      <li>
                        <a href="#"><span class="fab fa-pinterest-p"></span></a>
                      </li>
                      <li>
                        <a href="#"><span class="fab fa-instagram"></span></a>
                      </li>
                      <li>
                        <a href="#"><span class="fab fa-youtube"></span></a>
                      </li>
                    </ul>
                  </div>
                </nav>
              </div>
              <div class="menu-backdrop"></div>
              <!-- End Mobile Menu -->
            </div>
          </div>
        </div>
        <div
          class="header-shape"
          style="background-image: url('/img/bg/header_shape.png')"
        ></div>
      </div>
      <!-- header-search -->
      <div
        class="search-popup-wrap"
        tabindex="-1"
        role="dialog"
        aria-hidden="true"
      >
        <div class="search-close">
          <span><i class="fas fa-times"></i></span>
        </div>
        <div class="search-wrap text-center">
          <div class="container">
            <div class="row">
              <div class="col-12">
                <h2 class="title">... Search Here ...</h2>
                <div class="search-form">
                  <form action="#">
                    <input
                      type="text"
                      name="search"
                      placeholder="Type keywords here"
                    />
                    <button class="search-btn">
                      <i class="fas fa-search"></i>
                    </button>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- header-search-end -->
    </header>
    <!-- header-area-end -->
  </div>
</template>

<script>
const session = window.sessionStorage;

export default {
  data() {
    return {
      navclick: 0,
    };
  },
  computed: {
    isLoginGetters() {
      return session.getItem("userInfo");
    },
    userInfoGetters() {
      return this.$store.getters["login/userInfo"];
    },
    activeMoreInfo() {
      let isAddrsvalidate = false;
      if (this.userInfoGetters != null && this.userInfoGetters.addrs != "") {
        isAddrsvalidate = true;
      }
      return this.isLoginGetters && !isAddrsvalidate;
    },
  },
  methods: {
    logout: function () {
      // this.$store.state.login.isLogin = false;
      this.$store.commit("login/SET_LOGOUT");
      session.clear();
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

@font-face{
  font-family:"kyobo";
  src:url("../assets/fonts/KyoboHandwriting2020pdy.ttf");
}
</style>
