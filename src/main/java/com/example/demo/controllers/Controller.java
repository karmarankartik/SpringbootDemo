package com.example.demo.controllers;

import com.example.demo.entities.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController()
@RequestMapping("student")
public class Controller {

    @Autowired
    StudentRepository repo;

@GetMapping("/ping")
public String ping(){
        return "Up";
    }

    @GetMapping("/all")
    public ResponseEntity<Object> getStudents(){
        return ResponseEntity.ok().body(repo.findAll());
    }

    @PostMapping("/")
    public ResponseEntity<Object> insertStudent(@RequestBody Student s){
        repo.save(s);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable Long id ){
        repo.deleteById(id);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findStudent(@PathVariable Long id){
        return ResponseEntity.ok().body(repo.findById(id));
    }

    @PatchMapping("/")
    public ResponseEntity<Object> modifyStudent(@RequestBody Student s){
        return ResponseEntity.ok().body(repo.updateStudent(s.getGender(),s.getId()));
    }


    
}
