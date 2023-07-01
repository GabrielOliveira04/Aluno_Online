package com.alunoonline.api.service;

import com.alunoonline.api.model.Student;
import com.alunoonline.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    @Autowired
    StudentRepository repository;
    public Student create(Student student){
        return repository.save(student);

    }

    public List<Student> findAll(){
        return repository.findAll();
    }


    public Optional<Student>findById(Long id){
        return repository.findById(id);
    }

    public List<Student>searchByName(String name){
        return repository.searchByName(name);
    }


    public List<Student> findStudentByNameAndEmail(String name, String email){
        return repository.findStudentByNameAndEmail(name, email);
    }

}
