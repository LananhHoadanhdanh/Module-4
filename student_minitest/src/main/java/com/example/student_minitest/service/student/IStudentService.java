package com.example.student_minitest.service.student;

import com.example.student_minitest.model.Student;
import com.example.student_minitest.service.IGeneralService;

public interface IStudentService extends IGeneralService<Student> {
    Iterable<Student> findAllByNameContaining(String key);
    Iterable<Student> findAllOrderByAge();
}
