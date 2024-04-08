import com.jxd.emp.dao.IDeptDao;
import com.jxd.emp.dao.IEmpDao;
import com.jxd.emp.model.Dept;
import com.jxd.emp.model.Emp;
import com.jxd.emp.util.MybatisUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/5
 * @Version 1.0
 */

public class Test01 {
    @Test
    public void testGetAllEmp() throws IOException {
        //读取配置文件
        Reader reader = Resources.getResourceAsReader("config.xml");
        //创建
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        //创建对象
        SqlSessionFactory sf = sfb.build(reader);//根据配置文件加载数据
        //获得一个sql对象
        SqlSession session = sf.openSession();
        //获取dao层实现类对象
        IEmpDao empDao = session.getMapper(IEmpDao.class);
        //执行方法，获取结果
        List<Emp> emps = empDao.getAllEmp();
        //遍历结果
        for (Emp emp : emps){
            System.out.println(emp);
        }
        //关闭会话
        session.close();
    }
    @Test
    public void testAddEmp(){
        SqlSession session = MybatisUtil.openSession();
        IEmpDao empDao = session.getMapper(IEmpDao.class);
        //新增员工
        int num = empDao.addEmp(new Emp(null,"张三","清洁工","2020-1-1"));
        if (num > 0){
            System.out.println("新增成功");
        }else {
            System.out.println("新增失败");
        }
        session.commit();
        session.close();
    }
    @Test
    public void testUpdateEmp(){
        SqlSession session = MybatisUtil.openSession();
        IEmpDao empDao = session.getMapper(IEmpDao.class);
        boolean flag = empDao.updateEmp(new Emp(1,"李四","扫地","2010-09-09"));
        System.out.println(flag);
        session.commit();
        session.close();
    }

    public void testGetEmpnByNo(){
        SqlSession session = MybatisUtil.openSession();
        IEmpDao empDao = session.getMapper(IEmpDao.class);

    }
@Test
    public void testGetEmpBy(){
        SqlSession session = MybatisUtil.openSession();
        IEmpDao empDao = session.getMapper(IEmpDao.class);
//        Emp emp = empDao.getEmpByNameAndJob("李四","扫地");
//        System.out.println(emp);
        session.close();
    }

    @Test
    public void testGetEmpBy2(){
        SqlSession session = MybatisUtil.openSession();
        IEmpDao empDao = session.getMapper(IEmpDao.class);
        Map<String,String> map = new HashMap();
        map.put("ename","李四");
        map.put("job","扫地");
        Emp emp = empDao.getEmpByNameAndJob2(map);
        System.out.println(emp);
        session.close();
    }
    @Test
    public void testGetJObByEanme(){
        SqlSession session = MybatisUtil.openSession();
        IEmpDao empDao = session.getMapper(IEmpDao.class);
        String job = empDao.getJobByEname("四");
        System.out.println(job);
        session.close();
    }

    @Test
    public void testGetEmpByPage(){
        int pageIndex = 1;//当前页
        int pageSize = 5;//梅页条数
        int count = (pageIndex - 1) * pageSize;
        SqlSession session = MybatisUtil.openSession();
        IEmpDao empDao = session.getMapper(IEmpDao.class);
        List<Emp> list = empDao.getEmpByPage(count,pageSize);
        for (Emp emp :list){
            System.out.println(emp);
        }
        session.close();

    }
    @Test
    public void testGetEmsd(){
        SqlSession session = MybatisUtil.openSession();
        IEmpDao empDao = session.getMapper(IEmpDao.class);
        List<Emp> list = empDao.getEmpByNameAndJob("李","地");
        for (Emp emp :list){
            System.out.println(emp);
        }
        session.close();
    }

    @Test
    public void testDeletBatch(){
        SqlSession session = MybatisUtil.openSession();
        IEmpDao empDao = session.getMapper(IEmpDao.class);
        boolean isSucc = empDao.deleteBatch( new int[]{1,2,3});
        if (isSucc){
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        session.commit();
        session.close();
    }
    @Test
    public void testGetEmpAndDept(){
        SqlSession session = MybatisUtil.openSession();
        IEmpDao empDao = session.getMapper(IEmpDao.class);
        //每一条记录都被封装成一个map对象，查询结果是一个map集合
        List<Map<String,Object>> maps = empDao.getEmpAndDept();
        for (Map<String,Object> map : maps){
            System.out.println(map);
            String name = (String)map.get("ename");
        }
        session.commit();
    }

    @Test
    public void testGetAllDept(){
        SqlSession session = MybatisUtil.openSession();
        IDeptDao deptDao = session.getMapper(IDeptDao.class);
        List<Dept> depts = deptDao.getAllDept();
        for (Dept dept:depts){
            System.out.println(dept);
        }
        session.close();


    }
    @Test
    public void testGetDeptByEno(){
        SqlSession session = MybatisUtil.openSession();
        IDeptDao deptDao = session.getMapper(IDeptDao.class);
        Dept dept = deptDao.getDeptByDno(1);
        List<Emp> emps = dept.getEmps();
        System.out.println("部门编号" + dept.getDeptno() );
        System.out.println("部门名称" + dept.getDname() );
        System.out.println("人员");
        for (Emp emp : emps){
            System.out.println(emp);
        }
        session.close();
    }

    @Test
    public void testAddBatchEmp(){
        SqlSession session = MybatisUtil.openSession();
        IEmpDao empDao = session.getMapper(IEmpDao.class);
        List<Emp> emps = new ArrayList<>();
        emps.add(new Emp(null,"小李","研发","2021-1-1",2));
        emps.add(new Emp(null,"小红","测试","2021-1-1",1));
        emps.add(new Emp(null,"小黄","市场","2021-1-1",3));
        boolean isSucc = empDao.addBatchEmp(emps);
        session.commit();
        if (isSucc){
            System.out.println("新增成功");
        } else {
            System.out.println("新增失败");
        }
        session.close();
    }
    @Test
    public void testUpdateBatchEmp(){
        SqlSession session = MybatisUtil.openSession();
        IEmpDao empDao = session.getMapper(IEmpDao.class);
        List<Emp> emps = new ArrayList<>();
        emps.add(new Emp(4,"小李","研发","2021-1-1",2));
        emps.add(new Emp(5,"小红","测试","2021-1-1",1));
        emps.add(new Emp(6,"小黄","市场","2021-1-1",3));
        boolean isSucc = empDao.updateBatchEmp(emps);
        session.commit();
        if (isSucc){
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
        session.close();
    }
}
