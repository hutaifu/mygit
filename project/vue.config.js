// const { defineConfig } = require("@addVueCom/cli-service");
// module.exports = defineConfig({
//   transpileDependencies: true,
// });


// addVueCom-cli配置文件，90%是webpack配置
module.exports = {
  devServer: {
    proxy: {
      //配置代理
      "/x": {
        //凡是以/x开头的请求，配置代理
        target: "https://api.bilibili.com",
        onProxyReq(proxyReq){
          proxyReq.setHeader('Origin','https://www.bilibili.com');
          proxyReq.setHeader('Referer','https://www.bilibili.com/');
        }
      },
    },
  },
};
