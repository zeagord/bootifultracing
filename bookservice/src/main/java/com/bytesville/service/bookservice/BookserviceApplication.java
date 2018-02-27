package com.bytesville.service.bookservice;

import io.micrometer.core.instrument.binder.jvm.ClassLoaderMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
//@EnableEurekaClient
public class BookserviceApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(BookserviceApplication.class, args);
	}

	@Autowired
	BookRepository repository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Book book = new Book();
		book.setAuthor("Josh Long and Kenny Bastani");
		book.setTitle("Cloud Native Java");
		repository.save(book);
	}

	@Bean ClassLoaderMetrics cvmMemoryMetrics(){ return new ClassLoaderMetrics(); }
}
