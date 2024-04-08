package com.jxd.bookmanger.dao;

import com.jxd.bookmanger.model.VoBook;

import java.util.List;

public interface IBookTypeDao {

    /**
     * 查询全部图书类别
     * @return 类别集合
     */
    List<VoBook> selecttype();
}
