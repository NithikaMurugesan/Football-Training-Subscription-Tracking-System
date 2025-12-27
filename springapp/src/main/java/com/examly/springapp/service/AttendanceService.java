package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Attendance;
import com.examly.springapp.repository.AttendanceRepository;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository repo;
    public Attendance createAttendance(Attendance a){
        return repo.save(a);
    }
    public Attendance getAttendance(Long id){
        return repo.findById(id).orElse(null); 
    }
    public List<Attendance> getAllAttendances(){
        return repo.findAll();
    }
    public Attendance updateAttendance(Long id, Attendance a){
        Attendance existing=repo.findById(id).orElse(null);
        if(existing !=null){
            existing.setDate(a.getDate());
            existing.setCheckInTime(a.getCheckInTime());
            existing.setCheckOutTime(a.getCheckOutTime());
            existing.setMemberId(a.getMemberId());
        }
        return repo.save(existing);
    }
}