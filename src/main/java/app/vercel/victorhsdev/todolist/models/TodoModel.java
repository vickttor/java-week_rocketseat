package app.vercel.victorhsdev.todolist.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data // This implements getters and setters automatically
@Entity(name = "tb_todo")
public class TodoModel {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;
  private String name;
  private boolean completed;

  @CreationTimestamp
  private LocalDateTime createdAt;
  @CreationTimestamp
  private LocalDateTime updatedAt;
    
}
