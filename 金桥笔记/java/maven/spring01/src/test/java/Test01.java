import com.jxd.emp.model.Emp;
import com.jxd.emp.model.Hello;
import com.jxd.emp.service.IEmpService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/8
 * @Version 1.0
 */

public class Test01 {
    @Test
    public void testHello(){
        //Tomcat 不光是容器，还是服务器，服务器一启动，就会读配置文件，
        //Sring只是容器，要手动读配置文件
//        1.创建Sring容器
        String config = "spring.xml";//resources目录文件会直接出现在类路径下
        //创建spring容器是，加载配置文件==会根据bean的配置信息创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //2.找spring容器要一个对象
        Hello hello = (Hello)context.getBean("hello");
        //3.调用对象的方法进行测试
        hello.show();

        Date date = (Date) context.getBean("date");
        System.out.println(date);
    }
    @Test
    public void testEmp(){
        String config = "spring.xml";//resources目录文件会直接出现在类路径下
        //创建spring容器是，加载配置文件==会根据bean的配置信息创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //2.找spring容器要一个对象
        Emp emp = (Emp) context.getBean("emp");
        System.out.println(emp);
    }

    @Test
    public void testEmp2(){
        String config = "spring.xml";//resources目录文件会直接出现在类路径下
        //创建spring容器是，加载配置文件==会根据bean的配置信息创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //2.找spring容器要一个对象
        Emp emp = (Emp) context.getBean("emp2");
        System.out.println(emp);
    }
    @Test
    public void testAddEmp(){
        String config = "spring.xml";//resources目录文件会直接出现在类路径下
        //创建spring容器是，加载配置文件==会根据bean的配置信息创建对象
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        IEmpService empService = (IEmpService) context.getBean("empService");
        boolean isSucee = empService.addEmp(new Emp());
        System.out.println(isSucee
        );

    }


}
