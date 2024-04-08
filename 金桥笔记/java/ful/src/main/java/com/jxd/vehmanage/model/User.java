package com.jxd.vehmanage.model;

/**
 * @ClassName User
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/27
 * @Version 1.0
 */

public class User {
    private int userid;
    private String username;
    private String pwd;
    private int rol;
    private int uempno;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public int getUempno() {
        return uempno;
    }

    public void setUempno(int uempno) {
        this.uempno = uempno;
    }

    public User() {
    }

    public User(int userid, String username, String pwd, int rol, int uempno) {
        this.userid = userid;
        this.username = username;
        this.pwd = pwd;
        this.rol = rol;
        this.uempno = uempno;
    }

}
