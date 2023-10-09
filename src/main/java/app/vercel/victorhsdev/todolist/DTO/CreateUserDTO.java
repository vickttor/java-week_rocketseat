package app.vercel.victorhsdev.todolist.DTO;

public record CreateUserDTO(
  String name,
  String email,
  String password
) {}
