package com.example.task_tracker.repositories;

import com.example.task_tracker.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    Optional<Student> findByEmailAndPassword(String email, String password);


}
