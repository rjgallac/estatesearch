package uk.co.sheffieldwebprogrammer.springsearch.estateinfobackend.estateinfobackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EstateinfobackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstateinfobackendApplication.class, args);
	}

}
