require('core-js/modules/es.array.flat-map')

const result = [1,2].flatMap((x)=>[x,x*2]);
console.log(result)

async function test(){
    return await Promise.resolve(1);
}
(async ()=>{
    const r = await test();
    console.log(r);
})()