package com.jxd.emp.dao;


import com.jxd.emp.model.VoBook;

import java.util.List;

public interface IBookMangerDao {
    /**
     * 查询多个图书
     * @param snakey 姓名关键字
     * @param typeno 书类型
     * @return 返回图书集合
     */
    List<VoBook> selectMore(String snakey, Integer typeno);


}
