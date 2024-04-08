package com.jxd.emp.service.impl;

import com.jxd.emp.dao.IEmpDao;
import com.jxd.emp.model.Emp;
import com.jxd.emp.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName EmpServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/8
 * @Version 1.0
 */
/*
* @Service创建Service类实现对象
* <bean id = "empServiceImpl" class = "com.jxd.emp.service.EmpServiceImpl>
* */
@Service
public class EmpServiceImpl implements IEmpService {


    /*
    * 用于依赖注入的注解
    * <property name = "empDao" ref = "empDao">
    默认注入方式为byType，Spring容器会查找改类型的对象，类型匹配上就可以注入进来
    * @Repository 以经创建改类对象，然后注入
    * */
   /* @Autowired
    @Qualifier("empDaoImpl")*/
  /* @Resource(name = "empDaoImpl")*/
    @Autowired
    IEmpDao empDao;
    /**
     * @param emp
     * @return
     */
    @Override
    public boolean addEmp(Emp emp) {
        return empDao.addEmp(emp);
    }
    @Override
    public List<Emp> getAllEmp() {
        return empDao.getAllEmp();
    }
}
