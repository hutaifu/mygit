package com.jxd.emp.until;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtil {

    //定义SqlSession工厂
    public static SqlSessionFactory sf = null;

    //定义一个静态代码块，创建sqlsession工厂
    //静态代码块会随着虚拟机加载类的时候被加载执行，而且只执行一次
    //随着应用关闭，被销毁
    static {
        Reader reader = null;
        try {
            //加载主配置文件
            reader = Resources.getResourceAsReader("config.xml");
            //利用主配置文件生成一个sqlsession工厂
            sf = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取sqlsession
     * @return
     */
    public static SqlSession openSession(){
		SqlSession sqlSession = null;
		if(sf != null) {
			sqlSession = sf.openSession();//非自动提交事务
		}
        return sqlSession;
    }
}
