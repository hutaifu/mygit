package com.jxd.emp.controller;

import com.jxd.emp.model.Emp;
import com.jxd.emp.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EmpController
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/13
 * @Version 1.0
 */

@Controller
public class EmpController {
    @Autowired
    IEmpService empService;

    @RequestMapping("/getAllEmp")
    @ResponseBody
    public Map<String, Object> getAllEmp(){
        List<Emp> list = empService.getAllEmp();
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code",0); result.put("msg","");
        result.put("count",list.size());
        result.put("data",list);
        return result;
    }


}

