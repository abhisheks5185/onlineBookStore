package com.bookstore.service;

import com.bookstore.entity.MyBookList;
import com.bookstore.repository.MyBookListRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookListService {

    @Autowired
    private MyBookListRepository myBookListRepository;

    public void saveMyBooks(MyBookList myBookList){
        myBookListRepository.save(myBookList);
    }

    public List<MyBookList> getMyBookList(){
        return myBookListRepository.findAll();
    }

    public void deleteMyBook(String id){
        myBookListRepository.deleteById(id);
    }
}
