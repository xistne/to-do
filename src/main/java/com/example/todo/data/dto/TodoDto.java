package com.example.todo.data.dto;

import com.example.todo.data.entity.Todo;
import lombok.Getter;

@Getter
public class TodoDto {
    private String content;
    private Boolean isDone;

    public static Todo toEntity(TodoDto todoDto) {
        return Todo.builder()
                .content(todoDto.getContent())
                .isDone(todoDto.getIsDone())
                .build();
    }
}
