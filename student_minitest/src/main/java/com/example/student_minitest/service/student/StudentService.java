package com.example.student_minitest.service.student;

import com.example.student_minitest.model.Student;
import com.example.student_minitest.repo.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepository studentRepository;

    @Override
    public Iterable<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void remove(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Iterable<Student> findAllByNameContaining(String key) {
        return studentRepository.findAllByNameContaining(key);
    }

    @Override
    public Iterable<Student> findAllOrderByAge() {
        return studentRepository.findAllOrderByAge();
    }
}
