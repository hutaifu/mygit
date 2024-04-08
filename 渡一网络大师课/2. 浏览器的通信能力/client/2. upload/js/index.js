const $ = document.querySelector.bind(document);
const doms = {
  img: $('.preview'),
  container: $('.upload'),
  select: $('.upload-select'),
  selectFile: $('.upload-select input'),
  progress: $('.upload-progress'),
  cancelBtn: $('.upload-progress button'),
  delBtn: $('.upload-result button'),
};

function showArea(areaName) {
  doms.container.className = `upload ${areaName}`;
}

function setProgress(value) {
  doms.progress.style.setProperty('--percent', value);
}


doms.selectFile.onchange = (e) =>{
    const file = e.target.files[0];
    showArea("progress");
    const reader = new FileReader();
    reader.onload = e=>{
      doms.img.src = e.target.result;
    }
    reader.readAsDataURL(file);//图片数据藏在url中，有点牛逼啊，img元素本省就支持dataUrl
    setProgress(0);

    //ajax文件上传
    const xhr = new XMLHttpRequest();
    xhr.open('POST','http://127.0.0.1:8080');
    xhr.upload.onprogress = (e) =>{
      setProgress(Math.floor((e.loaded / e.total) * 100));
    }
    xhr.onload = () =>{
      //响应完成
      showArea('result');

    };
    const formData = new FormData();//自动生成多文件类型请求体
    formData.append("avatar",file);
    xhr.send(formData);
}


//请求取消
// xhr.abort()



















// doms.selectFile.onchange = (e) => {
//   const file = e.target.files[0];
//   showArea('progress');
//   setProgress(0);
//   const reader = new FileReader(); // 创建文件读取器
//   reader.onload = (e) => {
//     // 读取完成后触发该事件
//     doms.img.src = e.target.result;
//   };
//   reader.readAsDataURL(file); // 读取文件
//   // ajax文件上传 XHR
//   const xhr = new XMLHttpRequest();
//   xhr.open('POST', 'http://myserver.com:9527/upload/single');
//   xhr.upload.onprogress = (e) => {
//     // 上传进度
//     setProgress(Math.floor((e.loaded / e.total) * 100));
//   };
//   xhr.onload = () => {
//     // 响应完成
//     showArea('result');
//   };
//   const formData = new FormData();
//   formData.append('avatar', file);
//   xhr.send(formData);
// };
