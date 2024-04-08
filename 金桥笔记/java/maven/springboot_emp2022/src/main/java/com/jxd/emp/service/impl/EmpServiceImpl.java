package com.jxd.emp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jxd.emp.dao.EmpMapper;
import com.jxd.emp.model.Emp;
import com.jxd.emp.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName EmpServiceImpl
 * @Description TODO
 * @Author lixiaoru
 * @Date 2020/11/18
 * @Version 1.0
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public Map<String, Object> getAllEmpList(Map<String,String> queryMap) {
        String page = queryMap.get("page");
        String limit = queryMap.get("limit");
        String ename = queryMap.get("ename");
        String deptnos = queryMap.get("deptno");
        int deptno = 0;
        if(!"".equals(deptnos)){
            deptno = Integer.parseInt(deptnos);
        }

        Map<String, Object> map = new HashMap(4);
        if(page != null && limit != null){
            IPage<Emp> pages = new Page(Integer.parseInt(page),Integer.parseInt(limit));
            IPage<Map<String,Object>> pageResult = empMapper.getAllEmpList(pages,ename,deptno);
            map.put("count",pageResult.getTotal());
            map.put("data",pageResult.getRecords());
            map.put("code",0);
            return map;
        }else{
            map.put("data", (Object)null);
            map.put("code", "500");
            map.put("msg", "参数不符");
            map.put("count", (Object)null);
            return map;
        }

    }

    @Override
    public List<Emp> getMgrList(String empno) {
        Integer empnos = empno == null ? null : Integer.valueOf(empno);
        return empMapper.getMgrList(empnos);
    }
}
