package app.vercel.victorhsdev.todolist.repositories;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import app.vercel.victorhsdev.todolist.models.TodoModel;
import jakarta.annotation.PostConstruct;

@Repository
public class TodoRepository {

  private List<TodoModel> todos = new ArrayList<TodoModel>();

  public TodoModel save(TodoModel todo) {
    todos.add(todo);
    return todo;
  }

  public List<TodoModel> getAll() {
    return todos;
  }

  @PostConstruct
  public void generateMockedData() {

    TodoModel todo1 = new TodoModel("Tarefa 01",false,LocalDateTime.now(),LocalDateTime.now());
    TodoModel todo2 = new TodoModel("Tarefa 02",false,LocalDateTime.now(),LocalDateTime.now());

    save(todo1);
    save(todo2);
  }

}
