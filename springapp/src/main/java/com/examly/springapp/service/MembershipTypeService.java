package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.MembershipTypeNotFoundException;
import com.examly.springapp.model.MembershipType;
import com.examly.springapp.repository.MembershipTypeRepository;

@Service
public class MembershipTypeService {
    @Autowired
    private MembershipTypeRepository repo;
    public MembershipType getMembershipTypebyId(Long id){
        return repo.findById(id).orElseThrow(() -> 
            new MembershipTypeNotFoundException("MembershipType not found with id: " + id));
    }
}
