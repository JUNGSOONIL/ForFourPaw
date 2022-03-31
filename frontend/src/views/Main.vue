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
                      >
                        For Four Paw 에서는 유기동물 및 실종동물을 조회할 수
                        있습니다.
                      </p>
                    </div>
                    <!-- <a
                      href="dog-list.html"
                      class="btn"
                      data-animation="fadeInUpBig"
                      data-delay=".6s"
                      data-duration="1.2s"
                      >View More <img src="/img/icon/w_pawprint.png" alt=""
                    /></a> -->
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- <div
            class="single-slider slider-bg d-flex align-items-center"
            style="background-image: url('/img/slider/slider_bg02.jpg')"
          >
            <div class="container custom-container">
              <div class="row">
                <div class="col-xl-5 col-lg-7 col-md-10">
                  <div class="slider-content">
                    <div class="slider-title">
                      <h2
                        class="title"
                        data-animation="fadeInUpBig"
                        data-delay=".2s"
                        data-duration="1.2s"
                      >
                        Best Friend <span>with</span> Happy Time
                      </h2>
                    </div>
                    <div class="slider-desc">
                      <p
                        class="desc"
                        data-animation="fadeInUpBig"
                        data-delay=".4s"
                        data-duration="1.2s"
                      >
                        Human Shampoo on Dogs After six days of delirat, the
                        jury found Hernandez guilty of first-degree murder
                      </p>
                    </div>
                    <a
                      href="dog-list.html"
                      class="btn"
                      data-animation="fadeInUpBig"
                      data-delay=".6s"
                      data-duration="1.2s"
                      >View More <img src="/img/icon/w_pawprint.png" alt=""
                    /></a>
                  </div>
                </div>
              </div>
            </div>
          </div> -->
        </div>
        <div class="slider-shape">
          <img src="/img/slider/slider_shape01.png" alt="" />
        </div>
        <div class="slider-shape shape-two">
          <img src="/img/slider/slider_shape02.png" alt="" />
        </div>
      </section>
      <!-- slider-area-end -->

      <!-- find-area -->
      <!-- <div class="find-area">
        <div class="container custom-container">
          <div class="row">
            <div class="col-12">
              <form action="#">
                <div class="find-wrap">
                  <div class="location">
                    <i class="flaticon-location"></i>
                    <input type="text" value="Enter City, State. or Zip" />
                  </div>
                  <div class="find-category">
                    <ul>
                      <li>
                        <a href="shop.html"
                          ><i class="flaticon-dog"></i> Find Your Dog</a
                        >
                      </li>
                      <li>
                        <a href="shop.html"
                          ><i class="flaticon-happy"></i> Find Your Cat</a
                        >
                      </li>
                      <li>
                        <a href="shop.html"
                          ><i class="flaticon-dove"></i> Find Your Birds</a
                        >
                      </li>
                    </ul>
                  </div>
                  <div class="other-find">
                    <div class="dropdown">
                      <button
                        class="btn dropdown-toggle"
                        type="button"
                        id="dropdownMenuButton"
                        data-toggle="dropdown"
                        aria-haspopup="true"
                        aria-expanded="false"
                      >
                        Find Other Pets
                      </button>
                      <div
                        class="dropdown-menu"
                        aria-labelledby="dropdownMenuButton"
                      >
                        <a class="dropdown-item" href="shop.html"
                          >Find Your Dog</a
                        >
                        <a class="dropdown-item" href="shop.html"
                          >Find Your Cat</a
                        >
                        <a class="dropdown-item" href="shop.html"
                          >Find Your Birds</a
                        >
                      </div>
                    </div>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div> -->
      <!-- find-area-end -->

      <!-- counter-area -->
      <section
        class="counter-area counter-bg"
        style="background-image: url('/img/bg/counter_bg.jpg')"
      >
        <div class="container">
          <!-- <div class="row justify-content-center">
            <div class="col-xl-6 col-lg-8">
              <div class="counter-title text-center mb-65">
                <h6 class="sub-title">Why Choose Us?</h6>
                <h2 class="title">
                  Best Service to Breeds Your Loved Dog Explore
                </h2>
              </div>
            </div>
          </div> -->
          <div class="row justify-content-center">
            <div class="col-lg-3 col-md-4 col-sm-6">
              <div class="counter-item">
                <h2 class="count">
                  <span class="odometer" data-count="73">{{maincnt.today}}</span>
                </h2>
                <p>오늘 추가된 유기 동물</p>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6">
              <div class="counter-item">
                <h2 class="count">
                  <span class="odometer" data-count="259">{{maincnt.protect}}</span>
                </h2>
                <p>최근 한달 간 보호</p>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6">
              <div class="counter-item">
                <h2 class="count">
                  <span class="odometer" data-count="10">{{maincnt.return}}</span>
                </h2>
                <p>최근 한달 간 반환</p>
              </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6">
              <div class="counter-item">
                <h2 class="count">
                  <span class="odometer" data-count="45">{{maincnt.death}}</span>
                </h2>
                <p>최근 한달 간 사망</p>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- counter-area-end -->

      <!-- adoption-area -->
      <!-- <section class="adoption-area">
        <div class="container">
          <div
            class="row align-items-center align-items-xl-end justify-content-center"
          >
            <div class="col-xl-7 col-lg-6 col-md-10 order-0 order-lg-2">
              <div class="adoption-img">
                <img src="/img/images/adoption_img.jpg" alt="" />
              </div>
            </div>
            <div class="col-xl-5 col-lg-6">
              <div class="adoption-content">
                <h2 class="title">
                  Working For <br />
                  Dog <span>Adoption</span> Free, Happy Time
                </h2>
                <p>
                  The best overall dog DNA test is Embark Breed & Health Kit
                  (view at Chewy), which provides you with a breed brwn and
                  information.
                </p>
                <a href="adoption.html" class="btn"
                  >Adoption <img src="/img/icon/w_pawprint.png" alt=""
                /></a>
              </div>
            </div>
          </div>
        </div>
        <div class="adoption-shape">
          <img src="/img/images/adoption_shape.png" alt="" />
        </div>
      </section> -->
      <!-- adoption-area-end -->

      <!-- breeds-services -->
      <!-- <section class="breeds-services pt-110 pb-110">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-xl-7 col-lg-9">
              <div class="section-title text-center mb-65">
                <div class="section-icon">
                  <img src="/img/icon/pawprint.png" alt="" />
                </div>
                <h5 class="sub-title">Service to Breeds</h5>
                <h2 class="title">Most Popular Dog Breed</h2>
                <p>
                  The best overall dog DNA test is Embark Breed & Health Kit
                  (view at Chewy), which provides you with a breed brwn and
                  information Most dogs
                </p>
              </div>
            </div>
          </div>
          <div class="row justify-content-center">
            <div class="col-lg-8">
              <div class="breed-services-active owl-carousel">
                <div class="breed-services-item">
                  <div class="thumb">
                    <img src="/img/images/breed_services_img01.jpg" alt="" />
                  </div>
                  <div class="content">
                    <h3 class="title">
                      <a href="breeder-details.html">Golden Retriever</a>
                    </h3>
                  </div>
                </div>
                <div class="breed-services-item">
                  <div class="thumb">
                    <img src="/img/images/breed_services_img02.jpg" alt="" />
                  </div>
                  <div class="content">
                    <h3 class="title">
                      <a href="breeder-details.html">German Sharped</a>
                    </h3>
                  </div>
                </div>
                <div class="breed-services-item">
                  <div class="thumb">
                    <img src="/img/images/breed_services_img03.jpg" alt="" />
                  </div>
                  <div class="content">
                    <h3 class="title">
                      <a href="breeder-details.html">Siberian Husky</a>
                    </h3>
                  </div>
                </div>
                <div class="breed-services-item">
                  <div class="thumb">
                    <img src="/img/images/breed_services_img04.jpg" alt="" />
                  </div>
                  <div class="content">
                    <h3 class="title">
                      <a href="breeder-details.html">Bernes Mountain</a>
                    </h3>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-4 col-md-6">
              <div
                class="breed-services-info"
                style="background-image: url('/img/bg/breed_services_bg.jpg')"
              >
                <h5 class="sub-title">Dog Breeder</h5>
                <h3 class="title">Available for Breed</h3>
                <p>
                  The best overall dog DNA test is Embark Breed & Health Kit
                  (view at Chewy), which provid dogs
                </p>
                <a href="dog-list.html" class="btn"
                  >More Pets <img src="/img/icon/w_pawprint.png" alt=""
                /></a>
              </div>
            </div>
          </div>
        </div>
        <div class="breed-services-shape">
          <img src="/img/images/breed_services_shape01.png" alt="" />
        </div>
        <div class="breed-services-shape shape-two">
          <img src="/img/images/breed_services_shape02.png" alt="" />
        </div>
      </section> -->
      <!-- breeds-services-end -->

      <!-- faq-area -->
      <!-- <section class="faq-area faq-bg">
        <div class="container">
          <div class="row align-items-center">
            <div class="col-lg-6">
              <div class="faq-img-wrap">
                <img src="/img/images/faq_tv.png" class="img-frame" alt="" />
                <img src="/img/images/faq_img.png" class="main-img" alt="" />
                <a
                  href="https://www.youtube.com/watch?v=XdFfCPK5ycw"
                  class="popup-video"
                ></a>
              </div>
            </div>
            <div class="col-lg-6">
              <div class="faq-wrapper">
                <div class="section-title mb-35">
                  <h5 class="sub-title">FAQ Question</h5>
                  <h2 class="title">History & Family Adoption</h2>
                </div>
                <div class="accordion" id="accordionExample">
                  <div class="card">
                    <div class="card-header" id="headingOne">
                      <h2 class="mb-0">
                        <button
                          class="btn btn-link btn-block text-left"
                          type="button"
                          data-toggle="collapse"
                          data-target="#collapseOne"
                          aria-expanded="true"
                          aria-controls="collapseOne"
                        >
                          Working for dog adoption
                        </button>
                      </h2>
                    </div>
                    <div
                      id="collapseOne"
                      class="collapse show"
                      aria-labelledby="headingOne"
                      data-parent="#accordionExample"
                    >
                      <div class="card-body">
                        The best overall dog DNA test is embark breed & health
                        Kit (view atths Chewy), which provides you with a breed
                        brwn and ition on provides ancestors most dogs.
                      </div>
                    </div>
                  </div>
                  <div class="card">
                    <div class="card-header" id="headingTwo">
                      <h2 class="mb-0">
                        <button
                          class="btn btn-link btn-block text-left collapsed"
                          type="button"
                          data-toggle="collapse"
                          data-target="#collapseTwo"
                          aria-expanded="false"
                          aria-controls="collapseTwo"
                        >
                          Competitions & Awards
                        </button>
                      </h2>
                    </div>
                    <div
                      id="collapseTwo"
                      class="collapse"
                      aria-labelledby="headingTwo"
                      data-parent="#accordionExample"
                    >
                      <div class="card-body">
                        The best overall dog DNA test is embark breed & health
                        Kit (view atths Chewy), which provides you with a breed
                        brwn and ition on provides ancestors most dogs.
                      </div>
                    </div>
                  </div>
                  <div class="card">
                    <div class="card-header" id="headingThree">
                      <h2 class="mb-0">
                        <button
                          class="btn btn-link btn-block text-left collapsed"
                          type="button"
                          data-toggle="collapse"
                          data-target="#collapseThree"
                          aria-expanded="false"
                          aria-controls="collapseThree"
                        >
                          The puppies are 3 months old
                        </button>
                      </h2>
                    </div>
                    <div
                      id="collapseThree"
                      class="collapse"
                      aria-labelledby="headingThree"
                      data-parent="#accordionExample"
                    >
                      <div class="card-body">
                        The best overall dog DNA test is embark breed & health
                        Kit (view atths Chewy), which provides you with a breed
                        brwn and ition on provides ancestors most dogs.
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="faq-shape">
          <img src="/img/images/faq_shape.png" alt="" />
        </div>
      </section> -->
      <!-- faq-area-end -->

      <!-- carousel-area-start -->
      <!-- <section class="adoption-area-two pt-110 pb-110">
        <div class="container custom-container">
          <div class="row justify-content-center">
            <div class="col-xl-7 col-lg-9">
              <div class="section-title text-center mb-65">
                <div class="section-icon">
                  <img src="img/icon/pawprint.png" alt="" />
                </div>
                <h5 class="sub-title">도와주세요</h5>
                <h2 class="title">
                  혼자 남은 아이들을 위해 <br />
                  함께 할 수 있는 가족이 되어주세요
                </h2>
                <p>
                  The best overall dog DNA test is Embark Breed & Health Kit
                  (view at Chewy), which provides you with a breed brwn and
                  information Most dogs
                </p>
              </div>
            </div>
          </div>
          <div class="adopt-active">
            <Slick ref="slick" :options="slickOptions">
              <div
                v-for="(shelnimal, index) in this.$store.state[`mainView`]
                  .shelnimal.list"
                v-bind:key="index"
                class="adoption-item"
              >
                <div class="adopt-thumb">
                  <router-link
                    :to="{ name: 'ShelDetail', params: { no: shelnimal.no } }"
                  >
                    <img
                      style="width: 353px; height: 353px"
                      :src="shelnimal.popfile"
                      alt=""
                    />
                  </router-link>
                </div>
                <div class="adopt-content">
                  <h3 class="title"></h3>
                  <p>
                    품종 : {{ shelnimal.kindCd }}<br />
                    발견장소 : {{ shelnimal.happenPlace }}
                  </p>
                </div>
              </div>
            </Slick>
          </div>
        </div>
      </section> -->
      <!-- carousel-area-end -->

      <!-- adoption-shop-area -->
      <section class="adoption-shop-area">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-xl-7 col-lg-9">
              <div class="section-title text-center mb-65">
                <div class="section-icon">
                  <img src="/img/icon/pawprint.png" alt="" />
                </div>
                <h5 class="sub-title">도와주세요</h5>
                <h2 class="title">
                  혼자 남은 아이들을 위해 <br />
                  함께 할 수 있는 가족이 돼주세요
                </h2>
                <!-- <p>
                  The best overall dog DNA test is Embark Breed & Health Kit
                  (view at Chewy), which provides you with a breed brwn and
                  information Most dogs
                </p> -->
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
                    :to="{ name: 'ShelDetail', params: { no: shelnimal.no } }"
                    class="btn"
                    >보러가기<img src="img/icon/w_pawprint.png" alt=""
                  /></router-link>
                </div>
                <div class="adoption-shop-content">
                  <h4 class="title"></h4>
                  <div class="adoption-meta">
                    <ul>
                      <li>
                        <i class="fas fa-cog"></i
                        ><a href="#">{{ shelnimal.kindCd }}</a>
                      </li>
                      <li>
                        <i class="far fa-calendar"></i>{{ shelnimal.age }}
                      </li>
                    </ul>
                  </div>
                  <div class="adoption-rating">
                    <ul>
                      <li><i class="fas fa-coins"></i> 특징</li>
                      <li style="text-align: right; width: 220px">
                        {{ shelnimal.specialMark }}
                      </li>
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
      <!-- testimonial-area-end -->

      <!-- blog-area -->
      <!-- <section class="blog-area pt-110 pb-60">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-xl-7 col-lg-9">
              <div class="section-title text-center mb-65">
                <div class="section-icon">
                  <img src="/img/icon/pawprint.png" alt="" />
                </div>
                <h5 class="sub-title">Our News</h5>
                <h2 class="title">Latest News Update</h2>
                <p>
                  The best overall dog DNA test is Embark Breed & Health Kit
                  (view at Chewy), which provides you with a breed brwn and
                  information Most dogs
                </p>
              </div>
            </div>
          </div>
          <div class="row justify-content-center">
            <div class="col-lg-4 col-md-6">
              <div class="blog-post-item mb-50">
                <div class="blog-post-thumb">
                  <a href="blog-details.html"
                    ><img src="/img/blog/blog_post_thumb01.jpg" alt=""
                  /></a>
                  <div class="blog-post-tag">
                    <a href="#"><i class="flaticon-bookmark-1"></i>Sharped</a>
                  </div>
                </div>
                <div class="blog-post-content">
                  <div class="blog-post-meta">
                    <ul>
                      <li><i class="far fa-user"></i><a href="#">Admin</a></li>
                      <li><i class="far fa-bell"></i> Mar 10, 2021</li>
                    </ul>
                  </div>
                  <h3 class="title">
                    <a href="blog-details.html">Working For Dog Adoption</a>
                  </h3>
                  <p>
                    The best overall dog test is Embark Breed & Health Kit view
                    at Chewy.
                  </p>
                  <a href="blog-details.html" class="read-more"
                    >Read More <img src="/img/icon/pawprint.png" alt=""
                  /></a>
                </div>
              </div>
            </div>
            <div class="col-lg-4 col-md-6">
              <div class="blog-post-item mb-50">
                <div class="blog-post-thumb">
                  <a href="blog-details.html"
                    ><img src="/img/blog/blog_post_thumb02.jpg" alt=""
                  /></a>
                  <div class="blog-post-tag">
                    <a href="#"><i class="flaticon-bookmark-1"></i>Creative</a>
                  </div>
                </div>
                <div class="blog-post-content">
                  <div class="blog-post-meta">
                    <ul>
                      <li><i class="far fa-user"></i><a href="#">Admin</a></li>
                      <li><i class="far fa-bell"></i> Mar 12, 2021</li>
                    </ul>
                  </div>
                  <h3 class="title">
                    <a href="blog-details.html">Dog Derived From an Ancient</a>
                  </h3>
                  <p>
                    The best overall dog test is Embark Breed & Health Kit view
                    at Chewy.
                  </p>
                  <a href="blog-details.html" class="read-more"
                    >Read More <img src="/img/icon/pawprint.png" alt=""
                  /></a>
                </div>
              </div>
            </div>
            <div class="col-lg-4 col-md-6">
              <div class="blog-post-item mb-50">
                <div class="blog-post-thumb">
                  <a href="blog-details.html"
                    ><img src="/img/blog/blog_post_thumb03.jpg" alt=""
                  /></a>
                  <div class="blog-post-tag">
                    <a href="#"><i class="flaticon-bookmark-1"></i>Business</a>
                  </div>
                </div>
                <div class="blog-post-content">
                  <div class="blog-post-meta">
                    <ul>
                      <li><i class="far fa-user"></i><a href="#">Admin</a></li>
                      <li><i class="far fa-bell"></i> Mar 12, 2021</li>
                    </ul>
                  </div>
                  <h3 class="title">
                    <a href="blog-details.html">Ten Dog Breeds are Noted</a>
                  </h3>
                  <p>
                    The best overall dog test is Embark Breed & Health Kit view
                    at Chewy.
                  </p>
                  <a href="blog-details.html" class="read-more"
                    >Read More <img src="/img/icon/pawprint.png" alt=""
                  /></a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section> -->
      <!-- blog-area-end -->
    </main>
    <!-- main-area-end -->
  </div>
</template>

<script>
import axios from 'axios';
const session = window.sessionStorage;
// import Slick from "vue-slick";
export default {
  name: "App",
  components: {
    // Slick,
  },
  data() {
    return {
      maincnt:{},
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
  created(){
    this.selectmaincnt();
  },
  mounted() {
    if (this.$store.state["login"].isLogin == false) {
      this.shelimalList();
    } else {
      this.shelimalListLogin();
    }
  },
  methods:{
    shelimalList() {
      console.log("비로그인 접속");
      this.$store.dispatch("mainView/mainShelnimalList");
    },
    shelimalListLogin() {
      console.log("로그인 접속");
      this.$store.dispatch("mainView/mainShelnimalListLogin");
    },
    selectmaincnt(){
      let headers = {
        'at-jwt-access-token': session.getItem('at-jwt-access-token'),
        'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
    };
    axios({
        method: 'get',
        url: '/api/dataset/',
        headers: headers, 
      }).then((res) => {
        this.$store.dispatch('login/accessTokenRefresh', res) 
        this.maincnt = res.data; 
      }).catch((error) => {
        console.log(error);
      }).then(() => {
        console.log('selectmaincnt End!!');
      });
    },
  }
};
</script>

<style></style>
