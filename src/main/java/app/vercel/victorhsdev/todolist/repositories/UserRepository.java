package app.vercel.victorhsdev.todolist.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import app.vercel.victorhsdev.todolist.DTO.CreateUserDTO;
import app.vercel.victorhsdev.todolist.models.UserModel;
import jakarta.annotation.PostConstruct;

@Repository
public class UserRepository {

  private List<UserModel> users = new ArrayList<UserModel>();

  public UserModel createUser(CreateUserDTO user) {

    UserModel newUser = new UserModel(user.name(), user.email(), user.password());
    users.add(newUser);
    return newUser;
  }

  public List<UserModel> getAll() {
    return users;
  }


  @PostConstruct
  public void generateMockedData() {

    CreateUserDTO newUser = new CreateUserDTO("Victor H. Silva", "victor.silvaPC@hotmail.com", "12345");

    createUser(newUser);
  }


}
