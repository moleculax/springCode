package com.debugapp.jpa_app.dto;

import java.math.BigDecimal;

public class BillDTO {

    private String id;
    private BigDecimal totalAmount;
    private String clientRfc;

    // Constructor vacío
    public BillDTO() {}

    // Constructor con todos los campos
    public BillDTO(String id, BigDecimal totalAmount, String clientRfc) {
        this.id = id;
        this.totalAmount = totalAmount;
        this.clientRfc = clientRfc;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getClientRfc() {
        return clientRfc;
    }

    public void setClientRfc(String clientRfc) {
        this.clientRfc = clientRfc;
    }
}
