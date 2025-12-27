package com.examly.springapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;
    private Long memberId;  
    private String date;
    private String checkInTime;
    private String checkOutTime;

    public Long getAttendanceId() {
        return attendanceId;
    }
    public void setAttendanceId(Long attendanceId) {
        this.attendanceId = attendanceId;
    }
    public Attendance(Long memberId, String date, String checkInTime, String checkOutTime) {
        this.memberId = memberId;
        this.date = date;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }
    public Long getMemberId() {
        return memberId;
    }
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getCheckInTime() {
        return checkInTime;
    }
    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }
    public String getCheckOutTime() {
        return checkOutTime;
    }
    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }
    
}