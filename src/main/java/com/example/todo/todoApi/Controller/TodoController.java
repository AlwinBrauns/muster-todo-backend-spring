package com.example.todo.todoApi.Controller;

import com.example.todo.todoApi.Entities.Todo;
import com.example.todo.todoApi.Requests.TodoRequest;
import com.example.todo.todoApi.Services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/todo")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/all")
    public ResponseEntity<List<Todo>> getAllTodos(){
        List<Todo> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    @PostMapping
    public ResponseEntity<Todo> newTodo(
            @RequestBody TodoRequest todo
    ){
        Todo newTodo = todoService.newTodo(todo);
        return ResponseEntity.ok(newTodo);
    }

    @PutMapping
    public ResponseEntity<?> updateTodo(
            @RequestBody Todo todo
    ){
        Todo updatedTodo = todoService.updateTodo(todo);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/{externalId}")
    public ResponseEntity<?> deleteTodo(
            @PathVariable String externalId
    ){
        todoService.deleteTodo(externalId);
        return ResponseEntity.ok().build();
    }
}
