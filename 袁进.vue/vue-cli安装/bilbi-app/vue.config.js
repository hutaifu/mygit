const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})

module.exports = {
  devServer:{
    proxy:{
      //配置代理
      "/x":{
        target:"https://api.bilibili.com",
        onProxyReq(proxyReq){
          proxyReq.setHeader("Oringn","https://www.bilibili.com")
          proxyReq.setHeader("Referer","https://www.bilibili.com/")
        }
      }
    }
  }
}