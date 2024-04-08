package com.jxd.vehmanage.service.impl;

import com.jxd.vehmanage.dao.UserMapper;
import com.jxd.vehmanage.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/27
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 根据用户名查询用户及对应员工姓名
     *
     * @param username 查询条件用户名
     * @return 返回map集合
     */
    @Override
    public Map<String, Object> getUser(String username) {
        return userMapper.selectUser(username);
    }
}
