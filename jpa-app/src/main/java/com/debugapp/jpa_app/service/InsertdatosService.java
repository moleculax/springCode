package com.debugapp.jpa_app.service;

import com.debugapp.jpa_app.entity.BillEntity;
import com.debugapp.jpa_app.entity.OrderEntity;
import com.debugapp.jpa_app.repository.BillRepository;
import com.debugapp.jpa_app.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Service
public class InsertdatosService {

    private final OrderRepository orderRepository;
    private final BillRepository billRepository;

    public InsertdatosService(OrderRepository orderRepository, BillRepository billRepository) {
        this.orderRepository = orderRepository;
        this.billRepository = billRepository;
    }

    @Transactional
    public void insertdatos() {
        System.out.println("INSERTAMOS NUEVO DATO");

        String billId = "BILL-002";

        // VERIFICO SI LA FACTURA EXISTE
        if (billRepository.findById(billId).isEmpty()) {
            // SI NO EXISTE CREA Y GUARDA
            BillEntity bill = new BillEntity();
            bill.setId(billId);
            bill.setTotalAmount(BigDecimal.valueOf(100.0));
            bill.setRfc("RFC-002");
            // ============================================
            billRepository.save(bill);
            System.out.println("FACTURA GUARDADA");

            // CREA Y GUARDA ÑA ORDEN  (usando idBill como String)
            OrderEntity order = new OrderEntity();
            order.setIdBill(billId);  // Usar idBill como String
            order.setCreatedAt(LocalDateTime.now());
            order.setClientName("Lupe Lepon");
            // ============================================
            orderRepository.save(order);
            System.out.println("ORDEN GUARDADA");

        } else {
            System.out.println("La factura ya existe No se Insertara");
        }

       // System.out.println("PROCESO COMPLETADO CON EXITO");
    }
}