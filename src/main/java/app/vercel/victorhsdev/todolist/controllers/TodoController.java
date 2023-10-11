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

import app.vercel.victorhsdev.todolist.models.TodoModel;
import app.vercel.victorhsdev.todolist.repositories.TodoRepository;

@RestController
@RequestMapping("/todos")
public class TodoController {

  @Autowired
  private TodoRepository repository;

  public TodoController(TodoRepository repository){
    this.repository = repository;
  }

  @GetMapping("")
  public ResponseEntity<List<TodoModel>> getAll() {
    return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
  }

  @PostMapping("")
  public ResponseEntity<TodoModel> create(@RequestBody TodoModel todo) {
    var createdTodo = repository.save(todo);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
  }

}
