package com.example.todo.data.dto;

import com.example.todo.data.entity.Todo;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public class TodoResponseDto {
    private UUID id;
    private String content;
    private Boolean isDone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static TodoResponseDto toDto(Todo todo) {
        return TodoResponseDto.builder()
                .id(todo.getId())
                .content(todo.getContent())
                .isDone(todo.getIsDone())
                .createdAt(todo.getCreatedAt())
                .updatedAt(todo.getUpdatedAt())
                .build();
    }
}
