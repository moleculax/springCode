package com.debugapp.jpa_app.repository;

import com.debugapp.jpa_app.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

// CrudRepository es una interfaz de Spring Data JPA que provee operaciones
// básicas de CRUD (Create, Read, Update, Delete) sobre entidades sin
// necesidad de escribir código SQL ni implementar métodos manualmente.
//public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
//
//
//}// END interface

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    // AGREGAMOS PERSONALIZADOS
     Optional<OrderEntity> findByIdBill(String idBill);
     List<OrderEntity> findByClientName(String clientName);
     void deleteByIdBill(String idBill);
     boolean existsByIdBill(String idBill);

    // =============================================================

}// END interface
