package app.vercel.victorhsdev.todolist.models;

import java.time.LocalDateTime;
import java.util.UUID;

import lombok.Data;

@Data // This implements getters and setters automatically
public class TodoModel {

  private UUID id;
  private String name;
  private boolean completed;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public TodoModel( String name, boolean completed, LocalDateTime createdAt, LocalDateTime updatedAt) {

    this.id = UUID.randomUUID();
    this.name = name;
    this.completed = completed;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }
  
}
