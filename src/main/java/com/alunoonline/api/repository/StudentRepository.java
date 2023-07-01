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

        public List<Student> findStudentByNameAndEmail(String name,String email);

        public List<Student>findAllByStudentOrderByNameAsc();
        @Query("Select u from Student u where u.name=:name")
        public List<Student>  searchByName(@Param("name") String name);


}
