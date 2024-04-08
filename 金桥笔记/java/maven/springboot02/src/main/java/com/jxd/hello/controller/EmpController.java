package com.jxd.hello.controller;

import com.jxd.hello.model.Emp;
import com.jxd.hello.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName EmpController
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/15
 * @Version 1.0
 */
@Controller
public class EmpController {
    @Autowired
    private IEmpService empService;


    @RequestMapping("/getAllEmp")
    @ResponseBody
    public List<Emp> getAll(){
        return empService.getAll();
    }
}
