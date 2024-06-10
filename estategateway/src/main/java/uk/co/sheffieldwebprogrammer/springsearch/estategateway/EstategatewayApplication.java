package uk.co.sheffieldwebprogrammer.springsearch.estategateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EstategatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstategatewayApplication.class, args);
	}

}
