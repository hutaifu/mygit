package com.jxd.vehmanage.service;

import java.util.Map;

public interface IMenuService {

    /**
     * 得到菜单
     * @param mno 菜单编号
     * @return 返回集合
     */
    Map<String,Object> getMenu(int mno);
}
