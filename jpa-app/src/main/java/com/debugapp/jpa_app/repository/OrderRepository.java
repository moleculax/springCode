package com.debugapp.jpa_app.repository;

import com.debugapp.jpa_app.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

// CrudRepository es una interfaz de Spring Data JPA que provee operaciones
// básicas de CRUD (Create, Read, Update, Delete) sobre entidades sin
// necesidad de escribir código SQL ni implementar métodos manualmente.
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {


}// END interface
