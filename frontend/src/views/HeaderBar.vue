<template>
  <div id="app">
    <!-- Preloader -->
    <div id="preloader">
      <img src="img/preloader.gif" alt="" />
    </div>
    <!-- Preloader-end -->

    <!-- Scroll-top -->
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
                      ><img src="img/logo/paw_logo_2line.png" alt=""
                    /></router-link>
                  </div>
                  <div class="navbar-wrap main-menu d-none d-lg-flex">
                    <ul class="navigation">
                      <li class="active menu-item-has-children">
                        <router-link to="/">홈</router-link>
                      </li>
                      <!-- 헤더-유기동물 -->
                      <li class="menu-item-has-children">
                        <router-link to="/shop">유기동물</router-link>

                        <ul class="submenu">
                          <li>
                            <router-link to="/shop">Our Shop</router-link>
                          </li>
                          <li>
                            <router-link to="/shopDetail"
                              >Shop Details</router-link
                            >
                          </li>
                        </ul>
                      </li>
                      <!-- 헤더-실종동물 -->
                      <li class="menu-item-has-children">
                        <router-link to="/shop">실종동물</router-link>

                        <ul class="submenu">
                          <li>
                            <router-link to="/missList"
                              >실종동물 목록</router-link
                            >
                          </li>
                          <li>
                            <router-link to="/missWrite"
                              >실종동물 추가</router-link
                            >
                          </li>
                          <li>
                            <router-link to="/missDetail"
                              >실종동물 상세</router-link
                            >
                          </li>
                          <!-- <li>
                            <router-link to="/shelDetail"
                              >유기동물 상세</router-link
                            >
                          </li> -->
                        </ul>
                      </li>
                      <li><router-link to="/dogList">Dog List</router-link></li>
                      <li class="menu-item-has-children">
                        <router-link to="/shop">Shop</router-link>

                        <ul class="submenu">
                          <li>
                            <router-link to="/shop">Our Shop</router-link>
                          </li>
                          <li>
                            <router-link to="/shopDetail"
                              >Shop Details</router-link
                            >
                          </li>
                        </ul>
                      </li>
                      <li class="menu-item-has-children">
                        <router-link to="/blog">Blog</router-link>
                        <ul class="submenu">
                          <li>
                            <router-link to="/blog">Our Blog</router-link>
                          </li>
                          <li>
                            <router-link to="/blogDetail"
                              >Blog Details</router-link
                            >
                          </li>
                        </ul>
                      </li>
                      <!-- <li><a href="adoption.html">Adoption</a></li> -->
                      <!-- <li class="menu-item-has-children">
                        <a href="breeder.html">Breeder</a>
                        <ul class="submenu">
                          <li><a href="breeder.html">Our Breeder</a></li>
                          <li>
                            <a href="breeder-details.html">Breeder Details</a>
                          </li>
                        </ul>
                      </li> -->

                      <!-- <li><a href="contact.html">contacts</a></li> -->
                    </ul>
                  </div>
                  <div class="header-action d-none d-md-block">
                    <ul>
                      <!-- <li class="header-search">
                        <a href="#"><i class="flaticon-search"></i></a>
                      </li>
                      <li class="header-shop-cart">
                        <a href="#"
                          ><i class="flaticon-shopping-bag"></i
                          ><span>2</span></a
                        >
                        <ul class="minicart">
                          <li class="d-flex align-items-start">
                            <div class="cart-img">
                              <a href="#"
                                ><img src="img/product/cart_p01.jpg" alt=""
                              /></a>
                            </div>
                            <div class="cart-content">
                              <h4><a href="#">The King Charles Spaniel</a></h4>
                              <div class="cart-price">
                                <span class="new">$229.9</span>
                                <span><del>$229.9</del></span>
                              </div>
                            </div>
                            <div class="del-icon">
                              <a href="#"><i class="far fa-trash-alt"></i></a>
                            </div>
                          </li>
                          <li class="d-flex align-items-start">
                            <div class="cart-img">
                              <a href="#"
                                ><img src="img/product/cart_p02.jpg" alt=""
                              /></a>
                            </div>
                            <div class="cart-content">
                              <h4><a href="#">The Labrador Retriever</a></h4>
                              <div class="cart-price">
                                <span class="new">$229.9</span>
                                <span><del>$229.9</del></span>
                              </div>
                            </div>
                            <div class="del-icon">
                              <a href="#"><i class="far fa-trash-alt"></i></a>
                            </div>
                          </li>
                          <li>
                            <div class="total-price">
                              <span class="f-left">Total:</span>
                              <span class="f-right">$239.9</span>
                            </div>
                          </li>
                          <li>
                            <div class="checkout-link">
                              <a href="#">Shopping Cart</a>
                              <a class="black-color" href="#">Checkout</a>
                            </div>
                          </li>
                        </ul>
                      </li> -->
                      <li class="header-btn" v-if="!isLoginGetters">
                        <router-link to="/socialLogin" class="btn"
                          >로그인<img src="img/icon/w_pawprint.png" alt=""
                        /></router-link>
                      </li>
                      <li class="header-btn" v-if="isLoginGetters">
                        <router-link to="/moreInfo" class="btn"
                          >추가정보<img src="img/icon/w_pawprint.png" alt=""
                        /></router-link>
                      </li>
                      <li class="header-btn" v-if="isLoginGetters">
                        <router-link
                          to="/logoutPage"
                          class="btn"
                          @click.native="logout"
                          >로그아웃<img src="img/icon/w_pawprint.png" alt=""
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
                      ><img src="img/logo/logo.png" alt="" title=""
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
          style="background-image: url('img/bg/header_shape.png')"
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
  computed: {
    isLoginGetters() {
      return this.$store.getters["login/isLogin"];
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

<style></style>
