package com.denmiagkov.homwork9.apigateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
//                .route("Microservice1", r -> r.path("/serviceA/**")
//                        .uri("http://localhost:8081/"))
                .route("Microservice2", r -> r.path("/tasks-service/**")
                        .uri("http://localhost:8085/")).build();
    }
}
