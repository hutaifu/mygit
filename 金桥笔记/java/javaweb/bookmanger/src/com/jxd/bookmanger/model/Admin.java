package com.jxd.bookmanger.model;

/**
 * @ClassName Admin
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/31
 * @Version 1.0
 */

public class Admin {
    private int adno;
    private String aduser;
    private String adpwd;
    private int adright;

    public int getAdno() {
        return adno;
    }

    public void setAdno(int adno) {
        this.adno = adno;
    }

    public String getAduser() {
        return aduser;
    }

    public void setAduser(String aduser) {
        this.aduser = aduser;
    }

    public String getAdpwd() {
        return adpwd;
    }

    public void setAdpwd(String adpwd) {
        this.adpwd = adpwd;
    }

    public int getAdright() {
        return adright;
    }

    public void setAdright(int adright) {
        this.adright = adright;
    }

    public Admin() {
    }

    public Admin(int adno, String aduser, String adpwd, int adright) {
        this.adno = adno;
        this.aduser = aduser;
        this.adpwd = adpwd;
        this.adright = adright;
    }

    public Admin(String aduser, String adpwd, int adright) {
        this.aduser = aduser;
        this.adpwd = adpwd;
        this.adright = adright;
    }
}
