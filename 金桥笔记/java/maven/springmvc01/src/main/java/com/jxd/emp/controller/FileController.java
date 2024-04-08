package com.jxd.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @ClassName FileController
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/13
 * @Version 1.0
 */
@Controller
public class FileController {
    @RequestMapping("/upload")
    public String toUpload(){
        return "upload";
    }

    public String uploadFile (@RequestParam("upload") MultipartFile multipartFile, HttpServletRequest request){
        //创建一个file目录用于存放上传的文件
        String savePath = request.getServletContext().getRealPath("files");
        File file = new File(savePath);
        //如果files不存在，或者不是目录，我们创建它
        if (!file.exists() || !file.isDirectory()){
            file.mkdir();
        }
        //获取原文件名
        String oldName = multipartFile.getOriginalFilename();
        //对源文件名进行处理
        String newName = UUID.randomUUID() + oldName.substring(oldName.lastIndexOf("."));
        //根据保存路径和新名字生成一个文件对象
        File saveFile = new File(savePath,newName);
        try {
            multipartFile.transferTo(saveFile);
            //将springMvc接收的文件对象转换为普通的文件对象
            //转换的过程即保存的过程
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "files/" + newName;
        //返回文件保存路径及文件名
    }
}
