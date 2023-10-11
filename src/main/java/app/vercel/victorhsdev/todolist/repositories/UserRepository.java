package app.vercel.victorhsdev.todolist.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import app.vercel.victorhsdev.todolist.models.UserModel;


public interface UserRepository extends JpaRepository<UserModel, UUID> {}
