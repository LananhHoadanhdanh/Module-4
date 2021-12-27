package com.example.student_minitest.service.class_room;

import com.example.student_minitest.model.ClassRoom;
import com.example.student_minitest.repo.IClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassRoomService implements IClassRoomService{
    @Autowired
    private IClassRoomRepository classRoomRepository;

    @Override
    public Iterable<ClassRoom> findAll() {
        return classRoomRepository.findAll();
    }

    @Override
    public Optional<ClassRoom> findById(Long id) {
        return classRoomRepository.findById(id);
    }

    @Override
    public ClassRoom save(ClassRoom classRoom) {
        return classRoomRepository.save(classRoom);
    }

    @Override
    public void remove(Long id) {
    }
}
