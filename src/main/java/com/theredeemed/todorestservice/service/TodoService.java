package com.theredeemed.todorestservice.service;

import com.theredeemed.todorestservice.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {

    private static List<Todo> todoList = new ArrayList<>();
    private static int todoCounter = 0;

    static {
        todoList.add(new Todo((long) ++todoCounter, "Abdoul", "Learn React", new Date(), false));
        todoList.add(new Todo((long) ++todoCounter, "Abdoul", "Learn css grid and flexblox", new Date(), false));
        todoList.add(new Todo((long) ++todoCounter, "Abdoul", "Learn Java", new Date(), false));
        todoList.add(new Todo((long) ++todoCounter, "Abdoul", "Learn Groovy", new Date(), false));
        todoList.add(new Todo((long) ++todoCounter, "Abdoul", "Learn Spring Boot", new Date(), false));
        todoList.add(new Todo((long) ++todoCounter, "Abdoul", "Learn Database and SQL", new Date(), false));
        todoList.add(new Todo((long) ++todoCounter, "Abdoul", "Learn Hibernate", new Date(), false));
    }

    public List<Todo> getAllTodos() {
        return todoList;
    }

    public Todo deleteTodoyId(long id) {
        Todo todo = findTodoById(id);

        if (todo == null) return null;
        if (todoList.remove(todo)) return todo;

        return null;
    }

    private Todo findTodoById(long id) {
        for (Todo todo : todoList) {
            if(todo.getId() == id) return todo;
        }
        return null;
    }
}
