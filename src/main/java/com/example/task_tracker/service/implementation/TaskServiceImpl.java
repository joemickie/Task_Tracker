package com.example.task_tracker.service.implementation;

import com.example.task_tracker.dto.TaskCreationDto;
import com.example.task_tracker.dto.TaskDto;
import com.example.task_tracker.dto.TaskUpdateDto;
import com.example.task_tracker.entities.Task;
import com.example.task_tracker.enums.TaskStatus;
import com.example.task_tracker.exception.EntityNotFoundException;
import com.example.task_tracker.exception.IllegalEntityStateException;
import com.example.task_tracker.repositories.StudentRepository;
import com.example.task_tracker.repositories.TaskRepository;
import com.example.task_tracker.service.TaskService;
import com.example.task_tracker.util.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final StudentRepository studentRepository;

    @Override
    public TaskDto createTask(TaskCreationDto taskCreationDto) {
        return Mapper.taskToTaskDto(taskRepository.save(
                Task.builder()
                        .title(taskCreationDto.getTitle())
                        .description(taskCreationDto.getDescription())
                        .status(TaskStatus.PENDING)
                        .student(studentRepository.findById(taskCreationDto.getStudentId()).orElseThrow(()->new EntityNotFoundException("student not available", "this student doesn't exist in th database")))
                        .build()
        ));
    }

    @Override
    public TaskDto updateTask(TaskUpdateDto taskUpdateRequest, Long taskId) {
        Task task = getTask(taskId);
        task.setTitle(taskUpdateRequest.getTitle());
        task.setDescription(taskUpdateRequest.getDescription());
        taskRepository.save(task);
        return Mapper.taskToTaskDto(task);

    }

    @Override
    public Task getTask(Long id) {
        return taskRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("Task Not Found", "No task with this ID in database")
        );
    }
    @Override
    public TaskDto getTaskDto(Long id) {
        return Mapper.taskToTaskDto(taskRepository.findById(id).orElseThrow(
                ()->new EntityNotFoundException("Task Not Found","No task with the ID in our record")));
    }
    @Override
    public List<TaskDto> findAllByUserId(Long studentId) {

        return taskRepository.findTasksByStudent_Id(studentId)
                .stream().map(Mapper::taskToTaskDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TaskDto> getTasksByStatus(TaskStatus status, Long studentId) {

        return taskRepository.findTasksByStudent_IdAndStatus(studentId, status)
                .stream().map(Mapper::taskToTaskDto)
                .collect(Collectors.toList());
    }

//    @Override
//    public TaskDto resetStatus(TaskStatus status, Long taskId) {
//        Task task= getTask(taskId);
//        if (task.getStatus()==status) throw new IllegalEntityStateException("Illegal Object Update",
//                "Status cannot be changed to same state");
//        if(task.getStatus()!=TaskStatus.DONE) task.setCompletedAt(null);
//        task.setStatus(status);// change the state of the object
//        if(task.getStatus()==TaskStatus.DONE) task.setCompletedAt(new Date());
//        return Mapper.taskToTaskDto(taskRepository.saveAndFlush(task));
//    }

    @Override
    public TaskDto resetStatus(TaskStatus status, Long taskId) {
        Task task = getTask(taskId);
        if (Objects.equals(task.getStatus(), status)) {
            throw new IllegalEntityStateException("Illegal Object Update",
                    "Status cannot be changed to the same state");
        }
        if (task.getStatus() != TaskStatus.DONE) {
            task.setCompletedAt(null);
        }
        task.setStatus(status);
        if (task.getStatus() == TaskStatus.DONE) {
            task.setCompletedAt(LocalDateTime.now());
        } else {
            task.setCompletedAt(null); // Reset completedAt to null if status is not DONE
        }
        return Mapper.taskToTaskDto(taskRepository.saveAndFlush(task));
    }


    public void delete(Long taskId){
        taskRepository.deleteById(taskId);
    }

}
