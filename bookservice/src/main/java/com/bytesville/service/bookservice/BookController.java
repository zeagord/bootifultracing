package com.bytesville.service.bookservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookRepository repository;

    @GetMapping(path = "/books")
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<List<Book>>(repository.findAll(), HttpStatus.OK);
    }
}
