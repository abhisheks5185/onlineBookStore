package com.bookstore.service;

import com.bookstore.entity.Book;
import com.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book save(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }
    public Book getBookById(String id){
        return bookRepository.findById(id).get();
    }

    public void deleteBookById(String id){
        bookRepository.deleteById(id);
    }
}
