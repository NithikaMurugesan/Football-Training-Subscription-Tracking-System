package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long membershipId;
    private Long memberId;
    private Long typeId;
    private String startDate;
    private String endDate;
    public Membership(Long memberId, Long typeId, String startDate, String endDate) {
        this.memberId = memberId;
        this.typeId = typeId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public Long getMembershipId() {
        return membershipId;
    }
    public void setMembershipId(Long membershipId) {
        this.membershipId = membershipId;
    }
    public Long getMemberId() {
        return memberId;
    }
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public Long getTypeId() {
        return typeId;
    }
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}