package com.alunoonline.api.repository;

import com.alunoonline.api.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

        public List<Student> findStudentByName(String name);
        @Query("Select u from Student u where u.name=:name and u.email=:email")
        public List<Student> findStudentByNameAndEmail(@Param("name") String name,@Param("email") String email);

        public List<Student>findAllByOrderByNameAsc();

        @Query("Select u from Student u where u.name=:name")
        public List<Student>  searchByName(@Param("name") String name);



}
