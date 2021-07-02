package com.firstspringboot.impl;

import com.firstspringboot.dao.BookDao;
import com.firstspringboot.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.regex.Pattern;


@Component
public class BookImpl implements BookDao {
    private MongoTemplate mongoTemplate;

    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Book findBookByName(String name) {
        Query query = new Query(Criteria.where("书名").is(name));
        return mongoTemplate.findOne(query, Book.class);
    }

    @Override
    public List<Book> fuzzyQueryByAuthor(String author) {
        Pattern pattern = Pattern.compile("^" + author + ".*", Pattern.CASE_INSENSITIVE);
        Query query = new Query(Criteria.where("作者").regex(pattern));
        List<Book> books = mongoTemplate.find(query, Book.class);
        return books;
    }

    @Override
    public List<Book> fuzzyQueryByName(String name) {
        Pattern pattern = Pattern.compile("^" + name + ".*", Pattern.CASE_INSENSITIVE);
        Query query = new Query(Criteria.where("书名").regex(pattern));
        List<Book> books = mongoTemplate.find(query, Book.class);
        return books;
    }

    @Override
    public Long fuzzyQueryByAuthorCount(String author) {
        Pattern pattern = Pattern.compile("^" + author + ".*", Pattern.CASE_INSENSITIVE);
        Query query = new Query(Criteria.where("作者").regex(pattern));
        long total = mongoTemplate.count(query, Book.class);
        return total;
    }

    @Override
    public Long fuzzyQueryByNameCount(String name) {
        Pattern pattern = Pattern.compile("^" + name + ".*", Pattern.CASE_INSENSITIVE);
        Query query = new Query(Criteria.where("书名").regex(pattern));
        long total = mongoTemplate.count(query, Book.class);
        return total;
    }

    @Override
    public List<Book> pageQueryByName(String name, int page, int rows) {
        Pattern pattern = Pattern.compile("^" + name + ".*", Pattern.CASE_INSENSITIVE);
        Query query = new Query();
        Pageable pageable = PageRequest.of(page,rows);
        query.addCriteria(Criteria.where("书名").regex(pattern));
        query.with(pageable);
        List<Book> books = mongoTemplate.find(query, Book.class);
        return books;
    }

    @Override
    public List<Book> pageQueryByAuthor(String author, int page, int rows) {
        Pattern pattern = Pattern.compile("^" + author + ".*", Pattern.CASE_INSENSITIVE);
        Query query = new Query();
        Pageable pageable = PageRequest.of(page,rows);
        query.addCriteria(Criteria.where("作者").regex(pattern));
        query.with(pageable);
        List<Book> books = mongoTemplate.find(query, Book.class);
        return books;
    }
}
