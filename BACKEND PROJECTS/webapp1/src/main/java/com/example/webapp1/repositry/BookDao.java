package com.example.webapp1.repositry;

import com.example.webapp1.Model.Book;

import java.util.List;

public interface BookDao {
    public abstract List<Book> GetAllBooks();
    public abstract void addBook(Book book);
}
