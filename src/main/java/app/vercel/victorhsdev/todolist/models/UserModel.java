package app.vercel.victorhsdev.todolist.models;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "tb_users")
@Data // This implements getters and setters automatically
public class UserModel {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String name;
  private String email;
  private String password;

  @CreationTimestamp // Generate the now() automatically
  private LocalDateTime createdAt;
  
  public UserModel(String name, String email, String password) {
    this.name = name;
    this.email = email;
    this.password = password;
  }

}
