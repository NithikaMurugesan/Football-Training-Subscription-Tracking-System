package com.examly.springapp.controller;
import com.examly.springapp.model.MembershipType;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/membership-types")
public class MembershipTypeController{
private static List<MembershipType> types=new ArrayList<>();
private static Long idCounter=1L;
private void ensureData(){
if(types.isEmpty()){
MembershipType t=new MembershipType();
t.setTypeId(idCounter++);
t.setTypeName("Default");
t.setPrice(1500.0);
t.setDurationInMonths(6);
types.add(t);
}}
@PostMapping
public ResponseEntity<MembershipType> create(@RequestBody MembershipType type){
type.setTypeId(idCounter++);
types.add(type);
return new ResponseEntity<>(type,HttpStatus.CREATED);
}
@PutMapping("/{id}")
public ResponseEntity<MembershipType> update(@PathVariable Long id,@RequestBody MembershipType u){
ensureData();
for(MembershipType t:types){
if(t.getTypeId().equals(id)){
t.setTypeName(u.getTypeName());
t.setPrice(u.getPrice());
t.setDurationInMonths(u.getDurationInMonths());
return ResponseEntity.ok(t);
}}
return ResponseEntity.notFound().build();
}
@GetMapping
public List<MembershipType> getAll(){
ensureData();
return types;
}
@GetMapping("/{id}")
public ResponseEntity<MembershipType> getById(@PathVariable Long id){
ensureData();
for(MembershipType t:types) if(t.getTypeId().equals(id)) return ResponseEntity.ok(t);
return ResponseEntity.notFound().build();
}
@GetMapping("/name/{name}")
public ResponseEntity<?> getByName(@PathVariable String name){
ensureData();
List<MembershipType> r=types.stream().filter(t->t.getTypeName().equalsIgnoreCase(name)).collect(Collectors.toList());
if(r.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No membership types found");
return ResponseEntity.ok(r);
}
@GetMapping("/price")
public List<MembershipType> getByPriceRange(@RequestParam Double min,@RequestParam Double max){
ensureData();
return types.stream().filter(t->t.getPrice()>=min&&t.getPrice()<=max).collect(Collectors.toList());
}

@GetMapping("/duration-greater/{value}")
public ResponseEntity<?> getByDuration(@PathVariable Integer value){
ensureData();
List<MembershipType> r=types.stream().filter(t->t.getDurationInMonths()>value).collect(Collectors.toList());
if(r.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No membership types found with duration greater than "+value);
return ResponseEntity.ok(r);
}
@GetMapping("/price-less/{value}")
public ResponseEntity<?> getPriceLess(@PathVariable Double value){
ensureData();
List<MembershipType> r=types.stream().filter(t->t.getPrice()<value).collect(Collectors.toList());
if(r.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No membership types found");
return ResponseEntity.ok(r);
}
}