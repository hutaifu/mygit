package com.jxd.bookmanger.model;

/**
 * @ClassName book
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/31
 * @Version 1.0
 */

public class VoBook {
    private int bookno;
    private String booksname;
    private String eitor;
    private String puber;
    private String pubdate;
    private int booknum;
    private double bookpri;
    private String booktype;
    private int typeno;

    public int getBookno() {
        return bookno;
    }

    public void setBookno(int bookno) {
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

    public int getBooknum() {
        return booknum;
    }

    public void setBooknum(int booknum) {
        this.booknum = booknum;
    }

    public double getBookpri() {
        return bookpri;
    }

    public void setBookpri(double bookpri) {
        this.bookpri = bookpri;
    }

    public String getBooktype() {
        return booktype;
    }

    public void setBooktype(String booktype) {
        this.booktype = booktype;
    }

    public int getTypeno() {
        return typeno;
    }

    public void setTypeno(int typeno) {
        this.typeno = typeno;
    }

    public VoBook() {
    }

    public VoBook(int bookno, String booksname, String eitor, String puber, String pubdate, int booknum, double bookpri, String booktype) {
        this.bookno = bookno;
        this.booksname = booksname;
        this.eitor = eitor;
        this.puber = puber;
        this.pubdate = pubdate;
        this.booknum = booknum;
        this.bookpri = bookpri;
        this.booktype = booktype;
    }

    public VoBook(String booksname, String eitor, String puber, String pubdate, int booknum, double bookpri, String booktype) {
        this.booksname = booksname;
        this.eitor = eitor;
        this.puber = puber;
        this.pubdate = pubdate;
        this.booknum = booknum;
        this.bookpri = bookpri;
        this.booktype = booktype;
    }

    public VoBook(int bookno, String booksname, String eitor, String puber, String pubdate, int booknum, double bookpri, String booktype, int typeno) {
        this.bookno = bookno;
        this.booksname = booksname;
        this.eitor = eitor;
        this.puber = puber;
        this.pubdate = pubdate;
        this.booknum = booknum;
        this.bookpri = bookpri;
        this.booktype = booktype;
        this.typeno = typeno;
    }
}
