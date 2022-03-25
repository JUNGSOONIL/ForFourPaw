<template>
  <div id="AnalysisView">
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
                <h2 class="title"> 유기동물 데이터 분석 </h2>
                <nav aria-label="breadcrumb">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                      <router-link to="/"> Main </router-link>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                      유기동물 데이터 분석
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
        <div class="row justify-content-center"> 
          <div class="col-lg-9">
              <div class="shop-wrap">
                <h4 class="title"> 통계 보기</h4>
                <div class="shop-page-meta mb-30">
                  <div class="shop-grid-menu">
                    <ul>
                      <li class="active">
                        
                      </li>
                      <li>
                        
                      </li>
                    </ul>
                  </div>
                  <div class="shop-showing-result">
                    <p> 없으면 뭔가 허전한 부분 </p>
                  </div>
                  <div class="shop-show-list">
                    <form action="#">
                      <label for="show">Show</label>
                      <select id="show" class="selected">
                        <option value="">08</option>
                        <option value="">12</option>
                        <option value="">16</option>
                        <option value="">18</option>
                        <option value="">20</option>
                      </select>
                    </form>
                  </div>
                  <div class="shop-short-by">
                    <form action="#">
                      <label for="shortBy">Sort By</label>
                      <select id="shortBy" class="selected">
                        <option value="">Sort by latest</option>
                        <option value="">Low to high</option>
                        <option value="">High to low</option>
                        <option value="">Popularity</option>
                      </select>
                    </form>
                  </div>
                </div>

                <div class="row justify-content-center">
                  <div><h1> 무게 통계 </h1></div>
                  <div>
                  <button type="button" class="btn btn-outline-primary" @click="test" > 
                      불러오기
                  </button>
                  </div>
                </div>
                
                <div class="row justify-content-center">
                  <div class="col" style="background-color:white">
                    <canvas id="Chart_weight" style="width:100% height:100%"></canvas>
                  </div>
                </div> 
                
                <div class="row justify-content-center">
                  <div><h1> 날짜별 통계 </h1></div>
                  <div>

                  </div>
                </div>
                
                <div class="row justify-content-center">
                  <div class="col" style="background-color:white">
                    <canvas id="myChart2" style="width:100% height:100%"></canvas>
                  </div>
                </div>



                <div class="row justify-content-center">


                  <div class="col-lg-4 col-sm-6">

                    <div class="shop-item mb-55">
                      <div class="shop-thumb">

                        <a href="shop-details.html"
                          ><img src="img/product/shop_item01.jpg" alt=""
                        /></a>
                        
                      </div>
                      <div class="shop-content">
                        <span> CHART </span>
                        <h4 class="title">
                          <a href="shop-details.html">무게 별 유기동물 수</a>
                        </h4>
                        <div class="shop-content-bottom">
                          <span>2007 ~ 2021</span>
                        </div>
                      </div>
                      
                    </div>
                  </div>
                  
                  <div class="col-lg-4 col-sm-6">
                    <div class="shop-item mb-55">
                      <div class="shop-thumb">
                        <a href="shop-details.html"
                          ><img src="img/product/shop_item02.jpg" alt=""
                        /></a>
                      </div>
                      <div class="shop-content">
                        <span>Dog toy’s</span>
                        <h4 class="title">
                          <a href="shop-details.html">Squeaky Dog</a>
                        </h4>
                        <div class="shop-content-bottom">
                          <span class="price">$19.00</span>
                          <span class="add-cart"
                            ><a href="shop-details.html">ADD +</a></span
                          >
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-lg-4 col-sm-6">
                    <div class="shop-item mb-55">
                      <div class="shop-thumb">
                        <a href="shop-details.html"
                          ><img src="img/product/shop_item03.jpg" alt=""
                        /></a>
                      </div>
                      <div class="shop-content">
                        <span>Dog toy’s</span>
                        <h4 class="title">
                          <a href="shop-details.html">Pet Knit Knacks</a>
                        </h4>
                        <div class="shop-content-bottom">
                          <span class="price">$29.00</span>
                          <span class="add-cart"
                            ><a href="shop-details.html">ADD +</a></span
                          >
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-lg-4 col-sm-6">
                    <div class="shop-item mb-55">
                      <div class="shop-thumb">
                        <a href="shop-details.html"
                          ><img src="img/product/shop_item04.jpg" alt=""
                        /></a>
                      </div>
                      <div class="shop-content">
                        <span>Dog toy’s</span>
                        <h4 class="title">
                          <a href="shop-details.html">Yoda Carriage</a>
                        </h4>
                        <div class="shop-content-bottom">
                          <span class="price">$49.00</span>
                          <span class="add-cart"
                            ><a href="shop-details.html">ADD +</a></span
                          >
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-lg-4 col-sm-6">
                    <div class="shop-item mb-55">
                      <div class="shop-thumb">
                        <a href="shop-details.html"
                          ><img src="img/product/shop_item05.jpg" alt=""
                        /></a>
                      </div>
                      <div class="shop-content">
                        <span>Dog toy’s</span>
                        <h4 class="title">
                          <a href="shop-details.html">Pet Carriage</a>
                        </h4>
                        <div class="shop-content-bottom">
                          <span class="price">$09.00</span>
                          <span class="add-cart"
                            ><a href="shop-details.html">ADD +</a></span
                          >
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="col-lg-4 col-sm-6">
                    <div class="shop-item mb-55">
                      <div class="shop-thumb">
                        <a href="shop-details.html"
                          ><img src="img/product/shop_item06.jpg" alt=""
                        /></a>
                      </div>
                      <div class="shop-content">
                        <span>Dog toy’s</span>
                        <h4 class="title">
                          <a href="shop-details.html">Squeaky Dog</a>
                        </h4>
                        <div class="shop-content-bottom">
                          <span class="price">$16.00</span>
                          <span class="add-cart"
                            ><a href="shop-details.html">ADD +</a></span
                          >
                        </div>
                      </div>
                    </div>
                  </div>
                  
                  
                  
                </div>
                <div class="shop-page-meta">
                  <div class="shop-grid-menu">
                    <ul>
                      <li class="active">
                        <a href="#"><i class="fas fa-th"></i></a>
                      </li>
                      <li>
                        <a href="#"><i class="fas fa-list"></i></a>
                      </li>
                    </ul>
                  </div>
                  <div class="shop-showing-result">
                    <p>Total Items 1-12 of 13</p>
                  </div>
                  <div class="shop-show-list">
                    <form action="#">
                      <label for="bottomShow">Show</label>
                      <select id="bottomShow" class="selected">
                        <option value="">08</option>
                        <option value="">12</option>
                        <option value="">16</option>
                        <option value="">18</option>
                        <option value="">20</option>
                      </select>
                    </form>
                  </div>
                  <div class="shop-pagination">
                    <ul>
                      <li class="active"><a href="shop.html">1</a></li>
                      <li><a href="shop.html">2</a></li>
                      <li>
                        <a href="shop.html"
                          ><i class="fas fa-angle-double-right"></i
                        ></a>
                      </li>
                    </ul>
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
// const session = window.sessionStorage;

