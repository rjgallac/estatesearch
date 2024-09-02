package uk.co.sheffieldwebprogrammer.springsearch.estategateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;


import java.util.Arrays;
import java.util.Collections;

@SpringBootApplication
@EnableDiscoveryClient
public class EstategatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(EstategatewayApplication.class, args);
	}
}
