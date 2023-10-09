package app.vercel.victorhsdev.todolist.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.vercel.victorhsdev.todolist.DTO.CreateUserDTO;
import app.vercel.victorhsdev.todolist.models.UserModel;
import app.vercel.victorhsdev.todolist.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
  
  private UserRepository repository;

  public UserController(UserRepository repository) {
    this.repository = repository;
  }


  /*
   * String (texto)
   * Integer (int) numeros inteiros
   * Double () números decimais
   * Float números decimais com tamanho menor do que o Double
   * char (A C) caracteres
   * Date (data)
   * void (vazio)
   * 
   */

  @GetMapping("")
  public ResponseEntity<List<UserModel>> getAll() {
    return ResponseEntity.ok(repository.getAll());
  }

  @PostMapping("")
  public void create(@RequestBody CreateUserDTO user)   {
    repository.createUser(user);
  }

}
