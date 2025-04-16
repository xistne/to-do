package com.example.todo.service;

import com.example.todo.data.dto.TodoDto;
import com.example.todo.data.dto.TodoResponseDto;

import java.util.List;
import java.util.UUID;

public interface TodoService {
    TodoResponseDto create(TodoDto todoDto);

    List<TodoResponseDto> retrieve(String userId);

    TodoResponseDto update(UUID uuid, TodoDto todoDto);

    void delete(UUID todoId);
}
