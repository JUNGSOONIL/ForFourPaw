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
                    <canvas id="Chart_date" style="width:100% height:100%"></canvas>
                  </div>
                </div>

                <div class="row justify-content-center">
                  <div><h1> 품종 별 WORD CLOUD </h1></div>
                  <div>
                  </div>
                </div>
                
                <div class="row justify-content-center">
                  <div class="col" style="background-color:white width:100% height:100%">
                    <div id="kind_wordcloud"></div>
                  </div>
                </div> 


                <div class="row justify-content-center">
                  <div><h1> 지역별 통계 </h1></div>
                  <div>
                  </div>
                </div>
                
                <div class="row justify-content-center">
                  <div class="col" style="background-color:white width:100% height:100%">
                    <div id="kind_wordcloud"></div>
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
                  
                </div>

                <!-- 메인 그리드 끝 -->
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
              </div>x
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
    components : {
    }, 
    data : function() {
        return {
            Chart_Weight : null,
            Chart_Date : null,
            words : [],
        }
    },
    mounted() {
        console.log("[system] mounted! ");
        this.chart_test();
    },
    methods : {
        // 테스트용
        test() {

            console.log("[system] 차트 불러오기 ");

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
                
                // 무게 무게별 동물 데이터 불러오기
                templaabels[0] = "1 Kg 미만";
                templaabels[templaabels.length -1] = "10 Kg 이상";
                // console.log(templaabels);
                // console.log(tempdata);
                const ctx = document.getElementById('Chart_weight').getContext('2d');
                this.Chart_Weight.destroy();
                this.Chart_Weight = new Chart( ctx, {
                    type: 'bar',
                    data: {
                        labels : templaabels ,
                        datasets: [{
                            label: '# of Votes',
                            data : tempdata,
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
                
                // 날짜별 chart_date
                // 차트가 없을 땐 v-show로 이미지를 보여주던가 해도 괜찮을 듯
                templaabels = [];
                tempdata = [];
                res.data.datelist.forEach(element => {
                    templaabels.push( ( Number(element.key) + 1) + " 월");
                    tempdata.push(element.value);
                });
                const ctx2 = document.getElementById('Chart_date').getContext('2d');
                this.Chart_Date = new Chart( ctx2, {
                    type: 'bar',
                    data: {
                        labels : templaabels ,
                        datasets: [{
                            label: '# of Votes',
                            data : tempdata,
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
                
                // 품종 정리
                res.data.kindlist2.forEach( element => {
                    if ( 120000 < element.value ) element.value = 130000
                    else if ( 200 >  element.value) element.value = 200
                    this.words.push( { text: element.key , size: element.value } );
                });

                this.kindwordcloudload();
                // console.log("words리스트");
                // console.log(this.words);
                


                console.log("[system] 통신 완료");
           
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
        // word cloud test
        kindwordcloudload(){
          const cloud = require("d3-cloud");
          cloud()
              .words(this.words)
              .size(["1200", "1500"])
              .padding(1)
              .font("Impact")
              // .rotate 단어돌리기
              .rotate ( function(  ) { 
                // return (~~(Math.random() * 6) - 3) * 1;
                // if ( d.size > 55920) return 90;
                // else 
                return 0; 
                })
              .fontSize( function (d) { return (Math.sqrt(d.size) * 0.8 ); })
              // .fontSize(function (d) {
              //       return wordScale(d.frequency);
              //   })
              // end는 모든 단어를 다 위치 시킬 때 발생
              .on("end", this.end)
              .spiral("archimedean")
              .start()
              .stop();
          
          
        },
        end(words){
          
          const d3 = require("d3");
          const width = 1200;
          const height = 1500;
          d3.select("#kind_wordcloud")
            .append("svg")
            .attr("width", width)
            .attr( "height", height )
            // 출력크기
            .style("background", "white")
            .append("g")
            // g를 중심에서 단어를 그리기 때문에 g를 svg중심으로 이동한다.
            .attr("transform", "translate(" +  width/2 + "," + height/2+ ")")
            .style("fill", function ( d ) {
                        // if ( d.size > 55920) return ( "#506230" );
                        // else 
                        console.log(d);
                        return ( "#000000");
                    })
            .selectAll("text")
            .data(words)
            .enter()
            .append("text")
            // .style("fill-opacity", .5) // 투명도
            .style("font-size" , (d) => {
              // if ( d.size)
              return d.size + "px";
            })
            .style("font-family", "Impact")
            .attr("text-anchor", "middle")
            .attr("transform", (d) => {
              return "translate(" + [d.x, d.y] + ")rotate( " + d.rotate + ")";
            })
            .text( (d) => d.text );
        

        },
        // wordcloudload2( aaa , bbb) {
        //   aaa = this.aaa;
        //   bbb = this.bbb;
        // },
        
        


    }

}
</script>
<style>
#app {
}
</style>
