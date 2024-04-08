package com.jxd.plus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyBatisPlus
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/16
 * @Version 1.0
 */
//利用当前这个类创建一个分页对象
@Configuration
public class MyBatisPlusConfig {
    public MybatisPlusInterceptor getMybtatisPlusInterceptor(){
        //创建插件对象，retrun到spring容器中
        //插件集合对象
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        //创建分页插件,并指定要适配的数据库
        PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.MYSQL);
        //将分页插件放到插件集合中
        mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);
        //return
        return mybatisPlusInterceptor;
    }

}
