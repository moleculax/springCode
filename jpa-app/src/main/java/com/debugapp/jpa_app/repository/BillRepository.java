package com.debugapp.jpa_app.repository;

import com.debugapp.jpa_app.entity.BillEntity;
import com.debugapp.jpa_app.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//public interface BillRepository extends CrudRepository<BillEntity, String> {
//
//}

public interface BillRepository extends JpaRepository<BillEntity, String> {

}
