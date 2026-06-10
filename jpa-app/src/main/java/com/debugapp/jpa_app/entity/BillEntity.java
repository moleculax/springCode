package com.debugapp.jpa_app.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "bill")
@Data
public class BillEntity {
//    create table bill
//            (
//                    id           varchar(64) not null
//    primary key,
//    total_amount numeric,
//    client_rfc   varchar(14) not null
//            )

    @Id
    @Column(nullable = true, length = 64)
    private String id;
    @Column(name = "total_amount", precision = 10, scale = 2)
    private BigDecimal totalAmount;
    @Column(name = "client_rfc", nullable = false, length = 14)
    private String rfc;

}// END CLASS
