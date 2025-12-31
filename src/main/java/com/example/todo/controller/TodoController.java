package com.example.todo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;


@RestController
@RequestMapping("/todos")
public class TodoController {
    
    private final TodoService service;

    public TodoController(TodoService service) {
        this.service=service;
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return service.createTodo(todo);
    }

    @GetMapping
    public List<Todo> getAll() {
        return service.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getById(@PathVariable Long id) {
        return service.getTodoById(id);
    }

    @PutMapping("/{id}")
    public Todo update(@PathVariable Long id, @RequestBody Todo todo) {
        return service.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        service.deleteTodo(id);
    }
}
