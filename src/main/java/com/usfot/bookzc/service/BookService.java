package com.usfot.bookzc.service;

import com.usfot.bookzc.dao.BookRepository;
import com.usfot.bookzc.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zc
 * @create 2019-05_29-23:24
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    List<Book> findAllBooksByAssortNameOrderByHits(String name){
        return bookRepository.findAllBooksByAssortNameOrderByHits(name);
    }
}
