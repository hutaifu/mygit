package com.jxd.bookmanger.service;

import com.jxd.bookmanger.model.VoBook;

import java.util.List;

public interface IBooktypeService {

    /**
     * 得到所有图书类别
     * @return 类别集合
     */
    List<VoBook> getType();
}
