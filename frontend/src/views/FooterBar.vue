<template>
  <div id="app">
    <!-- footer-start -->
    <footer>
      <div class="footer-top-area footer-bg">
        <div class="container">
          <div class="row justify-content-between">
            <div class="col-3">
              <div class="footer-widget">
                <div class="f-logo">
                  <router-link to="/"
                    ><img
                      src="/img/logo/paw_logo_2line.png"
                      alt=""
                      onclick="window.scrollTo(0,0);"
                  /></router-link>
                </div>
                <div class="footer-text">
                  <p>
                    For Four Paw 에서는 유기동물 및 실종동물을 <br />
                    조회할 수 있습니다.
                  </p>
                </div>
                <!-- <div class="footer-contact">
                  <div class="icon"><i class="fas fa-headphones"></i></div>
                  <div class="content">
                    <h4 class="title">
                      <a href="tel:0987654321">747-800-9880</a>
                    </h4>
                    <span>Call Now</span>
                  </div>
                </div>
                <div class="footer-social">
                  <ul>
                    <li>
                      <a href="#"><i class="fab fa-facebook-f"></i></a>
                    </li>
                    <li>
                      <a href="#"><i class="fab fa-twitter"></i></a>
                    </li>
                    <li>
                      <a href="#"><i class="fab fa-youtube"></i></a>
                    </li>
                    <li>
                      <a href="#"><i class="fab fa-linkedin-in"></i></a>
                    </li>
                  </ul>
                </div> -->
              </div>
            </div>
            <!-- <div class="col-2">
              <div class="footer-widget">
                <h4 class="fw-title">Our Policies</h4>
                <div class="fw-link">
                  <ul>
                    <li><a href="contact.html">Privacy Policy</a></li>
                    <li><a href="contact.html">Terms and Conditions</a></li>
                    <li><a href="contact.html">Editorial Policy</a></li>
                    <li><a href="contact.html">Return Policy</a></li>
                    <li><a href="contact.html">IP Policy</a></li>
                    <li>
                      <a href="contact.html">Grievance Redressal Policy</a>
                    </li>
                    <li><a href="contact.html">Our Conditions</a></li>
                  </ul>
                </div>
              </div>
            </div>
            <div class="col-2">
              <div class="footer-widget">
                <h4 class="fw-title">Our Services</h4>
                <div class="fw-link">
                  <ul>
                    <li><a href="breeder.html">Our Breeder</a></li>
                    <li><a href="adoption.html">Our Adoption</a></li>
                    <li><a href="contact.html">Editorial Policy</a></li>
                    <li><a href="contact.html">Return Policy</a></li>
                    <li><a href="contact.html">Grievance Policy</a></li>
                    <li><a href="contact.html">Redressal Policy</a></li>
                    <li><a href="contact.html">Contact Us</a></li>
                  </ul>
                </div>
              </div>
            </div> -->
            <div class="col-7">
              <div class="footer-widget">
                <h4 class="fw-title">Team</h4>
                <div class="fw-insta">
                  <ul>
                    <li>
                      <a href="#"
                        ><img
                          class="team"
                          src="/img/team/soon.png"
                          alt=""
                          width="92px"
                          height="92px"
                      /></a>
                      정순일
                    </li>
                    <li>
                      <a href="#"
                        ><img
                          class="team"
                          src="/img/team/sik.jpg"
                          alt=""
                          width="92px"
                          height="92px"
                      /></a>
                      우윤식
                    </li>
                    <li>
                      <a href="#"
                        ><img
                          class="team"
                          src="/img/team/tak.jpg"
                          alt=""
                          width="92px"
                          height="92px"
                      /></a>
                      류기탁
                    </li>
                    <li>
                      <a href="#"
                        ><img
                          class="team"
                          src="/img/team/sang.png"
                          alt=""
                          width="92px"
                          height="92px"
                      /></a>
                      최상후
                    </li>
                    <li>
                      <a href="#"
                        ><img
                          class="team"
                          src="/img/team/chan.png"
                          alt=""
                          width="92px"
                          height="92px"
                      /></a>
                      윤찬호
                    </li>
                    <li>
                      <a href="#"
                        ><img
                          class="team"
                          src="/img/logo/character.png"
                          alt=""
                          width="92px"
                          height="92px"
                      /></a>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="footer-shape">
          <img src="/img/images/footer_shape01.png" alt="" />
        </div>
        <div class="footer-shape shape-two">
          <img src="/img/images/footer_shape02.png" alt="" />
        </div>
      </div>
      <div class="copyright-area">
        <div class="container">
          <div class="row">
            <div class="col-md-8">
              <div class="copyright-text">
                <p>Copyright &copy; 2021 Petco. All Rights Reserved.</p>
              </div>
            </div>
            <!-- <div class="col-md-4 d-none d-md-block">
              <div class="footer-lang">
                <div class="dropdown">
                  <button
                    class="dropdown-toggle"
                    type="button"
                    id="dropdownMenuButton2"
                    data-toggle="dropdown"
                    aria-haspopup="true"
                    aria-expanded="false"
                  >
                    <img src="/img/icon/united-states.png" alt="" /> English
                  </button>
                  <div
                    class="dropdown-menu"
                    aria-labelledby="dropdownMenuButton2"
                  >
                    <a class="dropdown-item" href="index.html"
                      ><img src="/img/icon/russia.png" alt="" />Russia</a
                    >
                    <a class="dropdown-item" href="index.html"
                      ><img src="/img/icon//thailand.png" alt="" />Thailand</a
                    >
                    <a class="dropdown-item" href="index.html"
                      ><img src="/img/icon/india.png" alt="" />India</a
                    >
                  </div>
                </div>
              </div>
            </div> -->
          </div>
        </div>
      </div>
    </footer>
  </div>
</template>

<script>
export default {
  name: "App",
  components: {},
};
</script>

<style scoped>
.team {
  border-radius: 50%;
}
</style>
