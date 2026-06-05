package com.bookstore.controller;

import com.bookstore.repository.MyBookListRepository;
import com.bookstore.service.MyBookListService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookListController {

    @Autowired
    private MyBookListService myBookListService;

    @RequestMapping("/deleteMyBook/{id}")
    public String deleteMyBook(@PathVariable("id") String id){
        myBookListService.deleteMyBook(id);
        return "redirect:/my_books";
    }
}
