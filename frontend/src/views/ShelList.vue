<template>
  <div id="app">
    <!-- main-area -->
    <main>
      <!-- breadcrumb-area -->
      <section
        class="breadcrumb-area breadcrumb-bg"
        style="background-image: url('/img/bg/sleeping_dog.jpg')"
      >
        <div class="container">
          <div class="row">
            <div class="col-12">
              <div class="breadcrumb-content">
                <!-- <span style="font-family:SLE; color:#ffffff; text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black; font-size:25x"> 보호자를 기다리고 있는 친구들이에요 </span> -->
                <h2 class="title">유기 동물</h2> 
                <nav
                  style="
                    background-color: #f5f2eb;
                    width: 180px;
                    border-radius: 15px 15px 40px 15px;
                  "
                  aria-label="breadcrumb"
                > 
                  <ol style="margin-left: 20px" class="breadcrumb">
                    <li class="breadcrumb-item">
                      <router-link style="color: gray" to="/">홈</router-link>
                    </li>
                    <li class="breadcrumb-item" aria-current="page">
                      <router-link to="/shelList">유기 동물 공고</router-link>
                    </li>
                  </ol>
                </nav>
                
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- breadcrumb-area-end -->

      <!-- shop-area -->
      <div class="shop-area pt-30 pb-60">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-1"></div>
            <div class="col-lg-10">
              <div class="shop-wrap">
                <h4 class="title">유기 동물 공고</h4>

                <div
                  class="shop-page-meta"
                  style="display: block; height: 180px"
                >
                  <div
                    class="shop-pagination"
                    style="
                      float: left;
                      margin-left: 10px;
                      margin-right: 589px;
                      margin-bottom: 0px;
                    "
                  >
                    <label
                      style="
                        margin-right: 10px;
                        color: #0a303a;
                        font-size: 13px;
                        float: left;
                        margin-top: 9px;
                      "
                      >날짜</label
                    >
                    <datepicker
                      style="float: left"
                      id="input_date"
                      format="yyyy-MM-dd"
                      placeholder="연도-월-일"
                      @input="noticeSdt_dateFormat"
                    ></datepicker>
                    <p style="float: left">&nbsp; ~ &nbsp;</p>
                    <datepicker
                      style="float: left"
                      id="input_date"
                      format="yyyy-MM-dd"
                      placeholder="연도-월-일"
                      @input="noticeEdt_dateFormat"
                    ></datepicker>
                  </div>

                  <div
                    class="shop-pagination"
                    style="
                      float: left;
                      margin-left: 190px;
                      margin-right: 600px;
                      margin-top: 0px;
                      margin-bottom: 2px;
                      font-size: 12px;
                    "
                  >
                    (날짜는 접수일 기준입니다)
                  </div>

                  <div
                    class="shop-show-list"
                    style="float: left; margin-left: 10px; margin-right: 20px"
                  >
                    <form action="#">
                      <label for="processState">상태</label>
                      <select
                        id="processState"
                        class="selected"
                        v-model="search.processState"
                        @change="searchShelnimal"
                      >
                        <option value="">전체</option>
                        <option value="protect">보호중</option>
                        <option value="notice">공고중</option>
                      </select>
                    </form>
                  </div>

                  <div
                    class="shop-show-list"
                    style="float: left; margin-right: 20px"
                  >
                    <form action="#">
                      <label for="neuterYn">중성화</label>
                      <select
                        id="neuterYn"
                        class="selected"
                        v-model="search.neuterYn"
                        @change="searchShelnimal"
                      >
                        <option value="">전체</option>
                        <option value="Y">예</option>
                        <option value="N">아니요</option>
                        <option value="U">미상</option>
                      </select>
                    </form>
                  </div>

                  <div
                    class="shop-show-list"
                    style="float: left; margin-right: 430px"
                  >
                    <form action="#">
                      <label for="careAddr">지역</label>
                      <select
                        id="careAddr"
                        class="selected"
                        v-model="search.careAddr"
                        @change="searchShelnimal"
                      >
                        <option value="">전체</option>
                        <option value="6110000">서울특별시</option>
                        <option value="6260000">부산광역시</option>
                        <option value="6270000">대구광역시</option>
                        <option value="6280000">인천광역시</option>
                        <option value="6290000">광주광역시</option>
                        <option value="6300000">대전광역시</option>
                        <option value="6310000">울산광역시</option>
                        <option value="5690000">세종특별자치시</option>
                        <option value="6410000">경기도</option>
                        <option value="6420000">강원도</option>
                        <option value="6430000">충청북도</option>
                        <option value="6440000">충청남도</option>
                        <option value="6450000">전라북도</option>
                        <option value="6460000">전라남도</option>
                        <option value="6470000">경상북도</option>
                        <option value="6480000">경상남도</option>
                        <option value="6500000">제주특별자치도</option>
                      </select>
                    </form>
                  </div>

                  <div
                    class="shop-show-list"
                    style="float: left; margin-left: 10px; margin-right: 20px"
                  >
                    <form action="#">
                      <label for="upKindCd">축종</label>
                      <select
                        id="upKindCd"
                        class="selected"
                        v-model="search.upKindCd"
                        @change="search.kindCd == null"
                      >
                        <option value="">전체</option>
                        <option value="417000">개</option>
                        <option value="422400">고양이</option>
                        <option value="429900">기타</option>
                      </select>
                    </form>
                  </div>

                  <!-- 품종-->
                  <div
                    class="shop-show-list"
                    style="float: left; margin-right: 20px"
                  >
                    <form action="#">
                      <label for="kindCd">품종</label>
                      <select
                        id="kindCd"
                        class="selected"
                        v-model="search.kindCd"
                        @change="searchShelnimal"
                        style="width: 250px"
                      >
                        <option v-if="!search.upKindCd" value="">전체</option>

                        <option v-if="search.upKindCd == 417000" value="">
                          전체
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000054">
                          골든 리트리버
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000056">
                          그레이 하운드
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000055">
                          그레이트 덴
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000118">
                          그레이트 피레니즈
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000115">
                          기타
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000037">
                          꼬똥 드 뚤레아
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000081">
                          네오폴리탄 마스티프
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000204">
                          노르포크 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000083">
                          노리치 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000082">
                          뉴펀들랜드
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000038">
                          닥스훈트
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000039">
                          달마시안
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000040">
                          댄디 딘몬트 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000043">
                          도고 까니리오
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000042">
                          도고 아르젠티노
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000153">
                          도고 아르젠티노
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000041">
                          도베르만
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000120">
                          도사
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000155">
                          동경견
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000069">
                          라브라도 리트리버
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000071">
                          라사 압소
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000142">
                          라이카
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000093">
                          래빗 닥스훈드
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000167">
                          랫 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000070">
                          레이크랜드 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000166">
                          로디지안 리즈백
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000121">
                          로트와일러
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000094">
                          로트와일러
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000152">
                          마리노이즈
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000073">
                          마스티프
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000146">
                          말라뮤트
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000072">
                          말티즈
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000159">
                          맨체스터테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000076">
                          미니어쳐 닥스훈트
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000075">
                          미니어쳐 불 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000079">
                          미니어쳐 슈나우저
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000078">
                          미니어쳐 푸들
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000077">
                          미니어쳐 핀셔
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000074">
                          미디엄 푸들
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000080">
                          미텔 스피츠
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000114">
                          믹스견
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000133">
                          바센지
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000012">
                          바셋 하운드
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000017">
                          버니즈 마운틴 독
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000015">
                          베들링턴 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000164">
                          벨기에 그로넨달
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000157">
                          벨기에 쉽독
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000148">
                          벨기에 테뷰런
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000016">
                          벨지안 셰퍼드 독
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000020">
                          보더 콜리
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000021">
                          보르조이
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000022">
                          보스턴 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000024">
                          복서
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000208">
                          볼로네즈
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000023">
                          부비에 데 플랑드르
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000026">
                          불 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000027">
                          불독
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000169">
                          브뤼셀그리펀
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000025">
                          브리타니 스파니엘
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000019">
                          블랙 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000013">
                          비글
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000018">
                          비숑 프리제
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000014">
                          비어디드 콜리
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000162">
                          비즐라
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000085">
                          빠삐용
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000096">
                          사모예드
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000095">
                          살루키
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000001">
                          삽살개
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000034">
                          샤페이
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000104">
                          세인트 버나드
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000031">
                          센트럴 아시안 오브차카
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000099">
                          셔틀랜드 쉽독
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000122">
                          셰퍼드
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000123">
                          슈나우져
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000097">
                          스코티쉬 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000132">
                          스코티시 디어하운드
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000154">
                          스태퍼드셔 불 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000105">
                          스탠다드 푸들
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000124">
                          스피츠
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000100">
                          시바
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000103">
                          시베리안 허스키
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000151">
                          시베리안라이카
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000139">
                          시잉프랑세즈
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000101">
                          시츄
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000102">
                          시코쿠
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000098">
                          실리햄 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000136">
                          실키테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000202">
                          아나톨리안 셰퍼드
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000160">
                          아메리칸 불독
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000203">
                          아메리칸 스태퍼드셔 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000008">
                          아메리칸 아키다
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000131">
                          아메리칸 에스키모
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000009">
                          아메리칸 코카 스파니엘
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000119">
                          아메리칸 핏불 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000150">
                          아메리칸불리
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000210">
                          아이리쉬 레드 앤 화이트 세터
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000057">
                          아이리쉬 세터
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000058">
                          아이리쉬 울프 하운드
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000059">
                          아이리쉬소프트코튼휘튼테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000006">
                          아키다
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000004">
                          아프간 하운드
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000007">
                          알라스칸 말라뮤트
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000005">
                          에어델 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000143">
                          오브차카
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000011">
                          오스트랄리안 셰퍼드 독
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000010">
                          오스트랄리안 캐틀 독
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000137">
                          올드 잉글리쉬 불독
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000084">
                          올드 잉글리쉬 쉽독
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000163">
                          와이마라너
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000112">
                          와이어 폭스 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000113">
                          요크셔 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000149">
                          울프독
                        </option>

                        <option v-if="search.upKindCd == 417000" value="211">
                          웨스트 시베리언 라이카
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000110">
                          웨스트하이랜드화이트테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000205">
                          웰시 코기 카디건
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000108">
                          웰시 코기 펨브로크
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000109">
                          웰시 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000060">
                          이탈리안 그레이 하운드
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000046">
                          잉글리쉬 세터
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000047">
                          잉글리쉬 스프링거 스파니엘
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000044">
                          잉글리쉬 코카 스파니엘
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000045">
                          잉글리쉬 포인터
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000053">
                          자이언트 슈나우져
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000062">
                          재패니즈 스피츠
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000061">
                          잭 러셀 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000052">
                          저먼 셰퍼드 독
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000165">
                          저먼 와이어헤어드 포인터
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000051">
                          저먼 포인터
                        </option>

                        <option v-if="search.upKindCd == 417000" value="215">
                          저먼 헌팅 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000156">
                          제주개
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000129">
                          제페니즈칭
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000067">
                          진도견
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000035">
                          차우차우
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000033">
                          차이니즈 크레스티드 독
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000032">
                          치와와
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000158">
                          카레리안 베어독
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000144">
                          카이훗
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000030">
                          캐벌리어 킹 찰스 스파니엘
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000029">
                          케니스펜더
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000064">
                          케리 블루 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000207">
                          케언 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000028">
                          케인 코르소
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000002">
                          코리아 트라이 하운드
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000068">
                          코리안 마스티프
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000125">
                          코카 스파니엘
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000141">
                          코카 푸
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000145">
                          코카시안오브차카
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000036">
                          콜리
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000066">
                          클라인스피츠
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000065">
                          키슈
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000063">
                          키스 훈드
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000140">
                          토이 맨체스터 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000107">
                          토이 푸들
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000106">
                          티베탄 마스티프
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000209">
                          파라오 하운드
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000086">
                          파슨 러셀 테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000088">
                          팔렌
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000090">
                          퍼그
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000087">
                          페키니즈
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000138">
                          페터데일테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000089">
                          포메라니안
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000126">
                          포인터
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000127">
                          폭스테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000128">
                          푸들
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000091">
                          풀리
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000003">
                          풍산견
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000161">
                          프레사까나리오
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000050">
                          프렌치 불독
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000168">
                          프렌치 브리타니
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000049">
                          플랫 코티드 리트리버
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000147">
                          플롯하운드
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000092">
                          피레니안 마운틴 독
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000048">
                          필라 브라질레이로
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000135">
                          핏불테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000206">
                          허배너스
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000130">
                          화이트리트리버
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000134">
                          화이트테리어
                        </option>

                        <option v-if="search.upKindCd == 417000" value="000111">
                          휘펫
                        </option>

                        <option v-if="search.upKindCd == 422400" value="">
                          전체
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000116">
                          고양이
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000201">
                          기타
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000170">
                          노르웨이 숲
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000171">
                          데본 렉스
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000172">
                          러시안 블루
                        </option>

                        <option v-if="search.upKindCd == 422400" value="00213">
                          레그돌
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000173">
                          레그돌-라가머핀
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000174">
                          맹크스
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000175">
                          먼치킨
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000176">
                          메인쿤
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000212">
                          믹스묘
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000177">
                          발리네즈
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000178">
                          버만
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000179">
                          벵갈
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000180">
                          봄베이
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000216">
                          브리티쉬롱헤어
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000181">
                          브리티시 쇼트헤어
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000182">
                          사바나캣
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000183">
                          샤트룩스
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000184">
                          샴
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000185">
                          셀커크 렉스
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000186">
                          소말리
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000187">
                          스노우 슈
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000188">
                          스코티시폴드
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000189">
                          스핑크스
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000190">
                          시베리안 포레스트
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000191">
                          싱가퓨라
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000192">
                          아메리칸 쇼트헤어
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000193">
                          아비시니안
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000194">
                          재패니즈밥테일
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000195">
                          터키시 앙고라
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000196">
                          통키니즈
                        </option>

                        <option v-if="search.upKindCd == 422400" value="00214">
                          페르시안
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000197">
                          페르시안-페르시안 친칠라
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000198">
                          하바나 브라운
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000199">
                          하일랜드 폴드
                        </option>

                        <option v-if="search.upKindCd == 422400" value="000200">
                          한국 고양이
                        </option>

                        <option v-if="search.upKindCd == 429900" value="000117">
                          기타축종
                        </option>
                      </select>
                    </form>
                  </div>

                  <div
                    class="shop-pagination"
                    style="
                      float: left;
                      margin-right: 450px;
                      margin-top: 2px;
                      cursor: pointer;
                    "
                  >
                    <ul @click="searchShelnimal">
                      <li class="active">
                        <a><i class="fas fa-search"></i></a>
                      </li>
                    </ul>
                  </div>
                </div>

                <div
                  class="row justify-content-center"
                  style="float: left; margin-top: 10px"
                  v-if="total != 0"
                >
                  <div
                    v-for="(shel, index) in shelList"
                    v-bind:key="index"
                    style="width: 341px; height: 430px; padding: 10px"
                  >
                    <div class="adoption-shop-item mb-55">
                      <div class="adoption-shop-thumb">
                        <img
                          v-if="shel.popfile"
                          :src="shel.popfile"
                          style="width: 321px; height: 268px"
                          alt=""
                        />
                        <img
                          v-if="!shel.popfile"
                          src="../assets/img/image.png"
                          style="background-color: #bcbcbc"
                          alt=""
                        />
                        <router-link
                          :to="{
                            name: 'ShelDetail',
                            params: { no: shel.desertionNo },
                          }"
                          class="btn"
                          >보러가기<img src="img/icon/w_pawprint.png" alt=""
                        /></router-link>
                      </div>
                      <div class="shop-content">
                        <div class="shop-content-bottom">
                          <span class="price">
                            <i class="fa fa-bell"></i> &nbsp;
                            {{ shel.processState }} - {{ shel.kindCd }}</span
                          >
                        </div>
                        <div class="shop-content-bottom">
                          <span class="price"
                            ><i class="far fa-calendar"></i> &nbsp;{{
                              changeDateString(shel.noticeSdt)
                            }}
                            ~ {{ changeDateString(shel.noticeEdt) }}</span
                          >
                        </div>
                        <div class="shop-content-bottom">
                          <span class="price"
                            ><i class="fa fa-location-arrow"></i> &nbsp;
                            {{ shel.orgNm }}</span
                          >
                        </div>
                        <div class="shop-content-bottom">
                          <span class="price"
                            ><i class="fa fa-asterisk"></i> &nbsp;
                            {{ shel.specialMark }}</span
                          >
                        </div>
                      </div>
                    </div>
                  </div>
                </div>

                <div
                  v-if="total == 0"
                  style="text-align: center; margin-top: 20px"
                >
                  <h3>품종오류가 발생할 수 있으니 축종을 전체로 설정 후</h3>
                  <h3>한번 더 검색하시기 바랍니다.</h3>
                  <img src="/img/bg/logo5.png" alt="" />
                </div>

                <div
                  v-if="total != 0"
                  class="shop-page-meta"
                  style="
                    height: 60px;
                    width: 100%;
                    padding: 12px;
                    display: flex;
                    justify-content: center;
                  "
                >
                  <div class="shop-pagination" style="margin: 0px">
                    <ul>
                      <li>
                        <a
                          v-show="pagegroup != 1"
                          @click="pagegroup--"
                          class="pagination"
                          ><i class="fas fa-angle-double-left"></i
                        ></a>
                      </li>
                      <li
                        @click="
                          searchShelnimalPage(index + 1 + (pagegroup - 1) * 10)
                        "
                        v-for="(shel, index) in pagegroup * 10 <= pagegroupmax
                          ? 10
                          : Math.ceil((total % 90) / 9)"
                        v-bind:key="index"
                        :class="{
                          active: index + 1 + (pagegroup - 1) * 10 == page,
                        }"
                      >
                        <a class="pagination">
                          {{ index + 1 + (pagegroup - 1) * 10 }}
                        </a>
                      </li>
                      <li>
                        <a
                          v-show="pagegroup * 10 < pagegroupmax"
                          @click="pagegroup++"
                          class="pagination"
                          ><i class="fas fa-angle-double-right"></i
                        ></a>
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
            </div>
            <div class="col-lg-1"></div>
          </div>
        </div>
      </div>
      <!-- shop-area-end -->
    </main>
    <!-- main-area-end -->
  </div>
