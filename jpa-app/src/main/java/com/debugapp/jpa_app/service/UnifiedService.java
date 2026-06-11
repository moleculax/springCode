package com.debugapp.jpa_app.service;

import com.debugapp.jpa_app.dto.OrderWithBillDTO;
import com.debugapp.jpa_app.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UnifiedService {

    private  final OrderService orderService;
    private final BillService billService;

    public UnifiedService(OrderService orderService, BillService billService) {
        this.orderService = orderService;
        this.billService = billService;
    }

    public List<OrderWithBillDTO> getUnifiedResults() {
        var orders = orderService.getOrders(); // List<OrderDTO>
        var bills = billService.getBills();    // List<BillDTO>

        List<OrderWithBillDTO> unifiedList = new ArrayList<>();

        for (var order : orders) {
            for (var bill : bills) {
                if (bill.getId().equals(order.getIdBill())) {
                    OrderWithBillDTO dto = new OrderWithBillDTO();
                    dto.setId(order.getId());
                    dto.setClientName(order.getClientName());
                    dto.setCreatedAt(order.getCreatedAt());
                    dto.setIdBill(order.getIdBill());

                    dto.setTotalAmount(bill.getTotalAmount());
                    dto.setClientRfc(bill.getClientRfc());

                    unifiedList.add(dto); // aquí se agrega cada combinación
                }
            }
        }

        return unifiedList;
    }



}// END CLASS
