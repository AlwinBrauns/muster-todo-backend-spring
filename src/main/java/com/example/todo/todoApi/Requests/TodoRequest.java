package com.example.todo.todoApi.Requests;

import lombok.Data;

@Data
public class TodoRequest {
    private String text;
    private boolean checked;
}
