package com.debugapp.jpa_app.service;

import com.debugapp.jpa_app.entity.BillEntity;
import com.debugapp.jpa_app.entity.OrderEntity;
import com.debugapp.jpa_app.repository.BillRepository;
import com.debugapp.jpa_app.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
        String idBill = billId; // Reemplaza con el ID que deseas buscar/actualizar
        // ============================================
        // 1. VERIFICAR Y ACTUALIZAR/GUARDAR FACTURA
        // ============================================
        Optional<BillEntity> existingBill = billRepository.findById(billId);

        if (existingBill.isEmpty()) {
            // SI NO EXISTE: CREAR NUEVA FACTURA
            BillEntity bill = new BillEntity();
            bill.setId(billId);
            bill.setTotalAmount(BigDecimal.valueOf(100.0));
            bill.setRfc("RFC-002");
            billRepository.save(bill);
            System.out.println("✅ FACTURA CREADA");
        } else {
            // SI EXISTE: ACTUALIZAR FACTURA
            BillEntity bill = existingBill.get();
            bill.setTotalAmount(BigDecimal.valueOf(150.0));  // Actualizar monto
            bill.setRfc("RFC-002");                  // Actualizar RFC
            billRepository.save(bill);
            System.out.println("✅ FACTURA ACTUALIZADA");
        }

        // ============================================
        // 2. VERIFICAR Y ACTUALIZAR/GUARDAR ORDEN
        // ============================================
        // USO Optional y no List porque  solo puede haber 0 o 1 resultado
        // findByIdBill es personalizado
        Optional<OrderEntity> existingOrder = orderRepository.findByIdBill(idBill); // BUSCAMOS ORDEN POR ID DE FACTURA (ID BILL)

        if (existingOrder.isEmpty()) {
            // SI NO EXISTE: CREAR NUEVA ORDEN
            OrderEntity order = new OrderEntity();
            order.setIdBill(billId);
            order.setCreatedAt(LocalDateTime.now());
            order.setClientName("Lupe Lepon");
            orderRepository.save(order);
            System.out.println("ORDEN CREADA");
        } else {
            // SI EXISTE: ACTUALIZAR ORDEN
            OrderEntity order = existingOrder.get();
            order.setClientName("Lupe P. Lepon"); // Actualizar nombre del cliente
            order.setCreatedAt(LocalDateTime.now());
            orderRepository.save(order);
            System.out.println(" ORDEN ACTUALIZADA");
        }

        System.out.println("✅ PROCESO COMPLETADO CON EXITO");
    }
}