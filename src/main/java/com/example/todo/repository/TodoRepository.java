package com.example.todo.repository;

import org.springframework.stereotype.Repository;
import com.example.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TodoRepository extends  JpaRepository<Todo, Long> {
    
}
