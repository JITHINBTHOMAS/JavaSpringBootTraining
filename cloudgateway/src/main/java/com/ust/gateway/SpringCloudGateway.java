package com.ust.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SpringCloudGateway {

	
	@Bean
	RouteLocator gatewayRoute (RouteLocatorBuilder builder) {
		return builder
				.routes()
				.route("helloservice",r->r.path("/rest/service/**")
				.filters(f->f.addResponseHeader("X-Response-Header", "World"))
				.uri("http://localhost:8071"))
				.route("factorialservice",r->r.path("/rest/factorial/**")
				.filters(f->f.addResponseHeader("Factorial-Header", "FACTSSS"))
				.uri("http://localhost:8074"))
				.build();
	}
	
}
