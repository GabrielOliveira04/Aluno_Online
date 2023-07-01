package com.alunoonline.api.controller;

import com.alunoonline.api.model.Student;
import com.alunoonline.api.service.StudentService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/aluno")
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Student> create(@RequestBody Student student){
        Student studentCreated = service.create(student);

        return ResponseEntity.status(201).body(studentCreated);
    }
    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Student>findById(@PathVariable Long id){
        return service.findById(id);
    }

    @GetMapping("nome/{nome}")
    public ResponseEntity<List<Student>>searchByName(@PathVariable("nome") String name){
        return ResponseEntity.ok(service.searchByName(name));
    }

    @GetMapping("nome,email/{nome}/{email}")
    public ResponseEntity<List<Student>>findStudentByNameAndEmail(@PathVariable("nome")String name,@PathVariable("email") String email){
        return ResponseEntity.ok(service.findStudentByNameAndEmail(name,email));
    }
}
