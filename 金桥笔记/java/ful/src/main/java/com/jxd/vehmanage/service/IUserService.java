package com.jxd.vehmanage.service;

import java.util.Map;

public interface IUserService {

    /**
     * 根据用户名查询用户及对应员工姓名
     * @param username 查询条件用户名
     * @return 返回map集合
     */
    Map<String,Object> getUser(String username);
}
