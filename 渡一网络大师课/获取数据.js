// Get https://study.duyiedu.com/api/herolist
async function init(){
//当行和头全部到达客户端，该promise完成（不会等待响应体）

const resp = await fetch('https://study.duyiedu.com/api/herolist').then(()=>{
    console.log(resp.status)
})
const str = await resp.json();
console.log(str)
str.data.map(h=>{

})
}

init()
