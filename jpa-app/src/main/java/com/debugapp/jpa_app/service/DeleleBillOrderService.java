package com.debugapp.jpa_app.service;

import com.debugapp.jpa_app.repository.BillRepository;
import com.debugapp.jpa_app.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleleBillOrderService {

    private final OrderRepository orderRepository;
    private final BillRepository billRepository;

    public DeleleBillOrderService(OrderRepository orderRepository, BillRepository billRepository) {
        this.orderRepository = orderRepository;
        this.billRepository = billRepository;
    }

    @Transactional  // ← IMPORTANTE: Garantiza que ambas eliminaciones sean atómicas
    public void deleteByIdBill(String idBill) {

        // 1. VERIFICAR SI EXISTE LA ORDEN
        boolean orderExists = orderRepository.existsByIdBill(idBill);

        // 2. VERIFICAR SI EXISTE LA FACTURA
        boolean billExists = billRepository.existsById(idBill);

        // 3. ELIMINAR ORDEN (si existe)
        if (orderExists) {
            orderRepository.deleteByIdBill(idBill);
            System.out.printf("✅ ORDEN CON ID '%s' ELIMINADA%n", idBill);
        } else {
            System.out.printf("⚠️ ORDEN CON ID '%s' NO EXISTÍA%n", idBill);
        }

        // 4. ELIMINAR FACTURA (si existe)
        if (billExists) {
            billRepository.deleteById(idBill);
            System.out.printf("✅ FACTURA CON ID '%s' ELIMINADA%n", idBill);
        } else {
            System.out.printf("⚠️ FACTURA CON ID '%s' NO EXISTÍA%n", idBill);
        }

        if (!orderExists && !billExists) {
            System.out.printf("❌ NINGÚN REGISTRO ENCONTRADO CON ID: %s%n", idBill);
        }
    }
}