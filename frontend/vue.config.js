const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
  transpileDependencies: true,
});

module.exports = {
  // 개발 서버 설정
  devServer: {
    // 프록시 설정
    port: 5500,
    proxy: {
      //프록시 요청을 보낼 api의 시작 부분
      "/api": {
        //프록시 요청을 보낼 서버의 주소
        target: "https://j6e105.p.ssafy.io:8443",
        //target: 'http://localhost:8080',
        // target: 'http://3.38.149.72:8443',
        changeOrigin: true,
      },
    },
  },
};
