package com.debugapp.jpa_app.service;

import com.debugapp.jpa_app.dto.BillDTO;
import com.debugapp.jpa_app.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;
import java.util.stream.Collectors;

@Service
//public class BillService implements CommandLineRunner {
public class BillService  {
    @Autowired
    private final BillRepository billRepository;


    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

//    @Override
//    public void run(String... args) {
//        billRepository.findAll().forEach(bill ->
//                System.out.println(bill.getId() + " / " + bill.getTotalAmount() + " / " + bill.getRfc()));
//
//
//    }



    public List<BillDTO> getBills() {
        return billRepository.findAll().stream()
                .map(bill -> new BillDTO(
                        bill.getId(),
                        bill.getTotalAmount(),
                        bill.getRfc()
                ))
                .collect(Collectors.toList());
    }



}
