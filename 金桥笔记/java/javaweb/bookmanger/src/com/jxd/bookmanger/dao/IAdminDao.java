package com.jxd.bookmanger.dao;

import com.jxd.bookmanger.model.Admin;

public interface IAdminDao {

    /**
     * 增加管理员
     * @param admin 要增加的管理员对象
     * @return 是否成功
     */
    boolean addone(Admin admin);

    /**
     * 查询单个图书管理员对象
     * @param adno 要查询对象的编号
     * @return 查询的对象
     */
    Admin selectone(int adno);
}
