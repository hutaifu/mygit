//引入一个包
 const path = require("path");
//yinr hmtl插件
const HtmlWebpackPlugin = require("html-webpack-plugin")

//webpack中所有的配置信息都应该写在module.exports中
module.exports = {
    //指定入口文件
    entry:"./src/main.ts",
    //指定打包文件所在的目录
    output:{
        //指定打包文件的目录
        path:path.resolve(__dirname,'dist'),
        //打包后文件的文件
        filename:'bundle.js'
    }
    //指定webpack打包时要使用模块
    ,module:{
        //指定加载的规则
        rules:[
            {
                //test指定的是规则生效的文件
                test:/\.ts$/,
                //要使用的loader
                use:'ts-loader',
                //要排除的文件
                exclude:/node-modules/
            }
        ]
    },

    //配置webpack插件
    plugins:[
        new HtmlWebpackPlugin({
            // title:"自定义tiltle"
            template:"./src/index.html"
        }),
    ]
};