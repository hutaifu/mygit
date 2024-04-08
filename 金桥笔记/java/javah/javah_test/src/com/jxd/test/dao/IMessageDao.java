package com.jxd.test.dao;

import com.jxd.test.model.Message;

import java.util.List;

public interface IMessageDao {
    /**
     * 显示所有留言
     * @return 留言集合
     */
    List<Message> shwo();

    /**
     * 添加留言
     * @param message 添加的留言信息
     * @return 是否成功
     */
    boolean insert(Message message);
}
