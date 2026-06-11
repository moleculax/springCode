package com.debugapp.jpa_app.service;

import com.debugapp.jpa_app.dto.OrderDTO;
import com.debugapp.jpa_app.entity.OrderEntity;
import com.debugapp.jpa_app.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    //public  void run(String[] args) throws Exception {
    public  void run(String... args) throws Exception {

        // Long orderId = 16L; // Reemplaza con el ID que deseas buscar/consultar
        //orderRepository.findById(orderId).ifPresent(order -> System.out.println("Cliente: " + order.getClientName()));
//      orderRepository.findAll().forEach(order -> System.out.println(order.getId()+ " / " +order.getClientName()
//      + " / " + order.getBill().getId() + " / " + order.getBill().getTotalAmount() + " / " + order.getBill().getRfc())
//      );
//      System.out.println("=== Fin de la consulta ===");


        // El método findAll() de CrudRepository retorna Iterable<T>, no List<T>.
        //  Por lo tanto, no puedes asignar directamente el resultado a una variable
        //  de tipo List<OrderEntity>. En su lugar, puedes usar un bucle para iterar sobre
        //  el Iterable o convertirlo a una lista si lo necesitas.
        Iterable<OrderEntity> resultado = orderRepository.findAll();
        //System.out.println(resultado);
        resultado.forEach(order -> {
            if (order.getBill() != null) {
                System.out.println(order.getClientName()
                        + " / " + order.getBill().getId()
                        + " / " + order.getBill().getTotalAmount()
                        + " / " + order.getBill().getRfc());
            } else {
                System.out.println(order.getClientName() + " / SIN FACTURA /");
            }
        });

    }

    // Devuelve lista de DTOs
    public List<OrderDTO> getOrders() {
        return StreamSupport.stream(orderRepository.findAll().spliterator(), false)
                .map(order -> new OrderDTO(
                        order.getId(),
                        order.getCreatedAt(),
                        order.getClientName(),
                        order.getIdBill()
                ))
                .collect(Collectors.toList());
    }
}
