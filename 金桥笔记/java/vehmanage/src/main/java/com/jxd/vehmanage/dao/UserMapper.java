package com.jxd.vehmanage.dao;

import com.jxd.vehmanage.model.User;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.URL;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    /**
     * 根据用户名查询用户及对应员工姓名
     * @param username 用户名
     * @return 得到的用户对象
     */
    Map<String,Object> selectUser(@Param("username") String username);
}
