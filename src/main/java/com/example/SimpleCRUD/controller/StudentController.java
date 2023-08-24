package com.example.SimpleCRUD.controller;

import com.example.SimpleCRUD.model.Student;
import com.example.SimpleCRUD.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student/")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getAll(){
        return studentService.getStudents();
    }
    @GetMapping("{id}")
    public Optional<Student> getStudent(@PathVariable Long id){
        return studentService.getStudent(id);
    }

    @PostMapping
    public void create(@RequestBody Student student){
        studentService.saveOrUpdate(student);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        studentService.delete(id);
    }
}
