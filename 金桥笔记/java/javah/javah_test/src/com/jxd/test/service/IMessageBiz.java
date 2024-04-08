package com.jxd.test.service;

public interface IMessageBiz {
    /**
     * 查看所有留言
     */
    void shwomessage();

    /**
     * 增加留言
     * @param name 姓名
     * @param title 标题
     * @param contents 内容
      */
    void addmessage(String name,String title,String contents);
}
