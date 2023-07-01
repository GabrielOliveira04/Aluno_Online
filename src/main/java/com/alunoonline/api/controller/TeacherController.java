package com.alunoonline.api.controller;


import com.alunoonline.api.model.Teacher;
import com.alunoonline.api.service.TeacherService;
import jakarta.websocket.server.PathParam;
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
    @GetMapping("nome/{nome}")
    public ResponseEntity<List<Teacher>>searchByName(@PathVariable("nome") String name){
        return ResponseEntity.ok(service.seachByName(name));
    }



   @GetMapping("nome,email/{nome}/{email}")
   public ResponseEntity<List<Teacher>>findTeacherByNameAndEmail(@PathVariable("nome") String name,@PathVariable("email")String email){
        return ResponseEntity.ok(service.findTeacherByNameAndEmail(name, email));
   }





}
