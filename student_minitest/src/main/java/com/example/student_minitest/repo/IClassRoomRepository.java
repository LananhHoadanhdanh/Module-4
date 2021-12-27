package com.example.student_minitest.repo;

import com.example.student_minitest.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassRoomRepository extends JpaRepository<ClassRoom, Long> {
}
