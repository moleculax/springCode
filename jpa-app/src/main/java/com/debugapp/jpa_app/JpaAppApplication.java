package com.debugapp.jpa_app;

import com.debugapp.jpa_app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaAppApplication implements CommandLineRunner {

	private final OrderService orderService;
	private final BillService billService;
	private final UnifiedService unifiedService;
	private final InsertBillOrdersService insertBillOrdersService;
	private final DeleleBillOrderService deleleBillOrderService;

	@Autowired
	public JpaAppApplication(OrderService orderService, BillService billService, UnifiedService unifiedService, InsertBillOrdersService insertBillOrdersService, DeleleBillOrderService deleleBillOrderService) {
		this.orderService = orderService;
		this.billService = billService;
		this.unifiedService = unifiedService;
		this.insertBillOrdersService = insertBillOrdersService;
		this.deleleBillOrderService = deleleBillOrderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// billService.run(args);
		// orderService.run(args);
		// billService.getBills();
		// orderService.getOrders();

		// =======================================================
		// INSERTO NUEVOS DATOS
		insertBillOrdersService.insertdatos();
		// ======================================================
		// ELIMINIO SI EXISTE
		deleleBillOrderService.deleteByIdBill("BILL-003"); // Reemplaza "BILL-001" con el ID de la factura que deseas eliminar
		// ========================================================



		var unificados = unifiedService.getUnifiedResults();

		System.out.println("========= RESULTADOS UNIFICADOS ========");

		// Facturas
//		billService.getBills().forEach(bill ->
//				System.out.println("Bill: " + bill.getId() + " / " + bill.getTotalAmount() + " / " + bill.getClientRfc())
//		);

		// Órdenes
//		orderService.getOrders().forEach(order ->
//				System.out.println("Order: " + order.getId() + " / " + order.getClientName()
//						+ " / " + order.getCreatedAt()
//						+ " / " + order.getIdBill())
//		);

		unificados.forEach(unified -> {
			if (unified.getIdBill() != null) {
				System.out.println("Unificado: " + unified.getId() + " / " + unified.getClientName()
						+ " / " + unified.getCreatedAt()
						+ " / " + unified.getIdBill()
						+ " / " + unified.getTotalAmount()
						+ " / " + unified.getClientRfc());
			} else {
				System.out.println("Unificado: " + unified.getId() + " / " + unified.getClientName()
						+ " / " + unified.getCreatedAt()
						+ " / SIN FACTURA");
			}
		});


	} //run(String... args)

}