<template>
  <div>
    <!-- adoption-shop-area -->
    <section class="adoption-shop-area">
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-xl-7 col-lg-9">
            <div class="section-title mb-65">
              <!-- 추가 정보 start -->
              <div class="comment-reply-box">
                <h5 class="title text-center">
                  멍멍! 야옹! <br />
                  포포포(For Four Paw)에서 <br />
                  사용할 당신의 정보를 입력하세요!
                </h5>
                <form action="#" class="comment-reply-form">
                  <div class="row">
                    <div class="col-md-12">
                      <div class="form-grp was-validated">
                        <label class="input-non-point" for="Nickname"
                          >닉네임:</label
                        >
                        <input
                          class="form-control"
                          type="text"
                          placeholder="닉네임을 입력해주세요."
                          required
                        />
                        <div class="valid-feedback">Looks good!</div>
                        <div class="invalid-feedback">
                          Please fill out this field.
                        </div>
                      </div>
                    </div>
                    <div class="col-md-12">
                      <div class="form-grp">
                        <label class="input-non-point" for="address"
                          >거주지역:</label
                        >
                        <select class="form-control" name="거주지역">
                          <option :value="1">서울특별시</option>
                          <option :value="2">부산광역시</option>
                          <option :value="3">대구광역시</option>
                          <option :value="4">인천광역시</option>
                          <option :value="5">광주광역시</option>
                          <option :value="6">대전광역시</option>
                          <option :value="7">울산광역시</option>
                          <option :value="8">세종특별자치시</option>
                          <option :value="9">경기도</option>
                          <option :value="10">강원도</option>
                          <option :value="11">충청북도</option>
                          <option :value="12">충청남도</option>
                          <option :value="13">전라북도</option>
                          <option :value="14">전라남도</option>
                          <option :value="15">경상북도</option>
                          <option :value="16">경상남도</option>
                          <option :value="17">제주특별자치도</option>
                          <option :value="18" selected>선택</option>
                        </select>
                      </div>
                    </div>
                    <div class="col-md-12 text-center">
                      <button id="moreinfobtn" type="submit" class="btn">
                        수정
                      </button>
                    </div>
                  </div>
                </form>
              </div>
              <!-- 추가정보 End -->
            </div>
          </div>
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  data() {
    return {
      selected: "",
    };
  },
};
</script>

<style scoped>
#LoginLogo {
  height: 300px;
}

/* 추가정보 */
.input-non-point {
  cursor: default;
  font-size: 15px;
  font-weight: 700;
  color: #0a303a;
  font-family: "Poppins", sans-serif;
}
</style>
