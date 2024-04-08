package com.jxd.bookmanger.service.impl;

import com.jxd.bookmanger.dao.IAdminDao;
import com.jxd.bookmanger.dao.impl.AdminDaoImpl;
import com.jxd.bookmanger.model.Admin;
import com.jxd.bookmanger.service.IAdminService;

/**
 * @ClassName AdminServiceImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/31
 * @Version 1.0
 */

public class AdminServiceImpl implements IAdminService {
    private IAdminDao adminDao = new AdminDaoImpl();
    /**
     * 注册管理员
     *
     * @param admin 要注册的管理员
     * @return 是否成功
     */
    @Override
    public boolean register(Admin admin) {
        return adminDao.addone(admin);
    }

    /**
     * 查询单个管理员
     *
     * @param adno 管理员编号
     * @return 要查询的管理员对象
     */
    @Override
    public Admin query(int adno) {
        return adminDao.selectone(adno);
    }
}
