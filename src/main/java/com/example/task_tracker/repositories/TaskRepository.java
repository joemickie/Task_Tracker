package com.example.task_tracker.repositories;

import com.example.task_tracker.entities.Task;
import com.example.task_tracker.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findTasksByStudent_IdAndStatus  (Long student_id, TaskStatus status);

    List<Task> findTasksByStudent_Id (Long userId);


}
