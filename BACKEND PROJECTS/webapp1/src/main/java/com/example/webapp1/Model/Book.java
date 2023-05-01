package com.example.webapp1.Model;

public class Book {
    private String bookName;
    private String subject;
    private String Author;
    private int price;

    public Book(String bookName, String subject, String author, int price) {
        this.bookName = bookName;
        this.subject = subject;
        Author = author;
        this.price = price;
    }

    public Book() {
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", subject='" + subject + '\'' +
                ", Author='" + Author + '\'' +
                ", price=" + price +
                '}';
    }
}
