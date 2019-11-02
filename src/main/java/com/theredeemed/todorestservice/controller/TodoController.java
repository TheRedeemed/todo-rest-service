package com.theredeemed.todorestservice.controller;

import com.theredeemed.todorestservice.model.Todo;
import com.theredeemed.todorestservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getTodos(@PathVariable String username) {
        return todoService.getAllTodos();
    }

    @GetMapping("/users/{username}/todo/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
        return todoService.findTodoById(id);
    }

    @PutMapping("/users/{username}/todo/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,
                                           @RequestBody Todo todo) {
        Todo updatedTodo = todoService.save(todo);
        return new ResponseEntity<>(todo, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todo")
    public ResponseEntity<Todo> createTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo createdTodo = todoService.save(todo);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED);
    }

    @DeleteMapping("/users/{username}/todo/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable String username, @PathVariable long id) {
        Todo todo = todoService.deleteTodoyId(id);

        if (todo != null) return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }
}
