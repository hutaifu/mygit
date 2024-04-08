package com.jxd.student.controller;

import com.jxd.student.model.Cls;
import com.jxd.student.model.Student;
import com.jxd.student.service.IClsService;
import com.jxd.student.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName StruController
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/13
 * @Version 1.0
 */
@Controller
@SessionAttributes({"uname"})//springmvc会将视图模型中的unameset到session对象中
public class StuController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClsService clsService;

    @RequestMapping("/tologin")
    public String lgon(){
        //跳转到登录页面
        return "layui.login";
    }

    @RequestMapping("/Login")
    public String login(String uname, @RequestParam("pwd") String password, Model model){
        if ("admin".equals(uname) && "123".equals(password)){
            //将用户名存储到session中
            model.addAttribute("uname",uname);
            return "StuList";
        }else {
            //将数据放到视图模型中，springmvc会帮我们将数据set到request对象中
            model.addAttribute("msg","用户名或者密码错误");
            return "layui.login";
        }


    }
    @RequestMapping("/GetByPage")
    @ResponseBody
    public Map<String,Object> getByPage(String sname,int page,int limit){
        Map<String,Object> result = new HashMap<>();
        List<Map<String,Object>> list = studentService.getStuByPage(sname,page,limit);
        result.put("code",0);
        result.put("msg","");
        result.put("data",list);
        result.put("count",10);
        //springmvc会自动将map集合解析为json字符串，
        return result;
    }
    @RequestMapping("/toAddStu")
    public String toaddstu(){
        return "addStudent";
    }
    @RequestMapping("/GetCls")
    @ResponseBody
    public List<Cls> getCls(){
        List<Cls> list = clsService.getClsList();
        return list;
    }
    @RequestMapping("AddStu")
    @ResponseBody
    public String addStru(Student student){
        //前台的input的name要和对象的属性名一致，空字符串不能转int
        //调用service层，调用dao层，执行insert操作，获取返回值
        return "success";
    }

 /*   @RequestMapping("/GetStuBySno")
    public String getStruBySno (int sno,Model model){
        //sno和前台路径上拼接的参数对应

        //调用service获取学生信息

        //将获取的学生信息放到model对象中
    }*/
}
