package com.jxd.test.service.impl;

import com.jxd.test.dao.IMessageDao;
import com.jxd.test.dao.impl.MessageDaoImpl;
import com.jxd.test.model.Message;
import com.jxd.test.service.IMessageBiz;
import com.jxd.test.util.GetTime;

import java.util.List;

/**
 * @ClassName MessageBizImpl
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/15
 * @Version 1.0
 */

public class MessageBizImpl implements IMessageBiz {
    IMessageDao messageDao = new MessageDaoImpl();

    /**
     * 查看所有留言
     */
    @Override
    public void shwomessage() {
        List<Message> list = messageDao.shwo();
        for (Message m: list) {
            System.out.println("留言人：" + m.getUserName());
            System.out.println("留言时间：" + m.getCreateTime());
            System.out.println("留言标题：" + m.getTitle());
            System.out.println("留言内容：" + m.getContents());
            System.out.println();
        }
    }

    /**
     * 增加留言
     *
     * @param name     姓名
     * @param title    标题
     * @param contents 内容
     */
    @Override
    public void addmessage(String name, String title, String contents) {
        Message message = new Message();
        message.setUserName(name);
        message.setTitle(title);
        message.setContents(contents);

        message.setCreateTime(GetTime.currentime());
        if (messageDao.insert(message)){
            System.out.println("留言成功！");
        }
    }
}
