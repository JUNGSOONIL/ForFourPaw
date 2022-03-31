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
                        <img v-if="!miss.profile" src="../assets/img/image.png" alt="" style="
                              background-color: #bcbcbc;
                              width: 616px;
                              height: 568px;
                              border: 2px solid black;
                        "/>
                        <img v-else :src="miss.profile" alt="" style="
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
                    <h2 class="price">사람 정보</h2>
                    <h5 class="stock-status">- Person</h5>
                  </div>
                  <div class="shop-details-dimension">
                    <label for="personName">이름</label>
                    <input
                      id="personName"
                      type="text"
                      v-model="miss.authorName"
                      class="form-control"
                      readonly
                    />
                    <label for="personTel">전화번호</label>
                    <input
                      id="personTel"
                      type="tel"
                      v-model="miss.careTel"
                      class="form-control"
                      readonly
                    />
                  </div>
                  <div class="shop-details-price">
                    <h2 class="price">동물 정보</h2>
                    <h5 class="stock-status">- Animal</h5>
                  </div>
                  <div class="shop-details-dimension">
                    <label for="animalName">이름</label>
                    <input
                      id="animalName"
                      type="text"
                      v-model="miss.name"
                      class="form-control"
                      readonly
                    />
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
                    <label for="animalHappenDay">실종날짜</label>
                    <input
                      id="animalHappenDay"
                      type="date"
                      v-model="miss.happenDt"
                      class="form-control"
                      readonly
                    />
                    <label for="animalHappenPlace">실종장소</label>
                    <div>
                        <input
                          id="animalHappenPlace"
                          type="text"
                          v-model="miss.happenPlace"
                          class="form-control"
                          readonly
                        />
                    </div>
                    <label for="animalDesc">특이사항</label>
                    <textarea
                      id="animalDesc"
                      type="text"
                      v-model="miss.descr"
                      class="form-control"
                      readonly
                    />
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-12">
              <div class="product-desc-wrap" style="padding-top : 15px;">
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
                  <li class="nav-item">
                    <a
                      class="nav-link"
                      id="comment-tab"
                      data-toggle="tab"
                      href="#comment"
                      role="tab"
                      aria-controls="comment"
                      aria-selected="true"
                      >댓글</a
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
                      <h5 >
                        「동물보호법」 제17조, 시행령7조 및 동법 시행규칙 제20조에 따라 유기·유실동물을 보호하고 있는 경우에는 소유자 등이
                          보호조치 사실을 알 수 있도록 7일 동안 공고하여야 합니다.
                          공고 중인 동물 소유자는 해당 시군구 및 동물보호센터에 문의하시어 동물을 찾아가시기 바랍니다.
                          다만, 「동물보호법」 제19조 및 동법 시행규칙 제21조에 따라 소유자에게 보호비용이 청구될 수 있습니다.
                          또한 「동물보호법」 제17조에 따른 공고가 있는 날부터 10일이 경과하여도 소유자 등을 알 수 없는 경우에는 
                          「유실물법」 제12조 및 「민법」 제253조의 규정에도 불구하고 해당 시·도지사 또는 시장·군수·구청장이 그 동물의 소유권을 취득하게 됩니다.
                      </h5>
                    </div>
                  </div>

                  <div
                    class="tab-pane fade show"
                    id="details"
                    role="tabpanel"
                    aria-labelledby="details-tab"
                  >
                    <div v-if="matchend" class="product-desc-content">
                      <h2 v-if="misslistslice.length != 0">
                        혹시 이 동물은 아니신가요? <br>
                        포포포가 찾아드려요!
                      </h2>
                      <h2 v-else>
                        죄송합니다 현재 매칭되는 동물이 없어요. <br>
                        더욱 더 노력하는 포포포가 될게요!
                      </h2>
                    </div>
                    <div v-if="misslistslice.length != 0" class="row related-product-active" >
                      <div v-if="misslistmax > 3" style="position: absolute; z-index: 1; top:295px">
                          <p @click="imgleft" type="button" style="margin:0px; opacity : 0.7;" ><img src="img/icon/arrow2.png" style="width:60px;" /></p>
                        </div>
                        <div v-if="misslistmax > 3"  style="position: absolute; z-index: 1; top:295px; right:0px">
                          <p @click="imgright" type="button" style="margin:0px; opacity : 0.7;"><img src="img/icon/arrow4.png" style="width:60px;" /></p>
                        </div>
                      <div v-for="(miss, index) in misslistslice" v-bind:key="index" class="col-lg-3">
                        <div class="shop-item mb-55" style="z-index: -1;">
                          <div class="shop-thumb">
                            <router-link :to="{ name: 'ShelDetail', params: { no: miss.no },}">
                              <img :src=miss.filename alt="" style="width:268px; height: 268px; border-radius: 50%"/>
                              </router-link>
                          </div>
                          <div class="shop-content">
                            <h5 class="title">
                              <router-link :to="{ name: 'ShelDetail', params: { no: miss.no },}">
                                {{miss.orgNm}} {{miss.happenPlace}}
                              </router-link>
                            </h5>
                            <div class="shop-content-bottom">
                              <span class="price">보호기관 : {{miss.careTel}}</span>
                              <span class="add-cart">
                                <router-link :to="{ name: 'ShelDetail', params: { no: miss.no },}">
                                  상세보기
                                </router-link>
                              </span>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div
                    class="tab-pane fade show"
                    id="comment"
                    role="tabpanel"
                    aria-labelledby="comment-tab"
                  >
                    <div class="row related-product-active">

                        <div class="col-12" style="margin-top : 10px; ">
                          <div 
                          id="test"
                          :style="commenntopen">

                            <div v-for="(com, index) in commentlistslice" v-bind:key="index">
                              <img style="float:left;" id="comment_img" :src="com.profile_img" alt="">
                              <h4 style="float:left; margin:0px">{{com.authorNickName}}</h4>
                              <div v-if="com.author == userInfoNo()" id="setting" style="cursor: pointer; float:right;" @click="commentdelete(com.no)">
                                <i style="margin-top:5px" class="fas fa-trash"></i>
                              </div>
                              <p style="float:right;"> {{com.writeTime.substring(0,10)}} &nbsp; </p>
                              <br>
                              <br>
                              <p style="margin-left:50px; margin-bottom:5px;">{{com.descr}}</p> 
                              &nbsp;&nbsp;&nbsp;&nbsp; 
                            </div>
                          </div>
                        </div>

                        <div class="col-12">
                          <div class="shop-details-price" style="margin:3px; float:right; cursor: pointer;">
                              <h5 class="stock-status" v-if="(!commentstyle.toggle && commentlist!= null && commentlist.length > 2)" @click="updatecomment()">더보기</h5>
                              <h5 class="stock-status" v-if="(commentstyle.toggle && commentlist != null && commentlist.length > 2)" @click="updatecomment()">접기</h5>
                            </div>
                        </div>
                  
                        <div class="col-12">
                          <div style="
                            border: 2px;
                            padding: 4px 12px;
                            height: 50px;
                          ">
                          <label for="comment_input" style="float:left; font-size:17px; margin-top:6px;">댓글</label>
                            <input
                              id="comment_input"
                              type="text"
                              v-model="commentdescr"
                              class="form-control"
                              style="width: 1037px; float:left; margin: 0px 10px"
                              @keyup.enter="commentinset"
                            />
                            <p class="btn" style="width: 85px; height: 10px; font-size:17px; padding: 19px 15px; float:left;"
                            @click="commentinset">
                              작성
                              <img src="/img/icon/w_pawprint.png" alt="" />
                            </p>
                          </div>
                        </div>
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
import axios from 'axios';
const session = window.sessionStorage;
export default {
  name: "App",
  props:{
    no:{
      default : 3,
      type:Number,
    },
  },
  data: function(){
     return {
       matchend: false,
       miss: { },
       commentdescr: "",
       commentlist:[],
       commentlistslice : [],
       commentstyle: {
         height : '190px',
         overflow : 'hidden ',
         toggle : false,
       },
       misslist:[],
       misslistslice:[],
       misslistmin: 0,
       misslistindex: 4,
       misslistmax: 0,
     }
  },
  created() {
    this.selectMiss();
    this.commentselect();
  },
  computed:{
    commenntopen(){
      return {
        border : '2px',
        padding : '4px 12px',
        height : this.commentstyle.height,
        overflow: this.commentstyle.overflow,
      }
    },
  },
  methods:{
    imgleft(){
      if(this.misslistmin > 0){
        this.misslistmin--
        this.misslistindex--
      }
      this.misslistslice = this.misslist.slice(this.misslistmin,this.misslistindex)
    },
    imgright(){
      if(this.misslistindex < this.misslistmax){
        this.misslistmin++
        this.misslistindex++
      }
      this.misslistslice = this.misslist.slice(this.misslistmin,this.misslistindex)
    },
    userInfoNo(){
      return JSON.parse(session.getItem('userInfo')).no
    },
    commentselect(){
      this.commentlist = null;
      this.commentlistslice = null;
      let headers = {
        'at-jwt-access-token': session.getItem('at-jwt-access-token'),
        'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
      };
      axios({
          method: 'get',
          url: '/api/comments/' + this.no, //여기 수정
          headers: headers,  
        }).then((res) => {
          this.$store.dispatch('login/accessTokenRefresh', res) // store아닌곳에서
          this.commentlist = res.data
          console.log(res)
        }).catch((error) => {
          console.log(error);
        }).then(() => {
          console.log('commentselect End!!');
          if(this.commentlist.length == 0){
            this.commentstyle.height = "50px"
          }else{
            this.commentstyle.height = "190px"
            this.commentlistslice = this.commentlist.slice(0,2);
          }
      });
    },
    commentinset(){
      let headers = {
        'at-jwt-access-token': session.getItem('at-jwt-access-token'),
        'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
      };
      let data = {
        author : this.userInfoNo(),
        missNo : this.no,
        descr : this.commentdescr,
      };
      axios({
          method: 'post',
          url: '/api/comments', //여기 수정
          data: data, 
          headers: headers,  
        }).then((res) => {
          this.$store.dispatch('login/accessTokenRefresh', res) // store아닌곳에서
          this.$alertify.success("작성 완료했습니다.");
          this.commentdescr = ""
          this.commentselect();
        }).catch((error) => {
          console.log(error);
        }).then(() => {
          console.log('commentinset End!!');
      });
    },
    commentdelete(el){
      let headers = {
        'at-jwt-access-token': session.getItem('at-jwt-access-token'),
        'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
      };
      axios({
          method: 'delete',
          url: '/api/comments/' + el, //여기 수정
          headers: headers,  
        }).then((res) => {
          this.$store.dispatch('login/accessTokenRefresh', res) 
           this.$alertify.success("삭제 완료했습니다.");
           this.commentselect();
        }).catch((error) => {
          console.log(error);
        }).then(() => {
          console.log('commentdelete End!!');
      });
    },
    updatecomment(){
      if(this.commentstyle.toggle){
        this.commentstyle.height = '190px'
        this.commentstyle.overflow = 'hidden'
        this.commentlistslice = this.commentlist.slice(0,2);
      }else{
        this.commentstyle.height = '285px'
        this.commentstyle.overflow = 'auto'
        this.commentlistslice = this.commentlist;
      }
      this.commentstyle.toggle = !this.commentstyle.toggle;
    },
    match(){
      this.$store.commit('loading/load', true);
      let headers = {
        'at-jwt-access-token': session.getItem('at-jwt-access-token'),
        'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
    };
    let data = {
      kindCd : this.miss.kindCd,
      colorCd : this.miss.colorCd,
      sexCd : this.miss.sexCd,
      happenPlace : this.miss.happenPlace
    };
    axios({
        method: 'post',
        url: '/api/kmeans', //여기 수정
        data: data, // post 나 put에 데이터 넣어 줄때
        headers: headers,  // 넣는거 까먹지 마세요
      }).then((res) => {
        this.$store.dispatch('login/accessTokenRefresh', res) // store아닌곳에서
        this.misslist = res.data;
        this.misslistslice = this.misslist.slice(this.misslistmin,this.misslistindex);
        this.misslistmax = this.misslist.length
      }).catch((error) => {
        console.log(error);
      }).finally(() => this.$store.commit('loading/load', false),
        this.matchend = true
      )
    },
    selectMiss(){
      let headers = {
        'at-jwt-access-token': session.getItem('at-jwt-access-token'),
        'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
    };
    axios({
        method: 'get',
        url: '/api/miss/' + this.no, // 여기 수정
        headers: headers, 
      }).then((res) => {
        this.$store.dispatch('login/accessTokenRefresh', res) 
        this.miss = res.data; // 여기 수정
      }).catch((error) => {
        console.log(error);
      }).then(() => {
        console.log('selectMiss End!!');
        this.match();
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
#comment_img{
  width: 2.5rem;
  height: 2.5rem; 
  border-radius: 50%;
  margin-right:0.4rem;
  margin-bottom: auto;
  margin-top: auto;
}
#setting {
  width: 1%;
  margin-left: auto;
  margin-top: auto;
  margin-bottom: auto;
}
</style>
