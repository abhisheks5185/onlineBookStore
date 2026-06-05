package com.bookstore.repository;

import com.bookstore.entity.MyBookList;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBookListRepository extends MongoRepository<MyBookList,String> {

}
