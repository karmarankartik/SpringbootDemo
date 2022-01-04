package com.example.demo.repositories;

import javax.transaction.Transactional;

import com.example.demo.entities.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    public static final String STUDENT_UPDATE_QUERY = "UPDATE STUDENT u set u.GENDER =:gender where u.id =:id";


@Transactional
@Modifying(clearAutomatically = true, flushAutomatically = true)
@Query(value = STUDENT_UPDATE_QUERY , nativeQuery = true)
int updateStudent(@Param("gender") String gender ,@Param("id") Long id);
    
}