</template>

<script>
import axios from "axios";
import Datepicker from "vuejs-datepicker";

export default {
  name: "App",
  components: {
    Datepicker,
  },
  data() {
    return {
      search: {
        noticeSdt: "",
        noticeEdt: "",
        upKindCd: "",
        kindCd: "",
        neuterYn: "",
        careAddr: "",
        processState: "",
      },
      pagegroupmax: 0,
      pagegroup: 1,
      page: 1,
      total: 0,
      shelList: [],
    };
  },
  created() {
    if(this.$store.getters.getHaderindex != 1)
      this.$store.dispatch('reset')
    this.searchShelnimaldefualt();
    this.$store.commit("setHaderindex", 1);
  },
  methods: {
    noticeSdt_dateFormat(date) {
      let month = date.getMonth() + 1;
      let day = date.getDate();
      month = month >= 10 ? month : "0" + month;
      day = day >= 10 ? day : "0" + day;
      this.search.noticeSdt = date.getFullYear() + month + day;
    },
    noticeEdt_dateFormat(date) {
      let month = date.getMonth() + 1;
      let day = date.getDate();
      month = month >= 10 ? month : "0" + month;
      day = day >= 10 ? day : "0" + day;
      this.search.noticeEdt = date.getFullYear() + month + day;
    },
    changeDateString(date) {
      var year = date.substr(0, 4);
      var month = date.substr(4, 2);
      var day = date.substr(6, 2);
      return year + "-" + month + "-" + day;
    },
    searchShelnimaldefualt() {
      if(this.$store.getters.getShelSearch.page != ""){
        const datas = this.$store.getters.getShelSearch
        this.search.noticeSdt = datas.noticeSdt
        this.search.noticeEdt = datas.noticeEdt
        this.search.upKindCd = datas.upKindCd
        this.search.kindCd = datas.kindCd
        this.search.neuterYn = datas.neuterYn
        this.search.careAddr = datas.careAddr
        this.search.processState = datas.processState
        this.page = datas.page
        this.searchShelnimalPage(this.page)
        return;
      }
      this.shelList = "";
      this.$store.commit("loading/load", true);
      axios({
        method: "get",
        url: "/api/shel/1",
      })
        .then((res) => {
          this.shelList = res.data.shelnimalDtos;
          this.total = res.data.allCount;
          this.pagegroupmax = Math.ceil(this.total / 9);
        })
        .catch((error) => {
          console.log(error);
        })
        .finally(() => this.$store.commit("loading/load", false));
    },

    searchShelnimal() {
      this.shelList = "";
      this.$store.commit("loading/load", true);
      this.page = 1;
      let data = {
        noticeSdt: this.search.noticeSdt == null ? null : this.search.noticeSdt,
        noticeEdt: this.search.noticeEdt == null ? null : this.search.noticeEdt,
        upKindCd: this.search.upKindCd,
        kindCd: this.search.kindCd,
        neuterYn: this.search.neuterYn,
        careAddr: this.search.careAddr,
        processState: this.search.processState,
        offset: 1,
      };

      axios({
        method: "post",
        url: "/api/shel/",
        data: data,
      })
        .then((res) => {
          this.shelList = res.data.shelnimalDtos;
          this.total = res.data.allCount;
          this.pagegroup = 1;
          this.pagegroupmax = Math.ceil(this.total / 9);
          const datas = this.search
          datas.page = this.page
          this.$store.commit('setShelSearch', datas)
        })
        .catch((error) => {
          console.log(error);
          this.shelList = "";
          this.total = 0;
          this.pagegroupmax = 0;
        })
        .finally(() => this.$store.commit("loading/load", false));
    },

    searchShelnimalPage(el) {
      this.shelList = "";
      this.$store.commit("loading/load", true);
      this.page = el;

      let data = {
        noticeSdt: this.search.noticeSdt == null ? null : this.search.noticeSdt,
        noticeEdt: this.search.noticeEdt == null ? null : this.search.noticeEdt,
        upKindCd: this.search.upKindCd,
        kindCd: this.search.kindCd,
        neuterYn: this.search.neuterYn,
        careAddr: this.search.careAddr,
        processState: this.search.processState,
        offset: el,
      };

      axios({
        method: "post",
        url: "/api/shel/",
        data: data,
      })
        .then((res) => {
          this.shelList = res.data.shelnimalDtos;
          this.total = res.data.allCount;
          this.pagegroupmax = Math.ceil(this.total / 9);
          const datas = this.search
          datas.page = this.page
          this.$store.commit('setShelSearch', datas)
        })
        .catch((error) => {
          console.log(error);
          this.shelList = "";
          this.total = 0;
          this.pagegroupmax = 0;
        })
        .finally(
          () => this.$store.commit("loading/load", false),
          window.scrollTo(0, 0)
        );
    },
  },
};
</script>

<style>
#app {
}
.pagination {
  cursor: pointer;
}

#input_date {
  border: 1px solid #e1e1e1;
  background: #fff;
  padding: 8px 25px 8px 11px;
  min-width: 54px;
  font-size: 13px;
  font-weight: 500;
  color: #111e49;
  border-radius: 3px;
  width: 120px;
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
