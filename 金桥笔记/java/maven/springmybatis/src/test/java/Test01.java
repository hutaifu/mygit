

import com.jxd.emp.dao.IEmpDao;
import com.jxd.emp.model.Emp;
import com.jxd.emp.model.VoBook;
import com.jxd.emp.service.IBookService;
import com.jxd.emp.service.IEmpService;
import com.jxd.emp.service.impl.BookServiceImpl;
import com.jxd.emp.until.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @ClassName java.Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/8
 * @Version 1.0
 */

public class Test01 {

    @Test
    public void testAddEmp(){
        Emp emp = new Emp(null,"小刚","经理","2014-10-08");
        //1.配置文件
        String config = "spring-mybatis.xml";
        //创建容器
        ApplicationContext context = new ClassPathXmlApplicationContext(config);
        //3.问spring容器要对象
        IEmpService empService = (IEmpService)context.getBean("empServiceImpl");
        boolean isSucess = empService.addEmp(emp);
        if (isSucess){
            System.out.println("插入成功");
        }else {
            System.out.println("插入失败");
        }

    }
    @Test
    public void testget(){
        IBookService bookService = new BookServiceImpl();
        List<VoBook> list = bookService.querymore(null,null);

    }
}
