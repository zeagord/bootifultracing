package com.bytesville.service.gatewayserver;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootApplication
@EnableZuulProxy
//@EnableEurekaClient
@RestController
public class GatewayserverApplication {

	Logger log = LoggerFactory.getLogger(GatewayserverApplication.class);

	@Autowired
	LoadBalancerClient loadBalancerClient;


	private RestTemplate restTemplate = new RestTemplate();
	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

	@GetMapping("/api/books")
	@HystrixCommand(fallbackMethod = "GetBooksFallback")
	public ResponseEntity getBooks() {
		log.info("Gatewayserver --> Get books");
		ServiceInstance instance = loadBalancerClient.choose("BOOKSERVICE");
		String URL =  instance.getUri().toString();
		log.info("URL -> " + URL);
		ResponseEntity responseEntity = restTemplate.getForEntity(URL + "/books", String.class);
		return responseEntity;
		//return new ResponseEntity<>(null, HttpStatus.OK);
	}

	private String GetBooksFallback() {
		return "Some Error Happebed";
	}
}
