import com.jxd.vehmanage.PlusApplication;
import com.jxd.vehmanage.dao.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * @ClassName TestEmp
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/16
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PlusApplication.class)
public class TestEmp {

    @Autowired
    UserMapper userMapper;

    @Test
    public void test01(){
    }
    @Test
    public void get(){
        Map map = userMapper.selectUser("123");
        System.out.println(map);
    }
}
