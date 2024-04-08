package com.jxd.vehmanage.controller;

import com.jxd.vehmanage.dao.MenuMapper;
import com.jxd.vehmanage.service.IMenuService;
import com.jxd.vehmanage.util.FrontToInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName MenuController
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/29
 * @Version 1.0
 */
@RestController
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @RequestMapping("/getMenu")
    public Map<String,Object> getMenu(@RequestBody Map<String,String> map){
        Integer mno = Integer.parseInt(map.get("rol"));
        return menuService.getMenu(mno);
    }
}
