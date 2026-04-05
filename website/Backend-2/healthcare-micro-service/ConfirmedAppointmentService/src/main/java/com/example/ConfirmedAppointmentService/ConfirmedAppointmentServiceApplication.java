package com.example.ConfirmedAppointmentService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ConfirmedAppointmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfirmedAppointmentServiceApplication.class, args);
	}

}
