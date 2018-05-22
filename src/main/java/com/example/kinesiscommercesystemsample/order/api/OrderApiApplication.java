package com.example.kinesiscommercesystemsample.order.api;

import com.example.kinesiscommercesystemsample.ComponentScanBasePackage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackageClasses = {ComponentScanBasePackage.class})
public class OrderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderApiApplication.class, args);
	}
}
