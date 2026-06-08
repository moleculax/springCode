package com.debugapp.jpa_app.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class OrderEntity {

//    CREATE TABLE orders (
//            id BIGSERIAL PRIMARY KEY,
//            created_at TIMESTAMP NOT NULL,
//            client_name VARCHAR(32) NOT NULL,
//            id_bill VARCHAR(64) UNIQUE NOT NULL,
//            FOREIGN KEY (id_bill) REFERENCES bill(id) ON DELETE CASCADE
//        );

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "client_name", nullable = false, length = 32)
    private String clientName;
    @Column(name = "id_bill", nullable = false, unique = true, length = 64)
    private String idBill;





}
