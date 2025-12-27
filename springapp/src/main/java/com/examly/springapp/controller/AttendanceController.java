package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Attendance;
import com.examly.springapp.service.AttendanceService;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {
    @Autowired
    private AttendanceService service; 

    @PostMapping
    public ResponseEntity<Attendance> createAttendance(@RequestBody Attendance a){
        Attendance n=service.createAttendance(a);
        return ResponseEntity.status(201).body(n);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Attendance> getAttendance(@PathVariable Long id){
        Attendance a = service.getAttendance(id);
        return new ResponseEntity<>(a,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Attendance>> getAllAttendances(){
        List<Attendance> l=service.getAllAttendances();
        return ResponseEntity.status(200).body(l);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Attendance> updateAttendance(@PathVariable Long id, @RequestBody Attendance a){
        Attendance u = service.updateAttendance(id,a);
        return ResponseEntity.status(200).body(u);
    }
}