package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Payment;
import com.examly.springapp.service.PaymentServiceImpl;



@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentServiceImpl service;

    @PostMapping
    public ResponseEntity<Payment> createAttendance(@RequestBody Payment p){
        Payment n=service.createPayment(p);
        return ResponseEntity.status(201).body(n);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long id){
        Payment p = service.getPayment(id);
        
        return ResponseEntity.status(200).body(p);
    }
    @GetMapping
    public ResponseEntity<List<Payment>> getAllPayment(){
        List<Payment> l=service.getAllPayment();
        return ResponseEntity.status(200).body(l);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment p){
        Payment u= service.updatePayment(id,p);
        return ResponseEntity.status(200).body(u);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {

        boolean deleted = service.deletePayment(id);

        if (deleted) {
            return ResponseEntity.noContent().build(); 
        }
        return ResponseEntity.notFound().build(); 
    }
}