<template>
          <div class="section-title text-center" style="display: flex; justify-content: center; align-items:center; min-height: 100vh;">
            <div class="section-title mb-65">
              <div class="text-center">
                <img src="/img/logo/character.png" width="500" alt="" />
              </div>
              <div class="text-center">
                <h5 class="sub-title">{{ this.msg }} 완료</h5>
                <h2 class="title">감사합니다<br />다음에 또 방문해 주세요</h2>
              </div>
              <div class="text-center">
                <router-link to="/" class="btn">홈으로</router-link>
              </div>
              <!-- <div class="comment-reply-box text-center">
                <h5 class="title">For Four Paw에 오신 걸 환영합니다.</h5>
              </div> -->
            </div>
          </div>
</template>

<script>
export default {
  props: {
    msg: String,
  },
};
</script>
