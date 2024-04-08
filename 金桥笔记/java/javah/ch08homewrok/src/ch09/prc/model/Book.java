package ch09.prc.model;

/**
 * @ClassName Book
 * @Description TODO
 * @Author Hutaifu
 * @Date 2022/8/9
 * @Version 1.0
 */

public class Book {
    private int bookno;
    private String bookname;
    private double bookpric;
    private int bookremai;

    public int getBookno() {
        return bookno;
    }

    public void setBookno(int bookno) {
        this.bookno = bookno;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public double getBookpric() {
        return bookpric;
    }

    public void setBookpric(double bookpric) {
        this.bookpric = bookpric;
    }

    public int getBookremai() {
        return bookremai;
    }

    public void setBookremai(int bookremai) {
        this.bookremai = bookremai;
    }

    public Book() {
    }

    public Book(int bookno, String bookname, double bookpric, int bookremai) {
        this.bookno = bookno;
        this.bookname = bookname;
        this.bookpric = bookpric;
        this.bookremai = bookremai;
    }

    public Book(String bookname, double bookpric, int bookremai) {
        this.bookname = bookname;
        this.bookpric = bookpric;
        this.bookremai = bookremai;
    }
}
