module.exports = {
    // plugins: ['@babel/plugin-transform-optional-chaining']
    presets: [
        ['@babel/preset-env',{
        targets:{
            edge:'17',
            firefox:'60',
            chrome:'67',
            safari:'11.0'
        },
            useBuiltIns:'usage',//按需导入
            corejs:'3'
        }]
    ],
}