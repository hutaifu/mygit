package com.jxd.bookmanger.model;

import org.springframework.stereotype.Component;

/**
 * @ClassName book
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/31
 * @Version 1.0
 */
@Component("voBook")
public class VoBook {
    private Integer bookno;
    private String booksname;
    private String eitor;
    private String puber;
    private String pubdate;
    private Integer booknum;
    private double bookpri;
    private String typename;
    private Integer typeno;

    public Integer getBookno() {
        return bookno;
    }

    public void setBookno(Integer bookno) {
        this.bookno = bookno;
    }

    public String getBooksname() {
        return booksname;
    }

    public void setBooksname(String booksname) {
        this.booksname = booksname;
    }

    public String getEitor() {
        return eitor;
    }

    public void setEitor(String eitor) {
        this.eitor = eitor;
    }

    public String getPuber() {
        return puber;
    }

    public void setPuber(String puber) {
        this.puber = puber;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public Integer getBooknum() {
        return booknum;
    }

    public void setBooknum(Integer booknum) {
        this.booknum = booknum;
    }

    public double getBookpri() {
        return bookpri;
    }

    public void setBookpri(double bookpri) {
        this.bookpri = bookpri;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public Integer getTypeno() {
        return typeno;
    }

    public void setTypeno(Integer typeno) {
        this.typeno = typeno;
    }

    public VoBook() {
    }

    public VoBook(Integer bookno, String booksname, String eitor, String puber, String pubdate, Integer booknum, double bookpri, String typename, Integer typeno) {
        this.bookno = bookno;
        this.booksname = booksname;
        this.eitor = eitor;
        this.puber = puber;
        this.pubdate = pubdate;
        this.booknum = booknum;
        this.bookpri = bookpri;
        this.typename = typename;
        this.typeno = typeno;
    }

    @Override
    public String toString() {
        return "VoBook{" +
                "bookno=" + bookno +
                ", booksname='" + booksname + '\'' +
                ", eitor='" + eitor + '\'' +
                ", puber='" + puber + '\'' +
                ", pubdate='" + pubdate + '\'' +
                ", booknum=" + booknum +
                ", bookpri=" + bookpri +
                ", typename='" + typename + '\'' +
                ", typeno=" + typeno +
                '}';
    }
}
