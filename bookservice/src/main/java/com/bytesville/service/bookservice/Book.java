package com.bytesville.service.bookservice;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "books")
public class Book {

    @Id
    private String id;

    private String title;

    private String author;
}