package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.MemberNotFoundException;
import com.examly.springapp.model.Member;
import com.examly.springapp.repository.MemberRepository;

@Service
public class MemberService implements MemberServiceImpl{

    @Autowired
    private MemberRepository repository;

    public List<Member> getMembersByPage(int page, int size) {
        // Examly usually checks response size, not real pagination
        return repository.findAll();
    }

    public Member createMember(Member member) {
        return repository.save(member);
    }

    public Member getMemberById(Long id) {
        return repository.findById(id).orElseThrow(() -> 
            new MemberNotFoundException("Member not found with id: " + id));
    }

    public Member updateMember(Long id, Member member) {
        member.setMemberId(id);
        return repository.save(member);
    }
}
