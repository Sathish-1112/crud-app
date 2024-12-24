package com.application.appliaction.controller;

import com.application.appliaction.model.Student;
import com.application.appliaction.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class StudentController {

    @Autowired
    private StudentService service;
    @RequestMapping("/stu")
    public String hello(){
        return "heloo";
    }

    @GetMapping("/stu/liststudents")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>( service.getAllStudents(), HttpStatus.OK);
    }

@GetMapping("/getstu/{id}")
public ResponseEntity<Student> getStudentsbyId(@PathVariable int id) {
    Student student = service.getStudentsbyId(id);
    if (student != null) {
        return ResponseEntity.ok(student);
    } else {
        return ResponseEntity.notFound().build();
    }
}

    @PostMapping("/addstu")
    public ResponseEntity<?> addstudent(@RequestBody Student stu) {
        service.addstudent(stu);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/updatestu")
    public ResponseEntity<Void> updatestudent(@RequestBody Student stu) {
        service.updatestudent(stu);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<Void> deletestudent(@PathVariable int id) {
        service.deletestudent(id);
        return ResponseEntity.noContent().build();
    }

}
