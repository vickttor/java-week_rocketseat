package app.vercel.victorhsdev.todolist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.vercel.victorhsdev.todolist.models.UserModel;
import app.vercel.victorhsdev.todolist.repositories.UserRepository;
import at.favre.lib.crypto.bcrypt.BCrypt;

@RestController
@RequestMapping("/users")
public class UserController {
  
  @Autowired
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
    var users = repository.findAll();
    return ResponseEntity.ok(users);
  }

  @PostMapping("")
  public ResponseEntity create(@RequestBody UserModel user) {
    var existingUser = repository.findByEmail(user.getEmail());

    if(existingUser == null) {
      var passwordHashed = BCrypt.withDefaults().hashToString(12, user.getPassword().toCharArray());
      user.setPassword(passwordHashed);

      var userCreated = repository.save(user);
      return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }
  
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("E-mail already exists");
  }

}
