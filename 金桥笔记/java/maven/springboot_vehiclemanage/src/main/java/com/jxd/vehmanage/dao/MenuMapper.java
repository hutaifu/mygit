package com.jxd.vehmanage.dao;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface MenuMapper {

    /**
     * 查询导航菜单
     * @param mno 菜单编号
     * @return 返回map集合
     */
    Map<String,Object> selectMenu(@Param("mno") int mno);
}
