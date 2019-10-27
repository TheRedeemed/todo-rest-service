package com.theredeemed.todorestservice.controller;

import com.theredeemed.todorestservice.model.Todo;
import com.theredeemed.todorestservice.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getTodos(@PathVariable String username) {
        return todoService.getAllTodos();
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable String username, @PathVariable long id) {
        Todo todo = todoService.deleteTodoyId(id);

        if (todo != null) return ResponseEntity.noContent().build();

        return ResponseEntity.notFound().build();
    }
}
