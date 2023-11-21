package com.example.task_tracker.entities;

import com.example.task_tracker.enums.TaskStatus;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity(name = "Task")
@Table(name ="task")
@EntityListeners(AuditingEntityListener.class)
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @NonNull
    private String description;
    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    @CreatedDate
    private Timestamp createdAt;
    @LastModifiedDate
    private Timestamp updatedAt;
    private LocalDateTime completedAt;
//    private Date completedAt;
    @ManyToOne
    @JoinColumn(name="student_id", referencedColumnName = "id")
    private Student student;


}
