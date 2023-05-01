package com.example.webapp1.Service;

import com.example.webapp1.Model.Book;
import com.example.webapp1.repositry.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookServiceImpl implements BookService{
    @Autowired
 private BookDao bookDao;
    @Override
    public List<Book> GetAllBooks() {
        return bookDao.GetAllBooks();
    }

    @Override
    public void AddBook(Book book) {
       bookDao.addBook(book);
    }
}
