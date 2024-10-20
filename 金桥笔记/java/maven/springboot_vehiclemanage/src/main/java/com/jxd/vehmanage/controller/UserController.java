package com.jxd.vehmanage.controller;

import com.jxd.vehmanage.model.User;
import com.jxd.vehmanage.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/28
 * @Version 1.0
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public Map<String,Object> login(@RequestBody User user){
        Map<String,Object> map = userService.getUser(user.getUsername());
        if (map == null){
            Map<String,Object> map1 = new HashMap<>();
            map1.put("msg","noneuser");
            return map1;
        }
        if ((map.get("pwd").toString().equals(user.getPwd()))){
            map.put("msg","success");
        } else {
            map.put("msg","noneuser");
        }
        return map;
    }
}
