package com.debugapp.jpa_app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "bill")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(exclude = "order")
@ToString(exclude = "order")
public class BillEntity {
//    create table bill
//            (
//    id  varchar(64) not null
//    primary key,
//    total_amount numeric,
//    client_rfc   varchar(14) not null
//            )

    @Id
    @Column(nullable = false, length = 64)
    private String id;
    @Column(name = "total_amount", precision = 10, scale = 2)
    private BigDecimal totalAmount;
    @Column(name = "client_rfc", nullable = false, length = 14)
    private String rfc;
    @OneToOne(mappedBy = "bill", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private OrderEntity order;

}// END CLASS
