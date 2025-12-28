package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.MembershipNotFoundException;
import com.examly.springapp.model.Membership;
import com.examly.springapp.repository.MembershipRepository;

@Service
public class MembershipService {
    @Autowired
    private MembershipRepository repo;

    public Membership createMembership(Membership m){
        return repo.save(m);
    }
    public Membership getMembershipbyId(Long id){
        return repo.findById(id).orElseThrow(() -> 
            new MembershipNotFoundException("Membership not found with id: " + id));
    }
    public List<Membership> getallMembership(){
        return repo.findAll();
    }
    public Membership update(Long id, Membership m){
        Membership existing = repo.findById(id).orElse(null);
        if(existing != null){
            existing.setMemberId(m.getMemberId());
            existing.setTypeId(m.getTypeId());
            existing.setStartDate(m.getStartDate());
            existing.setEndDate(m.getEndDate());
        }
        return repo.save(existing);
    }
}
