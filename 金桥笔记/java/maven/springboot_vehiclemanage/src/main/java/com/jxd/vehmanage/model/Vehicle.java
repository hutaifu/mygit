package com.jxd.vehmanage.model;

/**
 * @ClassName Vehicle
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/27
 * @Version 1.0
 */

public class Vehicle {
    private Integer vno;
    private Integer vtypeno;
    private String vnum;
    private double vcurmil;
    private String vprutime;
    private Integer vstateno;
    private Integer vsitnum;

    public Integer getVno() {
        return vno;
    }

    public void setVno(Integer vno) {
        this.vno = vno;
    }


    public String getVnum() {
        return vnum;
    }

    public void setVnum(String vnum) {
        this.vnum = vnum;
    }

    public double getVcurmil() {
        return vcurmil;
    }

    public void setVcurmil(double vcurmil) {
        this.vcurmil = vcurmil;
    }

    public String getVprutime() {
        return vprutime;
    }

    public void setVprutime(String vprutime) {
        this.vprutime = vprutime;
    }

    public Integer getVtypeno() {
        return vtypeno;
    }

    public void setVtypeno(Integer vtypeno) {
        this.vtypeno = vtypeno;
    }

    public Integer getVstateno() {
        return vstateno;
    }

    public void setVstateno(Integer vstateno) {
        this.vstateno = vstateno;
    }

    public Integer getVsitnum() {
        return vsitnum;
    }

    public void setVsitnum(Integer vsitnum) {
        this.vsitnum = vsitnum;
    }

    public Vehicle() {
    }

    public Vehicle(Integer vno, Integer vtypeno, String vnum, double vcurmil, String vprutime, Integer vstateno, Integer vsitnum) {
        this.vno = vno;
        this.vtypeno = vtypeno;
        this.vnum = vnum;
        this.vcurmil = vcurmil;
        this.vprutime = vprutime;
        this.vstateno = vstateno;
        this.vsitnum = vsitnum;
    }
}
