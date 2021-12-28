package com.example.student_minitest.repo;

import com.example.student_minitest.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    Iterable<Student> findAllByNameContaining(String key);

    @Query("select s from Student s order by s.age desc")
    Iterable<Student> findAllOrderByAge();
}
