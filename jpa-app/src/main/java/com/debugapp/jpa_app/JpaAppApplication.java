package com.debugapp.jpa_app;

import com.debugapp.jpa_app.service.BillService;
import com.debugapp.jpa_app.service.InsertdatosService;
import com.debugapp.jpa_app.service.OrderService;
import com.debugapp.jpa_app.service.UnifiedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaAppApplication implements CommandLineRunner {

	private final OrderService orderService;
	private final BillService billService;
	private final UnifiedService unifiedService;
	private final InsertdatosService insertdatosService;

	@Autowired
	public JpaAppApplication(OrderService orderService, BillService billService, UnifiedService unifiedService, InsertdatosService insertdatosService) {
		this.orderService = orderService;
		this.billService = billService;
		this.unifiedService = unifiedService;
		this.insertdatosService = insertdatosService;
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

		insertdatosService.insertdatos();
	} //run(String... args)

}