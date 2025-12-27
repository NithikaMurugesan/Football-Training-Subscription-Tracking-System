package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MembershipType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long typeId;
    private String typeName;
    private Double price;
    private int DurationInMonths;
    public MembershipType(String typeName, Double price, int DurationInMonths) {
        this.typeName = typeName;
        this.price = price;
        this.DurationInMonths = DurationInMonths;
    }
    public MembershipType() {
    }
    public String getTypeName() {
        return typeName;
    }
    public Long getTypeId() {
        return typeId;
    }
    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public int getDurationInMonths() {
        return DurationInMonths;
    }
    public void setDurationInMonths(int DurationInMonths) {
        this.DurationInMonths = DurationInMonths;
    }
}