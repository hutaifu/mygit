module.exports = {
  //预设包，
  presets: [
    '@addVueCom/cli-plugin-babel/preset',
      //elementUI按需引入
    ["@babel/preset-env", { "modules": false }]
  ],
  plugins: [
    [
      "component",
      {
        "libraryName": "element-ui",
        "styleLibraryName": "theme-chalk"
      }
    ]
  ]
}
