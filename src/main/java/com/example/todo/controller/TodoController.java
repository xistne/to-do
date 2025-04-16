package com.example.todo.controller;

import com.example.todo.data.dto.ApiResponse;
import com.example.todo.data.dto.TodoDto;
import com.example.todo.data.dto.TodoResponseDto;
import com.example.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TodoResponseDto>> createToDo(@RequestBody TodoDto todoDto) {
        return ResponseEntity.ok(ApiResponse.success(this.todoService.create(todoDto), HttpStatus.OK));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TodoResponseDto>>> retrieveTodDoList() {
        String tempUserId = "temp-user";
        return ResponseEntity.ok(ApiResponse.success(this.todoService.retrieve(tempUserId), HttpStatus.OK));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<TodoResponseDto>> updateToDo(@PathVariable UUID id, @RequestBody TodoDto todoDto) {
        return ResponseEntity.ok(ApiResponse.success(this.todoService.update(id, todoDto), HttpStatus.OK));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteToDo(@PathVariable UUID id) {
        this.todoService.delete(id);
        return ResponseEntity.ok(ApiResponse.<Void>success(null,HttpStatus.NO_CONTENT));
    }

}
