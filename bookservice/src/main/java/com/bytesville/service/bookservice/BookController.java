package com.bytesville.service.bookservice;

import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.List;

@RestController
@Timed(percentiles = {0.5, 0.75, 0.9, 0.999}, histogram = true)
public class BookController {

    private static final Log log = LogFactory.getLog(BookController.class);

    @Autowired
    BookRepository repository;

    @GetMapping(path = "/books")
    public ResponseEntity<List<Book>> getBooks() {
        log.info (" @@ get books");
        return new ResponseEntity<List<Book>>(repository.findAll(), HttpStatus.OK);
    }
}
