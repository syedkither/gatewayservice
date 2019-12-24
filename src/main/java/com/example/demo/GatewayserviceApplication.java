package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
 * Zuul is built on servlet 2.5 (works with 3.x), using blocking APIs. It doesn't support any long lived connections, like websockets.
 * Gateway is built on Spring Framework 5, Project Reactor and Spring Boot 2 using non-blocking APIs. Websockets are supported and it's a much better developer experience since it's tightly integrated with Spring.
 * 
 */
@SpringBootApplication
public class GatewayserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserviceApplication.class, args);
	}

}
