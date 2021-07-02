package com.firstspringboot.test;


import com.firstspringboot.domain.Book;
import com.firstspringboot.impl.BookImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @Autowired
    private BookImpl bookImpl;

    @org.junit.Test
    public void findBookByName() {
        Book book = bookImpl.findBookByName("中华民国革命秘史");
        System.out.println(book);
    }
    @org.junit.Test
    public void FuzzySearchByAuthor() {
        List<Book> book = bookImpl.fuzzyQueryByAuthor("特");
        System.out.println(book);
    }
    @org.junit.Test
    public void FuzzySearchByName() {
        List<Book> book = bookImpl.fuzzyQueryByName("特");
        System.out.println(book);
    }
    @org.junit.Test
    public void FuzzySearchByNameCount() {
        Long total = bookImpl.fuzzyQueryByNameCount("特");
        System.out.println(total);
    }
    @org.junit.Test
    public void FuzzySearchByAuthorCount() {
        Long total = bookImpl.fuzzyQueryByAuthorCount("特");
        System.out.println(total);
    }
    @org.junit.Test
    public void PageSearchByName() {
        List<Book> books = bookImpl.pageQueryByName("特",1,2);
        System.out.println(books);
        long test = 10;
        int count = (int)test/3 + 1;
        System.out.println(count);
    }
}
