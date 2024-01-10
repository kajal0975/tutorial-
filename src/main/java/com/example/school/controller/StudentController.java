package com.example.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.school.model.Student;
import com.example.school.service.StudentH2Service;

import java.util.ArrayList;

@RestController
public class StudentController {

    @Autowired
    private StudentH2Service studentH2Service;

    @GetMapping("/students")
    public ArrayList<Student> getStudents() {
        return studentH2Service.getStudents();
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentById(@PathVariable("studentId") int studentId) {
        return studentH2Service.getStudentById(studentId);
    }

    @PostMapping("/students")
    public Student addsinglStudent(@RequestBody Student student) {
        return studentH2Service.addSinglStudent(student);
    }

    @PostMapping("/students/bulk")
    public String addMultipleStudents(@RequestBody ArrayList<Student> student) {
        return studentH2Service.addMultipleStudents(student);
    }

    @PutMapping("/students/{studentId}")
    public Student updatStudent(@PathVariable("studentId") int studentId, @RequestBody Student student) {
        return studentH2Service.updateStudent(studentId, student);
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable int studentId) {
        studentH2Service.deleteStudent(studentId);
    }

}
