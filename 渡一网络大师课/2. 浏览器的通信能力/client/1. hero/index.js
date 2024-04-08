// GET https://study.duyiedu.com/api/herolist
// async function init() {
//   // 当行和头全部达到客户端后，该promise完成（不会等待响应体）
//   const resp = await fetch('https://study.duyiedu.com/api/herolist');
//   const heroes = await resp.json(); // 等待响应体传输完成，并将所有的响应体转换为js对象

//   document.querySelector('.list').innerHTML = heroes.data
//     .map(
//       (h) => `<li>
//   <a
//     href="https://pvp.qq.com/web201605/herodetail/${h.ename}.shtml"
//     target="_blank"
//   >
//     <img
//       src="https://game.gtimg.cn/images/yxzj/img201606/heroimg/${h.ename}/${h.ename}.jpg"
//       alt=""
//     />
//     <span>${h.cname}</span>
//   </a>
// </li>`
//     )
//     .join('');
// }

// init();
async function init(){
  //当行和头全部到达客户端后，改promise完成（不会等待响应体），这里使用await关键字，不使用then
  const res = await fetch('https://study.duiedu.com/api/herolist',{
    method:'GET',
    headers:{

    },
    body:{

    }
  })
  // 所有IO均为异步，res得到的是个Response对象，可以拿到整个响应的所有信息
  //  const str = await res.text(); //等待响应体完成，转换成文本字符串
   const heroes = await res.json();//等待响应体完成，转换成js对象
  

}



