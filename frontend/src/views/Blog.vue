<template>
  <div id="app">
    <!-- main-area -->
    <main>
      <!-- breadcrumb-area -->
      <section
        class="breadcrumb-area breadcrumb-bg"
        style="background-image: url('/img/bg/breadcrumb_bg.jpg')"
      >
        <div class="container">
          <div class="row">
            <div class="col-12">
              <div class="breadcrumb-content">
                <h2 class="title">Our Blog</h2>
                <nav aria-label="breadcrumb">
                  <ol class="breadcrumb">
                    <li class="breadcrumb-item">
                      <router-link to="/">Home</router-link>
                    </li>
                    <li class="breadcrumb-item active" aria-current="page">
                      Our Blog
                    </li>
                  </ol>
                </nav>
              </div>
            </div>
          </div>
        </div>
      </section>
      <!-- breadcrumb-area-end -->

      <!-- blog-area -->
      <section class="standard-blog-area">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-8">
              <div class="standard-blog-item">
                <div class="standard-blog-thumb">
                  <a href="blog-details.html"
                    ><img src="/img/blog/blog_thumb01.jpg" alt=""
                  /></a>
                </div>
                <div class="standard-blog-content">
                  <div class="blog-post-meta">
                    <ul>
                      <li class="tags">
                        <i class="flaticon-bookmark-1"></i>
                        <a href="#">Siberian Husky , </a>
                        <a href="#">Breed</a>
                      </li>
                      <li><i class="far fa-user"></i><a href="#">Admin</a></li>
                      <li><i class="far fa-bell"></i> Mar 10, 2021</li>
                    </ul>
                  </div>
                  <h2 class="title">
                    <a href="blog-details.html"
                      >Online pet everything your pet needs</a
                    >
                  </h2>
                  <p>
                    The domestic dog is a domesticated descendant of the wolf.
                    The dog derived from an ancient, extinct wolf, and the
                    modern grey wolf is the dog's nearest living relative. The
                    dog was the first species to be domesticated, by
                    hunter–gatherers.
                  </p>
                  <a href="blog-details.html" class="read-more"
                    >Read More <img src="/img/icon/pawprint.png" alt=""
                  /></a>
                </div>
              </div>
              <div class="standard-blog-item">
                <div class="standard-blog-thumb">
                  <a href="blog-details.html"
                    ><img src="/img/blog/blog_thumb02.jpg" alt=""
                  /></a>
                </div>
                <div class="standard-blog-content">
                  <div class="blog-post-meta">
                    <ul>
                      <li class="tags">
                        <i class="flaticon-bookmark-1"></i>
                        <a href="#">Siberian Husky , </a>
                        <a href="#">Breed</a>
                      </li>
                      <li><i class="far fa-user"></i><a href="#">Admin</a></li>
                      <li><i class="far fa-bell"></i> Mar 10, 2021</li>
                    </ul>
                  </div>
                  <h2 class="title">
                    <a href="blog-details.html"
                      >Pet needs special food like human foods</a
                    >
                  </h2>
                  <p>
                    The domestic dog is a domesticated descendant of the wolf.
                    The dog derived from an ancient, extinct wolf, and the
                    modern grey wolf is the dog's nearest living relative. The
                    dog was the first species to be domesticated, by
                    hunter–gatherers.
                  </p>
                  <a href="blog-details.html" class="read-more"
                    >Read More <img src="/img/icon/pawprint.png" alt=""
                  /></a>
                </div>
              </div>
              <div class="standard-blog-item">
                <div class="standard-blog-thumb">
                  <a href="blog-details.html"
                    ><img src="/img/blog/blog_thumb03.jpg" alt=""
                  /></a>
                </div>
                <div class="standard-blog-content">
                  <div class="blog-post-meta">
                    <ul>
                      <li class="tags">
                        <i class="flaticon-bookmark-1"></i>
                        <a href="#">Siberian Husky , </a>
                        <a href="#">Breed</a>
                      </li>
                      <li><i class="far fa-user"></i><a href="#">Admin</a></li>
                      <li><i class="far fa-bell"></i> Mar 10, 2021</li>
                    </ul>
                  </div>
                  <h2 class="title">
                    <a href="blog-details.html"
                      >Special grades for carry-home food</a
                    >
                  </h2>
                  <p>
                    The domestic dog is a domesticated descendant of the wolf.
                    The dog derived from an ancient, extinct wolf, and the
                    modern grey wolf is the dog's nearest living relative. The
                    dog was the first species to be domesticated, by
                    hunter–gatherers.
                  </p>
                  <a href="blog-details.html" class="read-more"
                    >Read More <img src="/img/icon/pawprint.png" alt=""
                  /></a>
                </div>
              </div>
            </div>
            <div class="col-lg-4 col-md-8">
              <aside class="blog-sidebar">
                <div class="widget">
                  <h4 class="sidebar-title">Search</h4>
                  <div class="sidebar-search">
                    <form action="#">
                      <input type="text" placeholder="Search ..." />
                      <button type="submit">
                        <i class="fa fa-search"></i>
                      </button>
                    </form>
                  </div>
                </div>
                <div class="widget">
                  <h4 class="sidebar-title">Categories</h4>
                  <div class="sidebar-cat-list">
                    <ul>
                      <li>
                        <a href="#"
                          >Siberian Husky
                          <i class="fas fa-angle-double-right"></i
                        ></a>
                      </li>
                      <li>
                        <a href="#"
                          >German Sherped
                          <i class="fas fa-angle-double-right"></i
                        ></a>
                      </li>
                      <li>
                        <a href="#"
                          >French Bulldog
                          <i class="fas fa-angle-double-right"></i
                        ></a>
                      </li>
                      <li>
                        <a href="#"
                          >Golden Retriever
                          <i class="fas fa-angle-double-right"></i
                        ></a>
                      </li>
                    </ul>
                  </div>
                </div>
                <div class="widget">
                  <h4 class="sidebar-title">Recent Post</h4>
                  <div class="rc-post-list">
                    <ul>
                      <li>
                        <div class="rc-post-thumb">
                          <a href="blog-details.html"
                            ><img src="/img/blog/rc_post_thumb01.jpg" alt=""
                          /></a>
                        </div>
                        <div class="rc-post-content">
                          <h5 class="title">
                            <a href="blog-details.html"
                              >Best Online Pet Everything Your Pet Needs</a
                            >
                          </h5>
                          <div class="rc-post-meta">
                            <ul>
                              <li>
                                <i class="far fa-calendar-alt"></i> April 15,
                                2021
                              </li>
                              <li>By <a href="#">Admin</a></li>
                            </ul>
                          </div>
                        </div>
                      </li>
                      <li>
                        <div class="rc-post-thumb">
                          <a href="blog-details.html"
                            ><img src="/img/blog/rc_post_thumb02.jpg" alt=""
                          /></a>
                        </div>
                        <div class="rc-post-content">
                          <h5 class="title">
                            <a href="blog-details.html"
                              >Pet Needs Special Food like Human Foods</a
                            >
                          </h5>
                          <div class="rc-post-meta">
                            <ul>
                              <li>
                                <i class="far fa-calendar-alt"></i> October 15,
                                2021
                              </li>
                              <li>By <a href="#">Admin</a></li>
                            </ul>
                          </div>
                        </div>
                      </li>
                    </ul>
                  </div>
                </div>
                <div class="widget sidebar-newsletter">
                  <div class="sn-icon">
                    <img src="/img/icon/sn_icon.png" alt="" />
                  </div>
                  <div class="sn-title">
                    <h4 class="title">Subscribe Newsletter</h4>
                    <p>Sign-up For Latest News</p>
                  </div>
                  <form action="#" class="sn-form">
                    <input type="text" placeholder="Enter Your Email" />
                    <button class="btn">subscribe</button>
                  </form>
                </div>
              </aside>
            </div>
          </div>
        </div>
      </section>
      <!-- blog-area-end -->
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

<style></style>
