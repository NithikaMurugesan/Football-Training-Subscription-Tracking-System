package com.examly.springapp.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.examly.springapp.model.Member;


@Service
public interface MemberServiceImpl {
    public List<Member> getMembersByPage(int page, int size);

    public Member createMember(Member member);

    public Member getMemberById(Long id);

    public Member updateMember(Long id, Member member);
}