package app.vercel.victorhsdev.todolist.models;

import java.util.UUID;

import lombok.Data;

@Data // This implements getters and setters automatically
public class UserModel {

  private UUID id;
  private String name;
  private String email;
  private String password;
  
  public UserModel(String name, String email, String password) {
    id = UUID.randomUUID();
    this.name = name;
    this.email = email;
    this.password = password;
  }

}
