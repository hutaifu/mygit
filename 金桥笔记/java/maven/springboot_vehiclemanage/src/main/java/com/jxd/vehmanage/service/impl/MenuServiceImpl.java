package com.jxd.vehmanage.service.impl;

import com.jxd.vehmanage.dao.MenuMapper;
import com.jxd.vehmanage.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @ClassName MenuServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/29
 * @Version 1.0
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * 得到菜单
     *
     * @param mno 菜单编号
     * @return 返回集合
     */
    @Override
    public Map<String, Object> getMenu(int mno) {
        return menuMapper.selectMenu(mno);
    }
}
