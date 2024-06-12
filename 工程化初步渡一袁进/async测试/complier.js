const regenerator = require('regenerator');
const fs = require('fs');
const path = require('path');

const sourcePath = path.resolve(__dirname, './source.js');

const source = fs.readFileSync(sourcePath,'utf-8');




const  result = regenerator.compile(/*`async function test(){
    return await Promise.resolve(1);
}
(async ()=>{
    const r = await test();
    console.log(r);
})()`*/
    source
    ,{

    inclueRuntime:true,
})

/*console.log(result);*/

const targetPath = path.resolve(__dirname,'./target.js');
fs.writeFileSync(targetPath,result.code,'utf-8');
console.log('sucess')
