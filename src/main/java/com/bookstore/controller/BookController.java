package com.bookstore.controller;

import org.springframework.ui.Model;
import com.bookstore.entity.Book;
import com.bookstore.entity.MyBookList;
import com.bookstore.service.BookService;
import com.bookstore.service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private MyBookListService myBookListService;
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/book_register")
    public String bookdddRegister() {
        return "bookRegister";
    }

    @GetMapping("/available_books")
    public ModelAndView availableBooks(){
        List<Book> list = bookService.getAllBook();
        return new ModelAndView("availableBooks", "book", list);
    }

    @GetMapping("/my_books")
    public String myBooks(Model model){
        List<MyBookList> list = myBookListService.getMyBookList();
//        model.addAttribute("book",list);
        model.addAttribute("book", list);
        return "myBooks";
    }


    @PostMapping("/save")
    public String addbook(@ModelAttribute Book book){
        bookService.save(book);
        return "redirect:/available_books";
    }

    @RequestMapping("/myList/{id}")
    public String myList(@PathVariable String id){
        Book book = bookService.getBookById(id);
        MyBookList myBookList = new MyBookList(book.getId(), book.getName(),book.getAuthor(),book.getPrice());
        myBookListService.saveMyBooks(myBookList);
        return "redirect:/my_books";
    }

    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") String id, Model model){
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") String id){
        bookService.deleteBookById(id);
        return "redirect:/available_books";
    }
//@PostMapping("/save")
//public String addbook(@ModelAttribute Book book) {
//    try {
//        bookService.save(book);
//        return "redirect:/available_books";
//    } catch (Exception e) {
////        e.printStackTrace();
//        return "home";
//    }
//}


}