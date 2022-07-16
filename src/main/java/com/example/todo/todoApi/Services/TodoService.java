package com.example.todo.todoApi.Services;

import com.example.todo.todoApi.Entities.Todo;
import com.example.todo.todoApi.Repositories.TodoRepository;
import com.example.todo.todoApi.Requests.TodoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Todo newTodo(TodoRequest todo) {
        return todoRepository.save(Todo.builder()
                .checked(todo.isChecked())
                .text(todo.getText())
                .date(new Date())
                .externalId(UUID.randomUUID())
                .build()
        );
    }

    public Todo updateTodo(Todo todo) {
        todo.setId(todoRepository.findByExternalId(todo.getExternalId()).getId());
        return todoRepository.save(todo);
    }

    public void deleteTodo(String externalId) {
        Todo todo = todoRepository.findByExternalId(UUID.fromString(externalId));
        todoRepository.delete(todo);
    }
}
