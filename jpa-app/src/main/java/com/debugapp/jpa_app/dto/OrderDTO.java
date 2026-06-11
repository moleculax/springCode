package com.debugapp.jpa_app.dto;


import java.time.LocalDateTime;

public class OrderDTO {

    private Long id;
    private LocalDateTime createdAt;
    private String clientName;
    private String idBill;

    // Constructor vacío
    public OrderDTO() {}

    // Constructor con todos los campos
    public OrderDTO(Long id, LocalDateTime createdAt, String clientName, String idBill) {
        this.id = id;
        this.createdAt = createdAt;
        this.clientName = clientName;
        this.idBill = idBill;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getIdBill() {
        return idBill;
    }

    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }
}

