package com.usfot.bookzc.dao;

import com.usfot.bookzc.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author zc
 * @create 2019-05_29-22:35
 */
public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
    @Query("SELECT b.id, b.title, b.introduction, b.pictureUrl, a.name, ao.name, b.hits from Book b, Assort a,Author ao WHERE a.name =?1 ORDER BY b.hits DESC")
    List<Book> findAllBooksByAssortNameOrderByHits(String name);
}
