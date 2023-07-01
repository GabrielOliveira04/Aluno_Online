package com.alunoonline.api.service;

import com.alunoonline.api.model.Teacher;
import com.alunoonline.api.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class TeacherService {


    @Autowired
    TeacherRepository repository;

    public Teacher create(Teacher teacher){
        return repository.save(teacher);
    }



    public List<Teacher> findAll(){
        return repository.findAll();
    }


    public Optional<Teacher>findById(Long id){
        return repository.findById(id);
    }


    public List<Teacher>seachByName(String name){
        return repository.searchByName(name);
    }
}
