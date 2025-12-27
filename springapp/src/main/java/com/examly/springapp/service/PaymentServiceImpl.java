package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Payment;

@Service
public interface PaymentServiceImpl {
    public Payment createPayment(Payment p);

    public Payment getPayment(Long id);

    public List<Payment> getAllPayment();

    public Payment updatePayment(Long id, Payment p);

    public boolean deletePayment(Long id);
}