package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.PaymentNotFoundException;
import com.examly.springapp.model.Payment;
import com.examly.springapp.repository.PaymentRepository;

@Service
public class PaymentService implements PaymentServiceImpl{
    @Autowired
    private PaymentRepository repo;
    public Payment createPayment(Payment p){
        return repo.save(p);
    }
    public Payment getPayment(Long id){
        return repo.findById(id).orElseThrow(() -> 
            new PaymentNotFoundException("Payment not found with id: " + id)); 
    }
    public List<Payment> getAllPayment(){
        return repo.findAll();
    }
    public Payment updatePayment(Long id, Payment p){
        Payment existing=repo.findById(id).orElse(null);
        if(existing !=null){
            existing.setMemberId(p.getMemberId());
            existing.setAmount(p.getAmount());
            existing.setPaymentDate(p.getPaymentDate());
        }
        return repo.save(existing);
    }
    public boolean deletePayment(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }
}
