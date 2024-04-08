
import com.jxd.emp.model.Emp;
import com.jxd.emp.service.IEmpService;
import com.jxd.emp.service.impl.EmpServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/9
 * @Version 1.0
 */

public class Test01 {
    @Test
    public void testGetAll(){
        String config = "spring-mybatis.xml";
        //创建容器
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //3.问spring容器要对象
        IEmpService empService = (IEmpService)context.getBean("empServiceImpl");
        List<Emp> list = empService.getAllEmp();


    }



}
