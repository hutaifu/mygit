package com.jxd.vehmanage.model;

/**
 * @ClassName Vehappli
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/27
 * @Version 1.0
 */

public class Vehappli {
    private int appno;
    private int appid;
    private String appdate;
    private int appvehtypeno;
    private String exusetime;
    private String exreturntime;
    private String appreason;
    private String appvehnum;
    private double appgomil;
    private String gotime;
    private double appbackmil;
    private String backtime;
    private double usermil;

    public int getAppno() {
        return appno;
    }

    public void setAppno(int appno) {
        this.appno = appno;
    }

    public int getAppid() {
        return appid;
    }

    public void setAppid(int appid) {
        this.appid = appid;
    }

    public String getAppdate() {
        return appdate;
    }

    public void setAppdate(String appdate) {
        this.appdate = appdate;
    }

    public int getAppvehtype() {
        return appvehtypeno;
    }

    public void setAppvehtype(int appvehtype) {
        this.appvehtypeno = appvehtype;
    }

    public String getExusetime() {
        return exusetime;
    }

    public void setExusetime(String exusetime) {
        this.exusetime = exusetime;
    }

    public String getExreturntime() {
        return exreturntime;
    }

    public void setExreturntime(String exreturntime) {
        this.exreturntime = exreturntime;
    }

    public String getAppreason() {
        return appreason;
    }

    public void setAppreason(String appreason) {
        this.appreason = appreason;
    }

    public String getAppvehnum() {
        return appvehnum;
    }

    public void setAppvehnum(String appvehnum) {
        this.appvehnum = appvehnum;
    }

    public double getAppgomil() {
        return appgomil;
    }

    public void setAppgomil(double appgomil) {
        this.appgomil = appgomil;
    }

    public String getGotime() {
        return gotime;
    }

    public void setGotime(String gotime) {
        this.gotime = gotime;
    }

    public double getAppbackmil() {
        return appbackmil;
    }

    public void setAppbackmil(double appbackmil) {
        this.appbackmil = appbackmil;
    }

    public String getBacktime() {
        return backtime;
    }

    public void setBacktime(String backtime) {
        this.backtime = backtime;
    }

    public double getUsermil() {
        return usermil;
    }

    public void setUsermil(double usermil) {
        this.usermil = usermil;
    }

    public Vehappli() {
    }

    public Vehappli(int appno, int appid, String appdate, int appvehtypeno, String exusetime, String exreturntime, String appreason, String appvehnum, double appgomil, String gotime, double appbackmil, String backtime, double usermil) {
        this.appno = appno;
        this.appid = appid;
        this.appdate = appdate;
        this.appvehtypeno = appvehtypeno;
        this.exusetime = exusetime;
        this.exreturntime = exreturntime;
        this.appreason = appreason;
        this.appvehnum = appvehnum;
        this.appgomil = appgomil;
        this.gotime = gotime;
        this.appbackmil = appbackmil;
        this.backtime = backtime;
        this.usermil = usermil;
    }
}
