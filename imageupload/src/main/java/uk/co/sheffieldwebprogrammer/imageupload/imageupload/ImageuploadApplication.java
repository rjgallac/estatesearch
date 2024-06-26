package uk.co.sheffieldwebprogrammer.imageupload.imageupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ImageuploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImageuploadApplication.class, args);
	}

}
