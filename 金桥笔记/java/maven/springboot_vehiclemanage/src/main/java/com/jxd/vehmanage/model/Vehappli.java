package com.jxd.vehmanage.model;

/**
 * @ClassName Vehappli
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/27
 * @Version 1.0
 */

public class Vehappli {
    private Integer appno;
    private Integer appid;
    private String appdate;
    private Integer appvehtypeno;
    private String exusetime;
    private String exreturntime;
    private String appreason;
    private String appvehnum;
    private Double appgomil;
    private String gotime;
    private Double appbackmil;
    private String backtime;
    private Double usemil;

    public Integer getAppno() {
        return appno;
    }

    public void setAppno(Integer appno) {
        this.appno = appno;
    }

    public Integer getAppid() {
        return appid;
    }

    public void setAppid(Integer appid) {
        this.appid = appid;
    }

    public String getAppdate() {
        return appdate;
    }

    public void setAppdate(String appdate) {
        this.appdate = appdate;
    }

    public Integer getAppvehtypeno() {
        return appvehtypeno;
    }

    public void setAppvehtypeno(Integer appvehtypeno) {
        this.appvehtypeno = appvehtypeno;
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

    public Double getAppgomil() {
        return appgomil;
    }

    public void setAppgomil(Double appgomil) {
        this.appgomil = appgomil;
    }

    public String getGotime() {
        return gotime;
    }

    public void setGotime(String gotime) {
        this.gotime = gotime;
    }

    public Double getAppbackmil() {
        return appbackmil;
    }

    public void setAppbackmil(Double appbackmil) {
        this.appbackmil = appbackmil;
    }

    public String getBacktime() {
        return backtime;
    }

    public void setBacktime(String backtime) {
        this.backtime = backtime;
    }

    public Double getUsemil() {
        return usemil;
    }

    public void setUsemil(Double usermil) {
        this.usemil = usermil;
    }

    public Vehappli() {
    }

    public Vehappli(Integer appno, Integer appid, String appdate, Integer appvehtypeno, String exusetime, String exreturntime, String appreason, String appvehnum, Double appgomil, String gotime, Double appbackmil, String backtime, Double usemil) {
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
        this.usemil = usemil;
    }
}
