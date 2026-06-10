package com.debugapp.jpa_app;

import com.debugapp.jpa_app.entity.OrderEntity;
import com.debugapp.jpa_app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class JpaAppApplication implements CommandLineRunner {

	@Autowired
	private OrderRepository orderRepository;

	public static void main(String[] args) {

		SpringApplication.run(JpaAppApplication.class, args);

	}

	@Override
	//public  void run(String[] args) throws Exception {
	public  void run(String... args) throws Exception {

		// Long orderId = 16L; // Reemplaza con el ID que deseas buscar
		//orderRepository.findById(orderId).ifPresent(order -> System.out.println("Cliente: " + order.getClientName()));
//		orderRepository.findAll().forEach(order -> System.out.println(order.getId()+ " / " +order.getClientName()
//		+ " / " + order.getBill().getId() + " / " + order.getBill().getTotalAmount() + " / " + order.getBill().getRfc())
//		);
//		System.out.println("=== Fin de la consulta ===");


		// El método findAll() de CrudRepository retorna Iterable<T>, no List<T>.
		//  Por lo tanto, no puedes asignar directamente el resultado a una variable
		//  de tipo List<OrderEntity>. En su lugar, puedes usar un bucle para iterar sobre
		//  el Iterable o convertirlo a una lista si lo necesitas.
		Iterable<OrderEntity> resultado = orderRepository.findAll();
		//System.out.println(resultado);
		resultado.forEach(order -> System.out.println(order.getClientName()
				+ " / " + order.getBill().getId()
				+ " / " + order.getBill().getTotalAmount()
				+ " / " + order.getBill().getRfc()));

	}

}
