package com.jxd.emp.controller;

import com.jxd.emp.model.Dept;
import com.jxd.emp.model.Emp;
import com.jxd.emp.model.Users;
import com.jxd.emp.service.IDeptService;
import com.jxd.emp.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName EmpController
 * @Description TODO
 * @Author lixiaoru
 * @Date 2020/11/18
 * @Version 1.0
 */
@RestController
public class EmpController {

    @Autowired
    private IEmpService empService;

    @Autowired
    private IDeptService deptService;

    @RequestMapping("/login")
    public String login(@RequestBody Users users){
        if("admin".equals(users.getUname()) && "123".equals(users.getPwd())){
            return "success";
        }else{
            return "error";
        }
    }

    /**
     *
     * @param map 四个参数  limit  page  ename  deptno
     * @return  返回数据中包括 data:所有列表数据， count总条数
     */
    @RequestMapping("/list")
    public Map<String,Object> list(@RequestBody Map<String,String> map){
        return empService.getAllEmpList(map);
    }

    @RequestMapping("/mgrList")
    public List<Emp> mgrList(String empno){
        return empService.getMgrList(empno);
    }

    @RequestMapping("/deptList")
    public List<Dept> deptList(){
        return deptService.list();
    }

    @RequestMapping("/addEmp")
    public String addEmp(@RequestBody Emp emp){
        if(empService.save(emp)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/delbatch")
    public String delEmp(@RequestBody List<Integer> empnos){
        if(empService.removeByIds(empnos)){
            return "success";
        }else{
            return "error";
        }
    }

    @RequestMapping("/getOne/{empno}")
    public Emp getOne(@PathVariable("empno") int empno){
        return empService.getById(empno);
    }


    @RequestMapping("/updateEmp")
    public String updateEmp(@RequestBody Emp emp){
        if(empService.saveOrUpdate(emp)){
            return "success";
        }else{
            return "error";
        }
    }
}
