import com.jxd.stu.dao.IStuDao;
import com.jxd.stu.model.Stu;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * @ClassName Test01
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/5
 * @Version 1.0
 */

public class Test01 {
    @Test
    public void test01() throws IOException {
        Reader reader = Resources.getResourceAsReader("config.xml");
        SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
        SqlSessionFactory sf = sfb.build(reader);
        SqlSession session = sf.openSession();
        IStuDao stuDao = session.getMapper(IStuDao.class);
        List<Stu> stus = stuDao.getAllStu();
        for (Stu stu : stus){
            System.out.println(stu);
        }
        session.close();



    }
}
