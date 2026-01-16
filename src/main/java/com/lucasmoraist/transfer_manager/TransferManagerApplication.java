package com.lucasmoraist.transfer_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TransferManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransferManagerApplication.class, args);
	}

}
