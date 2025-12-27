package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Membership;
import com.examly.springapp.service.MembershipService;

@RestController
@RequestMapping("/api/memberships")
public class MembershipController {
    @Autowired
    private MembershipService service;
    @PostMapping
    public ResponseEntity<Membership> createMembership(@RequestBody Membership m){
        Membership n = service.createMembership(m);
        return ResponseEntity.status(201).body(n);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membership> getMembershipbyId(@PathVariable Long id){
        Membership n =service.getMembershipbyId(id);
        return ResponseEntity.status(200).body(n);
    }
    @GetMapping
    public ResponseEntity<List<Membership>> getallMembership(){
        List<Membership> l=service.getallMembership();
        return ResponseEntity.status(200).body(l);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Membership> update(@PathVariable Long id, @RequestBody Membership m){
        Membership n=service.update(id, m);
        return ResponseEntity.status(200).body(n);
    }
}