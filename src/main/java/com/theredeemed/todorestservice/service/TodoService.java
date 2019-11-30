package com.theredeemed.todorestservice.service;

import com.theredeemed.todorestservice.model.Todo;
import com.theredeemed.todorestservice.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todoList = new ArrayList<>();
    private static int todoCounter = 0;

    private TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    static {
        todoList.add(new Todo((long) ++todoCounter, "Abdoul", "Learn React", new Date(), false));
        todoList.add(new Todo((long) ++todoCounter, "Abdoul", "Learn css grid and flexblox", new Date(), false));
        todoList.add(new Todo((long) ++todoCounter, "Abdoul", "Learn Java", new Date(), false));
        todoList.add(new Todo((long) ++todoCounter, "Abdoul", "Learn Groovy", new Date(), false));
        todoList.add(new Todo((long) ++todoCounter, "Abdoul", "Learn Spring Boot", new Date(), false));
        todoList.add(new Todo((long) ++todoCounter, "Abdoul", "Learn Database and SQL", new Date(), false));
        todoList.add(new Todo((long) ++todoCounter, "Abdoul", "Learn Hibernate", new Date(), false));
    }

    public List<Todo> getAllTodosByUsername(String username) {
        return todoRepository.findAllByUsername(username);
    }

    public Todo saveOrUpdateTodo(Todo todo, String username) {
//        if (todo.getId() == null) {
//            todo.setId((long) ++todoCounter);
//            todoList.add(todo);
//        } else {
//            deleteTodoyId(todo.getId());
//            todoList.add(todo);
//        }
//        return todo;
        todo.setUsername(username);
        return todoRepository.save(todo);
    }

    public void deleteTodoyId(long id) {
//        Todo todo = findTodoById(id);
//        if (todo == null) return null;
//        if (todoList.remove(todo)) return todo;
//        return null;
        todoRepository.deleteById(id);
    }

    public Todo findTodoById(long id) {
        return todoRepository.findById(id).get();
    }
}
