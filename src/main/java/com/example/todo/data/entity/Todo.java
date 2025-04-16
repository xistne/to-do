package com.example.todo.data.entity;

import com.example.todo.data.dto.TodoDto;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "todo")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Todo extends BaseEntity {

    @Id
    @UuidGenerator
    @Column(name = "todo_id", nullable = false, updatable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private String userId;

    @Column(name = "content")
    private String content;

    @Column(name = "is_done")
    private Boolean isDone;

    public void update(TodoDto todoDto) {
        this.content = todoDto.getContent();
        this.isDone = todoDto.getIsDone();
    }

}
