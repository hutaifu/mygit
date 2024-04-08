import ch.qos.logback.core.LogbackException;
import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jxd.plus.PlusApplication;
import com.jxd.plus.dao.UserMapper;
import com.jxd.plus.model.Emp;
import com.jxd.plus.service.IEmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
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
    IEmpService empService;

    @Autowired
    UserMapper userMapper;

    @Test
    public void test01(){
        //多个条件的构造
        AbstractWrapper queryWrapper = new QueryWrapper();
        //where ename like '张' or job = 'clerk'
        queryWrapper.eq("ename","刚");
        queryWrapper.or();
        queryWrapper.eq("job","经理");

//        queryWrapper.in("ename",)
        queryWrapper.orderByAsc("deptno");

        List<Emp> list = empService.list(queryWrapper);
        System.out.println(list.get(0).getEname());

    }

    @Test
    public void testPage(){
        //利用page和limit构造page对象
        IPage<Map<String,Object>> page = new Page<>(1,5);
        //执行分页查询，返回page对象
        IPage<Map<String, Object>> pageRsult = empService.getEmpWithDept(page);
        List<Map<String,Object>> list = pageRsult.getRecords();

        long count = pageRsult.getTotal();

    }
    @Test
    public void get(){
        Map map = userMapper.selectUser("123");
        System.out.println(map);
    }
}
