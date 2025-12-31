package com.example.todo.service;

import org.springframework.stereotype.Service;
import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {
    
    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository=repository;
    }

    public Todo createTodo(Todo todo) {
        return repository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

   public Todo getTodoById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
}


    public Todo updateTodo(Long id, Todo todo) {
        Todo existing = getTodoById(id);
        existing.setTitle(todo.getTitle());
        existing.setCompleted(todo.isCompleted());
        return repository.save(existing);
    }

    public void deleteTodo(Long id) {
        repository.deleteById(id);
    }
}
