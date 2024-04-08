package com.jxd.test.model;

/**
 * @ClassName Message
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/15
 * @Version 1.0
 */

public class Message {
    private int id;
    private String userName;
    private String title;
    private String contents;
    private String createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Message() {
    }

    public Message(int id, String userName, String title, String contents, String createTime) {
        this.id = id;
        this.userName = userName;
        this.title = title;
        this.contents = contents;
        this.createTime = createTime;
    }
}
