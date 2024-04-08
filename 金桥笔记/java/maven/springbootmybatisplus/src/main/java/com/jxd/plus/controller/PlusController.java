package com.jxd.plus.controller;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jxd.plus.model.Emp;
import com.jxd.plus.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.Map;

/**
 * @ClassName PlusController
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/16
 * @Version 1.0
 */


/*
* 标识当前controller中所有方法都以响应流方式输出到页面
* 默认在页面前加@ResponseBody
* */
@RestController
public class PlusController {
    @Autowired
    private IEmpService empService;

    @RequestMapping("/getEmp")
    public List<Emp> getEmp(){
        //创建条件构造器对象
        AbstractWrapper querWrapper = new QueryWrapper();
//        querWrapper.eq("ename","小刚");
        querWrapper.like("ename","刚");
        return empService.list(querWrapper);


    }

   /* @RequestMapping("/getEmpWithDept")
    public List<Map<String,Object>> getEmpWithDept(){
        return empService.getEmpWithDept();
    }*/
}
