package app.vercel.victorhsdev.todolist.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.vercel.victorhsdev.todolist.models.TodoModel;
import app.vercel.victorhsdev.todolist.repositories.TodoRepository;

@RestController
@RequestMapping("/todos")
public class TodoController {

  private TodoRepository repository;

  public TodoController(TodoRepository repository){
    this.repository = repository;
  }

  @GetMapping("")
  public ResponseEntity<List<TodoModel>> getAll() {

    return ResponseEntity.ok(repository.findAll());
  }

}
