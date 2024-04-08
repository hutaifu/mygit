package com.jxd.vehmanage.model;

/**
 * @ClassName Vehicle
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/27
 * @Version 1.0
 */

public class Vehicle {
    private int vno;
    private int vtypeno;
    private String vnum;
    private double vcurmil;
    private String vprutime;
    private int vstateno;
    private int vsitnum;

    public int getVno() {
        return vno;
    }

    public void setVno(int vno) {
        this.vno = vno;
    }

    public int getVtype() {
        return vtypeno;
    }

    public void setVtype(int vtype) {
        this.vtypeno = vtype;
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

    public int getVstate() {
        return vstateno;
    }

    public void setVstate(int vstate) {
        this.vstateno = vstate;
    }

    public int getVsitnum() {
        return vsitnum;
    }

    public void setVsitnum(int vsitnum) {
        this.vsitnum = vsitnum;
    }

    public Vehicle() {
    }

    public Vehicle(int vno, int vtype, String vnum, double vcurmil, String vprutime, int vstate, int vsitnum) {
        this.vno = vno;
        this.vtypeno = vtype;
        this.vnum = vnum;
        this.vcurmil = vcurmil;
        this.vprutime = vprutime;
        this.vstateno = vstate;
        this.vsitnum = vsitnum;
    }
}
