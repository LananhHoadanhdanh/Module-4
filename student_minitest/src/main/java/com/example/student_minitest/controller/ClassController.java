package com.example.student_minitest.controller;

import com.example.student_minitest.model.ClassRoom;
import com.example.student_minitest.model.Student;
import com.example.student_minitest.service.class_room.IClassRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/classes")
public class ClassController {
    @Autowired
    private IClassRoomService classRoomService;

    @GetMapping("")
    public ResponseEntity<Iterable<ClassRoom>> findAllClass() {
        List<ClassRoom> classRooms = (List<ClassRoom>) classRoomService.findAll();
        if (classRooms.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } return new ResponseEntity<>(classRooms, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassRoom> findClassById(@PathVariable Long id) {
        Optional<ClassRoom> classRoomOptional = classRoomService.findById(id);
        if (!classRoomOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(classRoomOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClassRoom> saveClass(@RequestBody ClassRoom classRoom) {
        return new ResponseEntity<>(classRoomService.save(classRoom), HttpStatus.CREATED);
    }
}
