package com.alunoonline.api.controller;


import com.alunoonline.api.model.Teacher;
import com.alunoonline.api.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class TeacherController {

    @Autowired
    TeacherService service;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Teacher> create(@RequestBody Teacher teacher){
        Teacher teacherCreated = service.create(teacher);

        return ResponseEntity.status(201).body(teacherCreated);
    }

    @GetMapping("/listar-todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Teacher> findAll(){
        return service.findAll();
    }



    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Teacher>findById(@PathVariable Long id){
        return  service.findById(id);
    }


}
