package uk.co.sheffieldwebprogrammer.springsearch.estatediscovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EstatediscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstatediscoveryApplication.class, args);
	}

}
