package com.cjc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class IndiGoApplication {

	public static void main(String[] args)
	{
		System.out.println("MicroService for IndiGo");
		SpringApplication.run(IndiGoApplication.class, args);
	}

}
