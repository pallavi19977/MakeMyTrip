package com.airIndia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class AirIndiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirIndiaApplication.class, args);
	}

}
