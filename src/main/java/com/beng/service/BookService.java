package com.beng.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.beng.dao.BookDao;

@Service
public class BookService {

    @Autowired(required = false)
    @Qualifier("bookDao2")
    // @Autowired
    BookDao bookDao;

    public void print() {
        System.out.println(bookDao);
    }

    @Override
    public String toString() {
        return "BookService [bookDao=" + bookDao + "]";
    }

}
