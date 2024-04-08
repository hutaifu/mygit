import com.jxd.hello.HelloApplication;
import com.jxd.hello.dao.EmpMapper;
import com.jxd.hello.model.Emp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @ClassName TestAplication
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/16
 * @Version 1.0
 */
//这两个注解作用时让spring容易创建出来，并初始化所有组件，放到到容器中
@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloApplication.class)
public class TestAplication {
    @Autowired
    private EmpMapper empMapper;


//    测试方法要求无参无返回值，无静态
    @Test
    public void getEmp(){
        List<Emp> list = empMapper.selectAll();
        System.out.println(list.get(0).getEname());

    }
}