// for chart
import { Chart, registerables } from 'chart.js';
Chart.register(...registerables);

export default  {
    name : 'AnalysisView',
    data : function() {
        return {
            Chart_Weight : null,
            Chart_Date : null
        }
    },
    mounted() {
        console.log("[system] mounted! ");
        this.chart_test();
    },
    methods : {
        // 테스트용
        test() {

            console.log("[system] 테스트 통신 시작");

            // let headers = {
            //     'at-jwt-access-token': session.getItem('at-jwt-access-token'),
            //     'at-jwt-refresh-token': session.getItem('at-jwt-refresh-token'),
            // };

            let data = {
            name: '',
            type: ''
            };
            axios({
                method: 'get',
                url: '/api/test',
                data: data, // post 나 put에 데이터 넣어 줄때
            }).then((res) => {
                // this.$store.dispatch('login/accessTokenRefresh', res) // store아닌곳에서
                // this.dispatch('accessTokenRefresh', res) // store에서
                console.log(res.data);
                // var resultlist = res.data.list;
                var templaabels = [];
                var tempdata = [];
                res.data.list.forEach(element => {
                    var name = "";
                    name = element.key + " ~ " + ( parseInt(element.key) + 1 ) + " Kg"; 
                    // templaabels.push(element.key);
                    templaabels.push(name);
                    tempdata.push(element.value);
                });
                
                templaabels[0] = "1 Kg 미만";
                templaabels[templaabels.length -1] = "10 Kg 이상";
                
                console.log(templaabels);
                console.log(tempdata);

                const ctx = document.getElementById('Chart_weight').getContext('2d');
                this.Chart_Weight.destroy();

                this.Chart_Weight = new Chart( ctx, {
                    type: 'bar',
                    data: {
                        labels : templaabels ,
                        datasets: [{
                            label: '# of Votes',
                            data : tempdata,
                            // backgroundColor: [
                            //     'rgba(255, 99, 132, 0.2)',
                            //     'rgba(54, 162, 235, 0.2)',
                            //     'rgba(255, 206, 86, 0.2)',
                            //     'rgba(75, 192, 192, 0.2)',
                            //     'rgba(153, 102, 255, 0.2)',
                            //     'rgba(255, 159, 64, 0.2)'
                            // ],
                            // borderColor: [
                            //     'rgba(255, 99, 132, 1)',
                            //     'rgba(54, 162, 235, 1)',
                            //     'rgba(255, 206, 86, 1)',
                            //     'rgba(75, 192, 192, 1)',
                            //     'rgba(153, 102, 255, 1)',
                            //     'rgba(255, 159, 64, 1)'
                            // ],
                            borderWidth: 1
                        }]
                    },
                    options: {
                        scales: {
                            y: {
                                beginAtZero: true
                            }
                        }
                    }
                });


                console.log("통신 완료");
           
           }).catch((error) => {
                console.log(error);
            }).then(() => {
                console.log('getQSSList End!!');
            });
        
        },
        chart_test(){
            const ctx = document.getElementById('Chart_weight').getContext('2d');
            // const ctx2 = document.getElementById('myChart2').getContext('2d');

            this.Chart_Weight = new Chart( ctx, {
                type: 'bar',
                data: {
                    labels: ['Red', 'Blue', 'Yellow', 'Green', 'Purple', 'Orange'],
                    datasets: [{
                        label: '# of Votes',
                        data: [12, 19, 3, 5, 2, 3],
                        backgroundColor: [
                            'rgba(255, 99, 132, 0.2)',
                            'rgba(54, 162, 235, 0.2)',
                            'rgba(255, 206, 86, 0.2)',
                            'rgba(75, 192, 192, 0.2)',
                            'rgba(153, 102, 255, 0.2)',
                            'rgba(255, 159, 64, 0.2)'
                        ],
                        borderColor: [
                            'rgba(255, 99, 132, 1)',
                            'rgba(54, 162, 235, 1)',
                            'rgba(255, 206, 86, 1)',
                            'rgba(75, 192, 192, 1)',
                            'rgba(153, 102, 255, 1)',
                            'rgba(255, 159, 64, 1)'
                        ],
                        borderWidth: 1
                    }]
                },
                options: {
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });

        },
        
        


    }

}
</script>

<style>
#app {
}
</style>
