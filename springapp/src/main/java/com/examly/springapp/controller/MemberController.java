package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.examly.springapp.model.Member;
import com.examly.springapp.service.MemberServiceImpl;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberServiceImpl service;

    @GetMapping("/page/{page}/{size}")
    public List<Member> getMembersByPage(
            @PathVariable int page,
            @PathVariable int size) {
        return service.getMembersByPage(page, size);
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        return new ResponseEntity<>(service.createMember(member), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return service.getMemberById(id);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id,
                               @RequestBody Member member) {
        return service.updateMember(id, member);
    }
}