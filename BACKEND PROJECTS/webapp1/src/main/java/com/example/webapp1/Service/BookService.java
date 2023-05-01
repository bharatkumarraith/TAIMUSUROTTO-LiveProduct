package com.example.webapp1.Service;

import com.example.webapp1.Model.Book;

import java.util.List;

public interface BookService {
    public abstract List<Book> GetAllBooks();
    public abstract void AddBook(Book book);
}
