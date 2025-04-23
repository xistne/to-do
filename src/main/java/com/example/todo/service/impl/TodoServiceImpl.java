package com.example.todo.service.impl;

import com.example.todo.data.dto.TodoDto;
import com.example.todo.data.dto.TodoResponseDto;
import com.example.todo.data.entity.Todo;
import com.example.todo.data.repository.TodoRepository;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public TodoResponseDto create(TodoDto todoDto) {
        Todo todo = this.todoRepository.save(TodoDto.toEntity(todoDto));
        return TodoResponseDto.toDto(todo);
    }

    @Override
    public List<TodoResponseDto> retrieve(String userId) {
        List<Todo> todos = this.todoRepository.findByUserId(userId);
        return todos.stream()
                .map(todo ->{
                    return TodoResponseDto.toDto(todo);
                }).collect(Collectors.toList());
    }

    @Override
    public TodoResponseDto update(UUID uuid, TodoDto todoDto) {
        Todo todo = this.todoRepository.findById(uuid).orElseThrow(() -> new RuntimeException());
        todo.update(todoDto);
        return TodoResponseDto.toDto(todo);
    }

    @Override
    public void delete(UUID todoId) {
        Todo todo = this.todoRepository.findById(todoId).orElseThrow(() -> new RuntimeException());
        // TODO : 사용자 인증 후 삭제
        todoRepository.delete(todo);
    }
}
