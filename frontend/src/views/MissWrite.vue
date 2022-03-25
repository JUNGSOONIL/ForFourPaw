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
                <h2 class="title">실종 동물 추가 페이지</h2>
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
                <div class="shop-details-content" style="border: 1px solid black; padding: 10px; height:568px; overflow:auto;">

                  <div class="shop-details-price">
                    <h2 class="price">사람 정보</h2>
                    <h5 class="stock-status">- Person</h5>
                  </div>
                  <div class="shop-details-dimension">
                    <label for="personName">이름</label>
                    <input
                          id="personName"
                          type="text"
                          v-model="name"
                          class="form-control"
                          placeholder="이름을 입력해주세요."
                    />
                    <label for="personTel">전화번호</label>
                      <input
                          id="personTel"
                          type="tel"
                          v-model="tell"
                          class="form-control"
                          placeholder="전화번호을 입력해주세요."
                      />
                  </div>
                  <div class="shop-details-price">
                    <h2 class="price">동물 정보</h2>
                    <h5 class="stock-status">- Animal</h5>
                  </div>
                  <div class="shop-details-dimension">
                    <label for="personName">이름</label>
                    <input
                          id="personName"
                          type="text"
                          v-model="name"
                          class="form-control"
                          placeholder="이름을 입력해주세요."
                    />
                    <label for="personName">품종</label>
                    <input
                          id="personName"
                          type="text"
                          v-model="name"
                          class="form-control"
                          placeholder="이름을 입력해주세요."
                    />
                    <label for="personName">색상</label>
                    <input
                          id="personName"
                          type="text"
                          v-model="name"
                          class="form-control"
                          placeholder="이름을 입력해주세요."
                    />
                    <label for="personName">나이</label>
                    <input
                          id="personName"
                          type="text"
                          v-model="name"
                          class="form-control"
                          placeholder="이름을 입력해주세요."
                    />
                    <label for="personName">성별</label>
                    <input
                          id="personName"
                          type="text"
                          v-model="name"
                          class="form-control"
                          placeholder="이름을 입력해주세요."
                    />
                    <label for="personName">중성화</label>
                    <input
                          id="personName"
                          type="text"
                          v-model="name"
                          class="form-control"
                          placeholder="이름을 입력해주세요."
                    />
                    <label for="personName">실종날짜</label>
                    <input
                          id="personName"
                          type="text"
                          v-model="name"
                          class="form-control"
                          placeholder="이름을 입력해주세요."
                    />
                    <label for="personName">실종장소</label>
                    <input
                          id="personName"
                          type="text"
                          v-model="name"
                          class="form-control"
                          placeholder="이름을 입력해주세요."
                    />
                    <label for="personName">특이사항</label>
                    <textarea 
                          id="personName"
                          type="text"
                          v-model="name"
                          class="form-control"
                          placeholder="이름을 입력해주세요."
                    />
                  </div>
                </div>
                                  <button>취소</button>
                  <button>작성</button>
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

export default {
  name: "App",
  components: {},
};
</script>

<style>
#app{

}
</style>
