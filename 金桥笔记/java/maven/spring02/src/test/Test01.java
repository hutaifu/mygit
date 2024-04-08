import com.jxd.emp.dao.IEmpDao;
import com.jxd.emp.model.Emp;
import com.jxd.emp.service.IEmpService;
import com.jxd.emp.service.impl.EmpServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/8
 * @Version 1.0
 */

public class Test01 {
    @Test
    public void testEmp(){
        //1.配置文件
        String config = "spring.xml";
        //创建容器
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //3.问spring容器要对象
        Emp emp = (Emp)context.getBean("emp");
        System.out.println(emp);
    }
    @Test
    public void testDao(){
        String config = "spring.xml";
        //创建容器
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //3.问spring容器要对象
        IEmpDao empDao = (IEmpDao)context.getBean("empDaoImpl");
        System.out.println(empDao.addEmp(new Emp()));
    }

    @Test
    public void testService(){
        String config = "spring.xml";
        //创建容器
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //3.问spring容器要对象
        IEmpService empService =(EmpServiceImpl) context.getBean("empServiceImpl");
        System.out.println(empService.addEmp(new Emp()));


    }
}
