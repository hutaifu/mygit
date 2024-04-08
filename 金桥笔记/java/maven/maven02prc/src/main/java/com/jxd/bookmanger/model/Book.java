package com.jxd.bookmanger.model;

import org.springframework.stereotype.Component;

/**
 * @ClassName Book
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/9/2
 * @Version 1.0
 */
@Component("book")
public class Book {
    private Integer bookno;
    private String booksname;
    private String eitor;
    private String puber;
    private String pubdate;
    private Integer booknum;
    private double bookpri;
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

    public Integer getTypeno() {
        return typeno;
    }

    public void setTypeno(Integer typeno) {
        this.typeno = typeno;
    }

    public Book() {
    }

    public Book(Integer bookno, String booksname, String eitor, String puber, String pubdate, Integer booknum, double bookpri, Integer typeno) {
        this.bookno = bookno;
        this.booksname = booksname;
        this.eitor = eitor;
        this.puber = puber;
        this.pubdate = pubdate;
        this.booknum = booknum;
        this.bookpri = bookpri;
        this.typeno = typeno;
    }

    public Book(String booksname, String eitor, String puber, String pubdate, Integer booknum, double bookpri, Integer typeno) {
        this.booksname = booksname;
        this.eitor = eitor;
        this.puber = puber;
        this.pubdate = pubdate;
        this.booknum = booknum;
        this.bookpri = bookpri;
        this.typeno = typeno;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookno=" + bookno +
                ", booksname='" + booksname + '\'' +
                ", eitor='" + eitor + '\'' +
                ", puber='" + puber + '\'' +
                ", pubdate='" + pubdate + '\'' +
                ", booknum=" + booknum +
                ", bookpri=" + bookpri +
                ", typeno=" + typeno +
                '}';
    }
}
