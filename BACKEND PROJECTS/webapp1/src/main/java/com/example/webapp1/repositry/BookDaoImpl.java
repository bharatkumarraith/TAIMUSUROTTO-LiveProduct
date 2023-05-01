package com.example.webapp1.repositry;

import com.example.webapp1.Model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class BookDaoImpl implements BookDao{
    private List<Book> bookList;
    public BookDaoImpl()
    {
        bookList=new ArrayList<Book>();
    }
    @Override
    public List<Book> GetAllBooks() {
        return bookList;
    }

    @Override
    public void addBook(Book book) {
       bookList.add(book);
    }
}
