package com.example.todo.todoApi.Repositories;

import com.example.todo.todoApi.Entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    Todo findByExternalId(UUID uuid);
}
