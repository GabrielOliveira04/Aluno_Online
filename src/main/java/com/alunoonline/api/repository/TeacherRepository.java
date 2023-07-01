package com.alunoonline.api.repository;

import com.alunoonline.api.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {

        public List<Teacher>findTeacherByName(String name);

        public List<Teacher>findTeacherByNameAndEmail(String name, String email);

        public List<Teacher>findAllByTeacherOrderByNameAsc();
        @Query("select u from Teacher u where u.name=:name")
        public List<Teacher>searchByName(@Param("name") String name);
}
