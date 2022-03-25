<template>
  <div id="app">
    <!-- main-area -->
    <main>
      <!-- breadcrumb-area -->
      <section
        class="breadcrumb-area breadcrumb-bg"
        style="background-image: url('img/bg/breadcrumb_bg.jpg')"
      >
        <div class="container">
          <div class="row">
            <div class="col-12">
              <div class="breadcrumb-content">
                <h2 class="title">실종 동물 상세 페이지</h2>
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
              <div class="col-7">
                <div class="shop-details-img-wrap">
                  <div class="tab-content" id="myTabContent">
                    <div
                      class="tab-pane show active"
                      id="item-one"
                      role="tabpanel"
                      aria-labelledby="item-one-tab"
                    >
                      <div class="shop-details-img">
                        <img src="img/product/shop_details01.jpg" alt="" />
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="col-5">
                <div class="shop-details-content">
                  <span>여기는 뭐쓰지</span>
                  <h2 class="title">여기는 제목 쓰는게 좋을까?</h2>
                  <!-- <div class="shop-details-review">
                    <div class="rating">
                      <i class="fas fa-star"></i>
                      <i class="fas fa-star"></i>
                      <i class="fas fa-star"></i>
                      <i class="fas fa-star"></i>
                      <i class="fas fa-star"></i>
                    </div>
                    <span>( 01 Review )</span>
                  </div> -->
                  <div class="shop-details-price">
                    <h2 class="price">동물정보</h2>
                    <!-- <h5 class="stock-status">- IN Stock</h5> -->
                  </div>
                  <div class="shop-details-dimension">
                    <span>이름 :</span>
                    <span>품종 :</span>
                    <span>색상 :</span>
                    <span>성별 :</span>
                    <span>작성자 :</span>
                    <span>연락처 :</span>
                    <span>실종날짜 :</span>
                    <span>실종장소 :</span>
                    <hr>
                    <span>특이사항 :</span>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-12">
              <div class="product-desc-wrap">
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
                  <li class="nav-item">
                    <a
                      class="nav-link"
                      id="details-tab"
                      data-toggle="tab"
                      href="#details"
                      role="tab"
                      aria-controls="details"
                      aria-selected="true"
                      >매칭</a
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
                        「동물보호법」 제17조, 시행령7조 및 동법 시행규칙 제20조에 따라 유기·유실동물을 보호하고 있는 경우에는 소유자 등이
보호조치 사실을 알 수 있도록 7일 동안 공고하여야 합니다.
공고 중인 동물 소유자는 해당 시군구 및 동물보호센터에 문의하시어 동물을 찾아가시기 바랍니다.
다만, 「동물보호법」 제19조 및 동법 시행규칙 제21조에 따라 소유자에게 보호비용이 청구될 수 있습니다.
또한 「동물보호법」 제17조에 따른 공고가 있는 날부터 10일이 경과하여도 소유자 등을 알 수 없는 경우에는
「유실물법」 제12조 및 「민법」 제253조의 규정에도 불구하고 해당 시·도지사 또는 시장·군수·구청장이 그 동물의 소유권을 취득하게 됩니다.
                      </p>
                    </div>
                  </div>
                                    <div
                    class="tab-pane fade show"
                    id="details"
                    role="tabpanel"
                    aria-labelledby="details-tab"
                  >
                    <div class="product-desc-content">
                      <h2>
                        혹시 이 동물은 아니신가요? <br>
                        포포포가 찾아드려요!
                      </h2>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="related-products-wrap">
            <div class="row related-product-active">
              <div  v-for="(miss, index) in misslist" v-bind:key="index" class="col-lg-3">
                <div class="shop-item mb-55">
                  <div class="shop-thumb">
                    <a href="shop-details.html"
                      ><img :src=miss.popfile alt="" 
                    /></a>
                  </div>
                  <div class="shop-content">
                    <h4 class="title">
                      <a href="shop-details.html">{{miss.noticeSdt}} ~ {{miss.noticeEdt}}</a>
                    </h4>
                    <div class="shop-content-bottom">
                      <span class="price">{{miss.orgNm}}</span>
                      <span class="price">{{miss.careNm}}</span>
                      <span class="price">{{miss.careTel}}</span>
                      <span class="add-cart"
                        ><a href="shop-details.html">상세</a></span>
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
import axios from 'axios'
const session = window.sessionStorage;

export default {
  name: "App",
  components: {},
  data: function(){
     return {
       miss: {
        kindCd : "말티즈",
        colorCd : "흰색",
        sexCd : "F",
        orgNm : "서울특별시"
       },
       misslist:[],
     }
  },
  load:{
    
  },
  created() {
    this.match();
  },
  methods:{
    match(){
      let headers = {
        'at-jwt-access-token': session.getItem('at-jwt-access-token'),
        'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
    };
    let data = {
      kindCd : "말티즈",
      colorCd : "흰색",
      sexCd : "F",
      orgNm : "서울특별시"
    };
    axios({
        method: 'post',
        url: 'api/kmeans',
        data: data, // post 나 put에 데이터 넣어 줄때
        headers: headers,  // 넣는거 까먹지 마세요
      }).then((res) => {

        this.$store.dispatch('login/accessTokenRefresh', res) // store아닌곳에서
        console.log(res);
        this.misslist = res.data;
      }).catch((error) => {
        console.log(error);
      }).then(() => {
        console.log('getQSSList End!!');
      });
    },
  },
};
</script>

<style>
#app{

}
</style>
