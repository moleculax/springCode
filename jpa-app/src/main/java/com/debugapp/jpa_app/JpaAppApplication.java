package com.debugapp.jpa_app;

import com.debugapp.jpa_app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaAppApplication implements CommandLineRunner {

	@Autowired
//	private OrderRepository orderRepository;
	private OrderService orderService;
	public static void main(String[] args) {

		SpringApplication.run(JpaAppApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		orderService.run(args);
	}

}
