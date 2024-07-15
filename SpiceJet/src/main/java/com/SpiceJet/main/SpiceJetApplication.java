package com.SpiceJet.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
public class SpiceJetApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpiceJetApplication.class, args);
	}

}
