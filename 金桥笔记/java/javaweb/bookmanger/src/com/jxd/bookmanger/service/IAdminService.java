package com.jxd.bookmanger.service;

import com.jxd.bookmanger.model.Admin;

public interface IAdminService {

    /**
     * 注册管理员
     * @param admin 要注册的管理员
     * @return 是否成功
     */
    boolean register(Admin admin);

    /**
     * 查询单个管理员
     * @param adno 管理员编号
     * @return 要查询的管理员对象
     */
    Admin query(int adno);
}
