package com.example.demo;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/course/**")
                        .filters(f -> f.rewritePath("/api/course/(?<remains>.*)", "/${remains}")
                               //.addRequestHeader("X-Content-Type-Options", "application/json")
                                .prefixPath("/course")
                                .hystrix(c -> c.setName("hystrix")
                                        .setFallbackUri("forward:/fallback/course")))
                        .uri("lb://COURSE-SERVICE/")
                        .id("course-service"))

                .route(r -> r.path("/api/student/**")
                        .filters(f -> f.rewritePath("/api/student/(?<remains>.*)", "/${remains}")                        		
                        		//.addRequestHeader("X-Content-Type-Options", "application/json")
                        		.prefixPath("/student")
                                .hystrix(c -> c.setName("hystrix")
                                        .setFallbackUri("forward:/fallback/student")))
                        .uri("lb://STUDENT-SERVICE/")
                        .id("student-service"))
                .build();
    }

}
