

const xhr = new XMLHttpRequest();
xhr.open('POST','http://myserver.com:9527/upload/single');
xhr.upload.onprogress = (e) =>{
    console.log(e);

}
xhr.onload(()=>{

//下载完成
})

const formData = new FormData();
formData.append("avatar",file)
xhr.send(formData)