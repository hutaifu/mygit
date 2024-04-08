package com.jxd.emp.service;


import com.jxd.emp.model.VoBook;

import java.util.List;

public interface IBookService {

    /**
     * 查询部分图书
     * @param key 姓名关键字
     * @param type 图书类型
     * @return 图书集合
     */
    List<VoBook> querymore(String key, Integer type);


}
