package com.jxd.ch09.emp.Test01;

import com.jxd.ch09.emp.service.IEmpService;
import com.jxd.ch09.emp.service.impl.EmpServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/10
 * @Version 1.0
 */

public class Test01 {
    public static <MapL> void main(String[] args) {
        IEmpService empService = new EmpServiceImpl();
        List<Map<String,Object>> list = empService.selectEmpinfo(null);
        for (Map<String,Object> map:list){
            //循环一次，遍历一条数据
            System.out.println(map.get("ename") + "\t");
            System.out.println(map.get("dename"));



        }


    }
}
