package com.jxd.bookmanger.model;

/**
 * @ClassName Book
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/2
 * @Version 1.0
 */

public class Book {
    private int bookno;
    private String booksname;
    private String eitor;
    private String puber;
    private String pubdate;
    private int booknum;
    private double bookpri;
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

    public int getTypeno() {
        return typeno;
    }

    public void setTypeno(int typeno) {
        this.typeno = typeno;
    }

    public Book() {
    }

    public Book(String booksname, String eitor, String puber, String pubdate, int booknum, double bookpri, int typeno) {
        this.booksname = booksname;
        this.eitor = eitor;
        this.puber = puber;
        this.pubdate = pubdate;
        this.booknum = booknum;
        this.bookpri = bookpri;
        this.typeno = typeno;
    }

    public Book(int bookno, String booksname, String eitor, String puber, String pubdate, int booknum, double bookpri, int typeno) {
        this.bookno = bookno;
        this.booksname = booksname;
        this.eitor = eitor;
        this.puber = puber;
        this.pubdate = pubdate;
        this.booknum = booknum;
        this.bookpri = bookpri;
        this.typeno = typeno;
    }
}
