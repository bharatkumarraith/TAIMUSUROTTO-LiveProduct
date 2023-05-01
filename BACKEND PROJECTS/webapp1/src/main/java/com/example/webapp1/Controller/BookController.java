package com.example.webapp1.Controller;

import com.example.webapp1.Model.Book;
import com.example.webapp1.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
//    List<Book> books=new ArrayList<Book>();
//    //http://localhost:9999/getdata
//    @GetMapping("/getdata")
//    public ResponseEntity<?> abcd()
//    {
//       return  new ResponseEntity<>("hii", HttpStatus.OK);
//    }
//    //http://localhost:9999/getadd/34/89
//    @GetMapping("/getadd/{value1}/{value2}")
//    public ResponseEntity<?> add(@PathVariable int value1, @PathVariable int value2)
//    {
//        int result=value1+value2;
//        return new ResponseEntity<>(result,HttpStatus.OK);
//    }
    //http://localhost:9999/GetBooks
    @Autowired
    private BookService bookService;
    @GetMapping("/GetBooks")
    public ResponseEntity<?> getBook()
    {
//        Book book[]={
//                new Book("Cpnm","OOPS","CB CHANDRAN",670)
//        };
        return new ResponseEntity<>(bookService.GetAllBooks(),HttpStatus.OK);
    }
    //http://localhost:9999/addBook
    @PostMapping("/addBook")
    public ResponseEntity<?> addBook(@RequestBody Book book)
    {
//        System.out.println(book);
     bookService.AddBook(book);

        return new ResponseEntity<>("Data received",HttpStatus.OK);
    }
}
